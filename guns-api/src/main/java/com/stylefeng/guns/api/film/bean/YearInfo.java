package com.stylefeng.guns.api.film.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class YearInfo implements Serializable {
    private int yearId;
    private String yearName;
    private Boolean isActive=false;
    private static final long serialVersionUID = 1L;
}
