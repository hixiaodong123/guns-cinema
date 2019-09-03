package com.stylefeng.guns.api.film.vo.film;


import java.io.Serializable;

public class ActorVO implements Serializable {

    private static final long serialVersionUID = -6229472148281344657L;
    private String imgAddress;
    private String directorName;
    private String roleName;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getImgAddress()
    {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress)
    {
        this.imgAddress = imgAddress;
    }

    public String getDirectorName()
    {
        return directorName;
    }

    public void setDirectorName(String directorName)
    {
        this.directorName = directorName;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
}
