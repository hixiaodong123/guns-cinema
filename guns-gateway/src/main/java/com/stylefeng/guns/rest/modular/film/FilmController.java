package com.stylefeng.guns.rest.modular.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.vo.film.*;
import com.stylefeng.guns.api.film.vo.index.FilmVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmConditionVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmQueryRequestVO;
import com.stylefeng.guns.api.film.vo.film.InfoResponseVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 影片模块业务控制器
 * @author: Lime
 * @create: 2019-08-30 17:36
 **/

@RestController
@RequestMapping("/film")
public class FilmController
{
    private static final String IMG_PRE = "http://img.meetingshop.cn/";

    @Reference(interfaceClass = FilmServiceAPI.class,check = false)
    private FilmServiceAPI filmServiceAPI;

    @GetMapping("/getIndex")
    public ResponseVO getIndex()
    {

        FilmIndexVO filmIndexVO = new FilmIndexVO();

        //获取banner信息
        filmIndexVO.setBanners(filmServiceAPI.getBanners());

        //获取正在热映hotFilms信息
        filmIndexVO.setHotFilms(filmServiceAPI.getHotFilms(true, 8, 1, 1, 99, 99, 99));

        //获取即将上映的电影soonFilms
        filmIndexVO.setSoonFilms(filmServiceAPI.getSoonFilms(true, 8, 1, 1, 99, 99, 99));

        //获取boxRanking票房排行电影
        filmIndexVO.setBoxRanking(filmServiceAPI.getBoxRanking());

        //获取最受欢迎的电影排行expectRanking
        filmIndexVO.setExpectRanking(filmServiceAPI.getExpectRanking());

        //获取top100电影信息
        filmIndexVO.setTop100(filmServiceAPI.getTop());

        //封装返回类型
        ResponseVO success = null;
        try
        {
            success = ResponseVO.success(IMG_PRE, filmIndexVO);
            if (success == null)
            {
                return ResponseVO.serviceFail("查询失败!");
            }
            else
            {
                return success;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseVO.systemFail("系统错误,请联系管理员!");
        }
    }

    @GetMapping("/getConditionList")
    public ResponseVO getConditionList(@RequestParam(value = "catld", required = false, defaultValue = "99") String catld, @RequestParam(value = "sourceId", required = false, defaultValue = "99") String sourceId, @RequestParam(value = "yearId", required = false, defaultValue = "99") String yearId)
    {

        //业务分析: 每个封装对象都有个属性: isActive 当这个属性的值为true时,前端就会将这个框选中
        //所以当catId和查询到的某个一致时,将它的isActive属性设置为true
        //默认为99时,只有99的那个选项的属性设为true

        FilmConditionVO filmConditionVO = new FilmConditionVO();

        //查询出数据库中的各个分类
        List<CatInfoVO> catInfoVOList = null;
        List<SourceInfoVO> sourceInfoVOList = null;
        List<YearInfoVO> yearInfoVOList = null;
        try
        {
            catInfoVOList = filmServiceAPI.getCatInfo();
            sourceInfoVOList = filmServiceAPI.getSourceInfo();
            yearInfoVOList = filmServiceAPI.getYearInfo();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseVO.systemFail("系统异常,请联系管理员!");
        }

        if (catInfoVOList == null || sourceInfoVOList == null || yearInfoVOList == null)
        {
            return ResponseVO.serviceFail("查询失败!");
        }


        //接下来对每个实例中的每个Info中的isActive属性进行处理

        //在实现类中,我们已经将所有的isActive属性都置为了false
        // 并且已经按照UUID对各个分类进行了从小到大的排序,也就是说默认的99排在了最后面
        //之所以这么做是因为在业务中,大多数情况下都是查询默认的99,把99放在最后面有利于提高速度

        //   =================== CAT =========================================
        //处理cat分类
        //先判断传入的id
        if (catld.equals("99"))
        {
            //直接将集合的最后一个元素的属性置为true
            int lastIndex = catInfoVOList.size() - 1;
            CatInfoVO catInfoVO = catInfoVOList.get(lastIndex);
            catInfoVO.setActive(true);
            //移除并再次加入
            catInfoVOList.remove(lastIndex);
            catInfoVOList.add(catInfoVO);
            filmConditionVO.setCatInfo(catInfoVOList);
        }
        else
        {
            //只要不是99,那么就只有一个对象的值是true,其余的都是false
            //遍历赋值
            for (CatInfoVO catInfoVO : catInfoVOList)
            {
                if (catld.equals(catInfoVO.getCatId()))
                {
                    //选中的就是这个,置为true
                    catInfoVO.setActive(true);
                }
                else
                {
                    //不是这个,无需处理
                }
            }
            //循环结束,赋值
            filmConditionVO.setCatInfo(catInfoVOList);
        }

        //   =================== CAT =========================================


        //   =================== YEAR =========================================

        //处理year分类
        //先判断传入的id
        if (yearId.equals("99"))
        {
            //直接将集合的最后一个元素的属性置为true
            int lastIndex = yearInfoVOList.size() - 1;
            YearInfoVO yearInfoVO = yearInfoVOList.get(lastIndex);
            yearInfoVO.setActive(true);
            //移除并再次加入
            yearInfoVOList.remove(lastIndex);
            yearInfoVOList.add(yearInfoVO);
            filmConditionVO.setYearInfo(yearInfoVOList);
        }
        else
        {
            //只要不是99,那么就只有一个对象的值是true,其余的都是false
            //遍历赋值
            for (YearInfoVO yearInfoVO : yearInfoVOList)
            {
                if (sourceId.equals(yearInfoVO.getYearId()))
                {
                    //选中的就是这个,置为true
                    yearInfoVO.setActive(true);
                }
                else
                {
                    //不是这个,无需处理e
                }
            }
            //循环结束,赋值
            filmConditionVO.setYearInfo(yearInfoVOList);
        }

        //   =================== YEAR =========================================


        //   =================== SOURCE =========================================

        //处理source分类
        //先判断传入的id
        if (sourceId.equals("99"))
        {
            //直接将集合的最后一个元素的属性置为true
            int lastIndex = sourceInfoVOList.size() - 1;
            SourceInfoVO sourceInfoVO = sourceInfoVOList.get(lastIndex);
            sourceInfoVO.setActive(true);
            //移除并再次加入
            sourceInfoVOList.remove(lastIndex);
            sourceInfoVOList.add(sourceInfoVO);
            filmConditionVO.setSourceInfo(sourceInfoVOList);
        }
        else
        {
            //只要不是99,那么就只有一个对象的值是true,其余的都是false
            //遍历赋值
            for (SourceInfoVO sourceInfoVO : sourceInfoVOList)
            {
                if (sourceId.equals(sourceInfoVO.getSourceId()))
                {
                    //选中的就是这个,置为true
                    sourceInfoVO.setActive(true);
                }
                else
                {
                    //不是这个,无需处理
                }
            }
            //循环结束,赋值
            filmConditionVO.setSourceInfo(sourceInfoVOList);
        }

        //   =================== SOURCE =========================================


        //结束,返回值
        return ResponseVO.success(filmConditionVO);
    }


    @GetMapping("/getFilms")
    public ResponseVO getFilms(FilmQueryRequestVO filmQueryRequestVOs)
    {

        FilmVO filmVO = null;
        switch (filmQueryRequestVOs.getShowType())
        {
            case 1:
                filmVO = filmServiceAPI.getHotFilms(false, filmQueryRequestVOs.getPageSize(), filmQueryRequestVOs.getNowPage(), filmQueryRequestVOs.getSortId(), filmQueryRequestVOs.getSourceId(), filmQueryRequestVOs.getYearId(), filmQueryRequestVOs.getCatId());
                break;
            case 2:
                filmVO = filmServiceAPI.getSoonFilms(false, filmQueryRequestVOs.getPageSize(), filmQueryRequestVOs.getNowPage(), filmQueryRequestVOs.getSortId(), filmQueryRequestVOs.getSourceId(), filmQueryRequestVOs.getYearId(), filmQueryRequestVOs.getCatId());
                break;
            case 3:
                filmVO = filmServiceAPI.getClassicalFilms(filmQueryRequestVOs.getPageSize(), filmQueryRequestVOs.getNowPage(), filmQueryRequestVOs.getSortId(), filmQueryRequestVOs.getSourceId(), filmQueryRequestVOs.getYearId(), filmQueryRequestVOs.getCatId());
                break;
            default:
                filmVO = filmServiceAPI.getHotFilms(false, filmQueryRequestVOs.getPageSize(), filmQueryRequestVOs.getNowPage(), filmQueryRequestVOs.getSortId(), filmQueryRequestVOs.getSourceId(), filmQueryRequestVOs.getYearId(), filmQueryRequestVOs.getCatId());
                break;
        }

        return ResponseVO.success(IMG_PRE, filmVO.getFilmInfo(), filmVO.getNowPage(), filmVO.getTotalPage());
    }


    @RequestMapping(value = "films/{searchParam}", method = RequestMethod.GET)
    public ResponseVO films(@PathVariable("searchParam") String searchParam, Integer searchType)
    {
        // 根据searchType，判断查询类型
        //0表示按照编号查找，1表示按照名称查找
        FilmDetailVO filmDetail = filmServiceAPI.getFilmDetail(searchType, searchParam);

        if (filmDetail == null)
        {
            return ResponseVO.serviceFail("没有可查询的影片");
        }
        else if (filmDetail.getFilmId() == null || filmDetail.getFilmId().trim().length() == 0)
        {
            return ResponseVO.serviceFail("没有可查询的影片");
        }

        String filmId = filmDetail.getFilmId();

        //获取影片描述
        FilmDescVO filmDesc = filmServiceAPI.getFilmDesc(filmId);
        //获取图片
        ImgVO imgs = filmServiceAPI.getImgs(filmId);
        //获取演员和导演
        List<ActorVO> actor = filmServiceAPI.getActor(filmId);
        ActorVO director = filmServiceAPI.getDirector(filmId);

        //赋值
        InfoResponseVO infoResponseVO = new InfoResponseVO();

        //导员和演员部分
        FilmActorAndDirectorDescVO filmActorAndDirectorDescVO = new FilmActorAndDirectorDescVO();
        filmActorAndDirectorDescVO.setActors(actor);
        filmActorAndDirectorDescVO.setDirector(director);
        infoResponseVO.setActors(filmActorAndDirectorDescVO);

        //其他部分
        infoResponseVO.setBiography(filmDesc.getBiography());
        infoResponseVO.setFilmId(filmId);
        infoResponseVO.setImgVO(imgs);

        //组织返回值
        filmDetail.setInfo04(infoResponseVO);

        return ResponseVO.success(IMG_PRE,filmDetail);



        // 查询影片的详细信息 -> Dubbo的异步调用
        // 获取影片描述信息
//        FilmDescVO filmDescVO = filmAsyncServiceApi.getFilmDesc(filmId);
//        filmAsyncServiceApi.getFilmDesc(filmId);
//        Future<FilmDescVO> filmDescVOFuture = RpcContext.getContext().getFuture();
//        // 获取图片信息
//        filmAsyncServiceApi.getImgs(filmId);
//        Future<ImgVO> imgVOFuture = RpcContext.getContext().getFuture();
//        // 获取导演信息
//        filmAsyncServiceApi.getDectInfo(filmId);
//        Future<ActorVO> actorVOFuture = RpcContext.getContext().getFuture();
//        // 获取演员信息
//        filmAsyncServiceApi.getActors(filmId);
//        Future<List<ActorVO>> actorsVOFutrue = RpcContext.getContext().getFuture();
//
//        // 组织info对象
//        InfoRequstVO infoRequstVO = new InfoRequstVO();
//
//        // 组织Actor属性
//        ActorRequestVO actorRequestVO = new ActorRequestVO();
//        actorRequestVO.setActors(actorsVOFutrue.get());
//        actorRequestVO.setDirector(actorVOFuture.get());
//
//        // 组织info对象
//        infoRequstVO.setActors(actorRequestVO);
//        infoRequstVO.setBiography(filmDescVOFuture.get().getBiography());
//        infoRequstVO.setFilmId(filmId);
//        infoRequstVO.setImgVO(imgVOFuture.get());
//
//        // 组织成返回值
//        filmDetail.setInfo04(infoRequstVO);

        //return ResponseVO.success("http://img.meetingshop.cn/", filmDetail);
    }

}
