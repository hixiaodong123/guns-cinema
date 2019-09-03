package com.stylefeng.guns.api.film.bean;

import lombok.Data;

import java.util.List;
@Data
public class SearchVo {
    private List<CatInfo> catInfo;
    private List<YearInfo> yearInfo;
    private List<SourceInfo> sourceInfo;
}
