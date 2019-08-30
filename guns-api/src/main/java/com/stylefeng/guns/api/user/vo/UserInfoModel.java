package com.stylefeng.guns.api.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: User实体类
 * @author: Lime
 * @create: 2019-08-29 12:05
 **/

public class UserInfoModel implements Serializable
{
    private static final long serialVersionUID = -4669654083290332758L;
    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private long beginTime;
    private long updateTime;

    public UserInfoModel()
    {
    }

    public UserInfoModel(Integer uuid, String username, String nickname, String email, String phone, Integer sex, String birthday, String lifeState, String biography, String address, String headAddress, long beginTime, long updateTime)
    {
        this.uuid = uuid;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.lifeState = lifeState;
        this.biography = biography;
        this.address = address;
        this.headAddress = headAddress;
        this.beginTime = beginTime;
        this.updateTime = updateTime;
    }

    public Integer getUuid()
    {
        return uuid;
    }

    public void setUuid(Integer uuid)
    {
        this.uuid = uuid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getLifeState()
    {
        return lifeState;
    }

    public void setLifeState(String lifeState)
    {
        this.lifeState = lifeState;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getHeadAddress()
    {
        return headAddress;
    }

    public void setHeadAddress(String headAddress)
    {
        this.headAddress = headAddress;
    }

    public long getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(long beginTime)
    {
        this.beginTime = beginTime;
    }

    public long getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(long updateTime)
    {
        this.updateTime = updateTime;
    }
}
