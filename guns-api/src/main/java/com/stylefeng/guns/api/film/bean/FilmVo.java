package com.stylefeng.guns.api.film.bean;

import java.io.Serializable;

public class FilmVo<T> implements Serializable {
    private long filmNum;
    private T filmInfo;
}
