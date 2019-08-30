package com.stylefeng.guns.api.film.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class FilmVo<T> implements Serializable {
    private long filmNum;
    private T filmInfo;
}
