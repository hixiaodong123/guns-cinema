package com.stylefeng.guns.rest.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.bean.FilmIndexVo;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Reference(interfaceClass = FilmServiceAPI.class)
    FilmServiceAPI filmServiceAPI;
    @RequestMapping("/getIndex")
    public ResponseVO getIndex(){
        FilmIndexVo indexVo=new FilmIndexVo();
        indexVo.setBanners(filmServiceAPI.getBanners());
        indexVo.setHotFilms(filmServiceAPI.getHotFilms());
        indexVo.setSoonFilms(filmServiceAPI.getSoonFilms());
        indexVo.setBoxRanking(filmServiceAPI.getBoxRnking());
        indexVo.setTop100(filmServiceAPI.getTop100());
        indexVo.setExpectRanking(filmServiceAPI.getExpectRanking());
        return ResponseVO.success(indexVo);
    }
}
