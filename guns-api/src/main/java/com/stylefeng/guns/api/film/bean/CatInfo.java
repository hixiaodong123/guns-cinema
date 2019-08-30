package com.stylefeng.guns.api.film.bean;


import lombok.Data;

import java.io.Serializable;
@Data
public class CatInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int catId;
    private String catName;
    private Boolean isActive=false;
}
