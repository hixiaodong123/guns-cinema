package com.stylefeng.guns.rest.modular.film.vo;

import com.stylefeng.guns.api.film.vo.film.CatInfoVO;
import com.stylefeng.guns.api.film.vo.film.SourceInfoVO;
import com.stylefeng.guns.api.film.vo.film.YearInfoVO;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 用于封装响应给前端的condition类
 * @author: Lime
 * @create: 2019-08-30 23:22
 **/

public class FilmConditionVO implements Serializable
{
    private static final long serialVersionUID = -40846469805559215L;

    private List<CatInfoVO> catInfo;
    private List<SourceInfoVO> sourceInfo;
    private List<YearInfoVO> yearInfo;


    public List<CatInfoVO> getCatInfo()
    {
        return catInfo;
    }

    public void setCatInfo(List<CatInfoVO> catInfo)
    {
        this.catInfo = catInfo;
    }

    public List<SourceInfoVO> getSourceInfo()
    {
        return sourceInfo;
    }

    public void setSourceInfo(List<SourceInfoVO> sourceInfo)
    {
        this.sourceInfo = sourceInfo;
    }

    public List<YearInfoVO> getYearInfo()
    {
        return yearInfo;
    }

    public void setYearInfo(List<YearInfoVO> yearInfo)
    {
        this.yearInfo = yearInfo;
    }
}
