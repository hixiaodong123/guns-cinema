package com.stylefeng.guns.api.film.vo.index;

import java.io.Serializable;

/**
 * @description: Banner的封装类
 * @author: Lime
 * @create: 2019-08-30 17:33
 **/


public class BannerVO implements Serializable
{
    private static final long serialVersionUID = 7000126480578723410L;
    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;

    public String getBannerId()
    {
        return bannerId;
    }

    public void setBannerId(String bannerId)
    {
        this.bannerId = bannerId;
    }

    public String getBannerAddress()
    {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress)
    {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl()
    {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl)
    {
        this.bannerUrl = bannerUrl;
    }
}
