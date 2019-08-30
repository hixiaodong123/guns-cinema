package com.stylefeng.guns.api.film.bean;


import lombok.Data;

import java.io.Serializable;
@Data
public class BannerVo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private int bannerId;
    private String bannerAddress;
    private String bannerUrl;

    @Override
    public String toString() {
        return "BannerVo{" +
                "bannerId=" + bannerId +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }
}
