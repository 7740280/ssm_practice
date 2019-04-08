package com.like.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
    /**
     * 日期转换为字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String date2String(Date date, String pattern)
    {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String str, String pattern) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(str);
    }
}
