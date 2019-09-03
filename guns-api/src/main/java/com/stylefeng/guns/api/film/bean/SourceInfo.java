package com.stylefeng.guns.api.film.bean;


import lombok.Data;

import java.io.Serializable;
@Data
public class SourceInfo implements Serializable{
    private int sourceId;
    private String sourceName;
    private Boolean isActive=false;
    private static final long serialVersionUID = 1L;
}
