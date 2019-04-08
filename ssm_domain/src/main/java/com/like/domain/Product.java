package com.like.domain;

import com.like.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable
{
    private String  id;
    private String  productNum; //编号
    private String  productName;
    private String  cityName;    //出发城市

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date    departureTime; //出发时间
    private String  departureTimeStr;
    private Double  productPrice;
    private String  productDesc;
    private Integer productStatus; //状态:0关闭,1开启
    private String  productStatusStr;

    @Override
    public String toString()
    {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getProductNum()
    {
        return productNum;
    }

    public void setProductNum(String productNum)
    {
        this.productNum = productNum;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public Date getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr()
    {
        if (departureTime != null) {
            departureTimeStr = DateUtils.date2String(departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr)
    {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice()
    {
        return productPrice;
    }

    public void setProductPrice(Double productPrice)
    {
        this.productPrice = productPrice;
    }

    public String getProductDesc()
    {
        return productDesc;
    }

    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus()
    {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus)
    {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr()
    {
        if (productStatus != null) {
            if (productStatus == 1)
                productStatusStr = "开启";
            if (productStatus == 0)
                productStatusStr = "关闭";
        }

        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr)
    {
        this.productStatusStr = productStatusStr;
    }
}
