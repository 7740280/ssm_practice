package com.like.domain;

import java.util.Date;
import java.util.List;

public class Orders
{
    private Integer id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer orderStatus;
    private Integer peopleCount;
    private Product product;    //产品1对1
    private List<Traveller> travellers; //乘客
    private Member member;      //会员
    private String orderDesc;
    private Integer payType;
    private String payTypeStr;

    @Override
    public String toString()
    {
        return "Orders{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", orderDesc='" + orderDesc + '\'' +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                '}';
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public Date getOrderTime()
    {
        return orderTime;
    }

    public void setOrderTime(Date orderTime)
    {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr()
    {
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr)
    {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getPeopleCount()
    {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount)
    {
        this.peopleCount = peopleCount;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public List<Traveller> getTravellers()
    {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers)
    {
        this.travellers = travellers;
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public String getOrderDesc()
    {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc)
    {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType()
    {
        return payType;
    }

    public void setPayType(Integer payType)
    {
        this.payType = payType;
    }

    public String getPayTypeStr()
    {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr)
    {
        this.payTypeStr = payTypeStr;
    }
}
