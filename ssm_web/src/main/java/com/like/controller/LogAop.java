package com.like.controller;

import com.like.domain.SysLog;
import com.like.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAop
{
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始时间
    private Date endTime;   //结束时间
    private Class clazz;    //访问的类
    private Method method;  //访问的方法

    //前置通知:主要获取开始时间,执行的类是哪一个,执行的方法是哪一个
    @Before("execution(* com.like.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException
    {
        visitTime = new Date(); //获取开始时间
        clazz = jp.getTarget().getClass();   //具体访问的类对象
        String methodName = jp.getSignature().getName();    //获取访问方法的名称
        Object[] args = jp.getArgs();       //获取方法的参数

        //获取具体执行的方法的method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);       //只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];

            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }

            method = clazz.getMethod(methodName, classArgs);
        }

    }


    //后置通知:
    @After("execution(* com.like.controller.*.*(..))")
    public void doAfter(JoinPoint jp)
    {
        //获取访问时长
        Long time = new Date().getTime() - visitTime.getTime();

        //获取url
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class) {
            //.1获取类注解的值
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();

                //获取方法上注解的值
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }

            }
        }

        //获取访问ip
        //在web.xml 配置监听器 org.springframework.web.context.request.RequestContextListener
        String remoteAddrIp = httpServletRequest.getRemoteAddr();


        //获取访问的用户
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();


        //将日志相关信息封装到SysLog对象
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);  //执行时长
        sysLog.setIp(remoteAddrIp);
        sysLog.setMethod("[类名]" + clazz.getName() + ",[方法名]" + method.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setVisitTime(visitTime);

        //调用service完成记录
        sysLogService.save(sysLog);

    }
}
