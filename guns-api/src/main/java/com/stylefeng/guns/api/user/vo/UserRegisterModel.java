package com.stylefeng.guns.api.user.vo;

import java.io.Serializable;

/**
 * @description: 注册用
 * @author: Lime
 * @create: 2019-08-29 12:07
 **/

public class UserRegisterModel implements Serializable
{
    private static final long serialVersionUID = 117939396214468934L;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
