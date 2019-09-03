package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.AreaVO;
import com.stylefeng.guns.api.cinema.vo.BrandVO;
import com.stylefeng.guns.api.cinema.vo.HallTypeVO;

import java.util.List;

public class CinemaConditionResponseVO {

    private List<BrandVO> brandList;
    private List<AreaVO> areaList;
    private List<HallTypeVO> halltypeList;

    public List<BrandVO> getBrandList()
    {
        return brandList;
    }

    public void setBrandList(List<BrandVO> brandList)
    {
        this.brandList = brandList;
    }

    public List<AreaVO> getAreaList()
    {
        return areaList;
    }

    public void setAreaList(List<AreaVO> areaList)
    {
        this.areaList = areaList;
    }

    public List<HallTypeVO> getHalltypeList()
    {
        return halltypeList;
    }

    public void setHalltypeList(List<HallTypeVO> halltypeList)
    {
        this.halltypeList = halltypeList;
    }
}
