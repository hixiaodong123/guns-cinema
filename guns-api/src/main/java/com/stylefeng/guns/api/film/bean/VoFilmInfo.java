package com.stylefeng.guns.api.film.bean;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 影片主表
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-29
 */
@Data
public class VoFilmInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private double filmScore;
    private long expectNum;
    private Date showTime;
    private long boxNum;
    private double score;

    @Override
    public String toString() {
        return "FilmVo{" +
                "filmId=" + filmId +
                ", filmType=" + filmType +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmScore=" + filmScore +
                ", expectNum=" + expectNum +
                ", showTime=" + showTime +
                ", boxNum=" + boxNum +
                ", score=" + score +
                '}';
    }
}
