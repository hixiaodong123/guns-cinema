package com.stylefeng.guns.rest.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.bean.FilmIndexVo;
import com.stylefeng.guns.api.film.bean.SearchVo;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Reference(interfaceClass = FilmServiceAPI.class,check = false)
    FilmServiceAPI filmServiceAPI;
    @RequestMapping("/getIndex")
    public ResponseVO getIndex(){
        FilmIndexVo indexVo=new FilmIndexVo();
        try {
            indexVo.setBanners(filmServiceAPI.getBanners());
            if(indexVo.getBanners().size()<1){
                return ResponseVO.serviceFail("查询失败，无banner可加载");
            }
            indexVo.setHotFilms(filmServiceAPI.getHotFilms());
            indexVo.setSoonFilms(filmServiceAPI.getSoonFilms());
            indexVo.setBoxRanking(filmServiceAPI.getBoxRnking());
            indexVo.setTop100(filmServiceAPI.getTop100());
            indexVo.setExpectRanking(filmServiceAPI.getExpectRanking());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.systemFail("系统出现异常，请联系管理员");
        }
        return ResponseVO.success(indexVo);
    }
    @RequestMapping("/getConditionList")
    public ResponseVO getConditionList(Integer catId,Integer sourceId,Integer yearId){
        try {
            if(catId==null){
                catId=99;
            }
            if(sourceId==null){
                sourceId=99;
            }
            if(yearId==null){
                yearId=99;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.serviceFail("查询失败，无条件可加载");
        }
        if(catId>99||catId<0||sourceId>99||sourceId<0||yearId>99||yearId<0){
            return ResponseVO.serviceFail("查询失败，无条件可加载");
        }
        SearchVo searchVo=new SearchVo();
        try {
            searchVo.setCatInfo(filmServiceAPI.getCat(catId));
            searchVo.setYearInfo(filmServiceAPI.getYear(yearId));
            searchVo.setSourceInfo(filmServiceAPI.getSource(sourceId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.systemFail("系统出现异常，请联系管理员");
        }
        return ResponseVO.success(searchVo);
    }
//    private void setDefault99(Integer ...integer){
//        for (Integer inter : integer) {
//            if(inter==null){
//                inter=99;
//            }
//        }
//    }

}
