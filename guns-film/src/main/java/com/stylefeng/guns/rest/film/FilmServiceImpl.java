package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.vo.film.*;
import com.stylefeng.guns.api.film.vo.index.BannerVO;
import com.stylefeng.guns.api.film.vo.index.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.index.FilmVO;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.stylefeng.guns.rest.film.util.FilmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 影片业务实现
 * @author: Lime
 * @create: 2019-08-29 22:01
 **/

@Component
@Service(interfaceClass = FilmServiceAPI.class)
public class FilmServiceImpl implements FilmServiceAPI
{

    @Autowired
    private BannerTMapper bannerTMapper;

    @Autowired
    private FilmTMapper filmTMapper;

    @Autowired
    private CatDictTMapper catDictTMapper;

    @Autowired
    private SourceDictTMapper sourceDictTMapper;

    @Autowired
    private YearDictTMapper yearDictTMapper;

    @Autowired
    private FilmInfoTMapper filmInfoTMapper;

    @Autowired
    private ActorTMapper actorTMapper;


    // ======================  首页的API实现 start  ======================================

    @Override
    public List<BannerVO> getBanners()
    {
        //无条件查询出所有的banner,封装到list集合
        List<BannerT> banners = bannerTMapper.selectList(null);
        List<BannerVO> result = new ArrayList<>();

        for (BannerT banner : banners)
        {
            //遍历赋值
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerId("" + banner.getUuid());
            bannerVO.setBannerUrl(banner.getBannerUrl());
            bannerVO.setBannerAddress(banner.getBannerAddress());
            result.add(bannerVO);
        }

        return result;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId)
    {
        /**
         * isLimit是一个标志,标志着是否需要限制展示的条数
         *   如果是true 则限制  是首页
         *   如果是false 则不限制  是列表展示页
         */

        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> films = new ArrayList<>();

        //热映电影的限制条件是film_status是1
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 1);

        //判断调用的场景
        if (isLimit)
        {
            //说明是首页调用
            //使用分页查询工具
            Page<FilmT> page = new Page<>(1, nums);   //当前页和每页条数
            List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);

            //FilmVO里装的是FilmInfoVO的list集合,显然这里需要进行一个封装对象的过程
            for (FilmT filmT : filmTS)
            {
                FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInfoVOInHotFilms(filmT);
                films.add(filmInfoVO);
            }
            //封装
            filmVO.setFilmInfo(films);
            filmVO.setFilmNum(filmTS.size());
        }
        else
        {

            //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
            //热映电影的排序,默认按照票房
            Page<FilmT> page = null;
            switch (sortId)
            {
                case 1:
                    page = new Page<>(nowPage, nums, "film_box_office", false);
                    break;
                case 2:
                    page = new Page<>(nowPage, nums, "film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage, nums, "film_score", false);
                    break;
                default:
                    page = new Page<>(nowPage, nums, "film_box_office", false);
                    break;
            }

            //不是首页
            FilmUtils.queryNotIndex(wrapper, page, nowPage, nums, sourceId, yearId, catId, filmTMapper, films, filmVO);
        }


        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId)
    {
        /**
         * isLimit是一个标志,标志着是否需要限制展示的条数
         *   如果是true 则限制  是首页
         *   如果是false 则不限制  是列表展示页
         */

        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> films = new ArrayList<>();

        //热映电影的限制条件是film_status是2
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 2);

        //判断调用的场景
        if (isLimit)
        {
            //说明是首页调用
            //使用分页查询工具
            Page<FilmT> page = new Page<>(1, nums);   //当前页和每页条数
            List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);

            //FilmVO里装的是FilmInfoVO的list集合,显然这里需要进行一个封装对象的过程
            for (FilmT filmT : filmTS)
            {
                FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInfoVOInSoonFilms(filmT);
                films.add(filmInfoVO);
            }
            //封装
            filmVO.setFilmInfo(films);
            filmVO.setFilmNum(filmTS.size());
        }
        else
        {
            ////不是首页
            ////配置分页条件

            //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索


            //即将上映电影的排序默认按照预售从大到小
            Page<FilmT> page = null;
            switch (sortId)
            {
                case 1:
                    page = new Page<>(nowPage, nums, "film_preSaleNum", false);
                    break;
                case 2:
                    page = new Page<>(nowPage, nums, "film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage, nums, "film_preSaleNum", false);
                    break;
                default:
                    page = new Page<>(nowPage, nums, "film_preSaleNum", false);
                    break;
            }


            //Page<FilmT> page = new Page<>(nowPage, nums);
            ////如果sourceId,yearId,catId不是99,就分别加入各自的条件
            //if (sourceId != 99)
            //{
            //    wrapper.eq("film_source", sourceId);
            //}
            //if (yearId != 99)
            //{
            //    wrapper.eq("film_date", yearId);
            //}
            //if (catId != 99)
            //{
            //    //数据库中的格式是#2#3#22#
            //    //传入的则是单个数值如1,2等,应该使用模糊查询
            //    String catStr = "%#" + catId + "%#";
            //    wrapper.like("film_cat", catStr);
            //}
            ////查询出数据
            //List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);
            ////遍历封装赋值
            //for (FilmT filmT : filmTS)
            //{
            //    FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInCondition(filmT);
            //    films.add(filmInfoVO);
            //}
            //filmVO.setFilmInfo(films);
            ////其他数据封装
            //Integer totalCount = filmTMapper.selectCount(wrapper);
            //int totalPage = (totalCount / nums) + 1;
            //filmVO.setTotalPage(totalPage);
            //filmVO.setNowPage(nowPage);


            FilmUtils.queryNotIndex(wrapper, page, nowPage, nums, sourceId, yearId, catId, filmTMapper, films, filmVO);
        }

        return filmVO;
    }

    @Override
    public List<FilmInfoVO> getBoxRanking()
    {
        //需求: 查询出票房前十名然后返回
        //既然是有票房的电影,那么必然是正在热映的电影
        //所以查询的条件是film_status为1

        List<FilmInfoVO> filmInfoVOList = new ArrayList<>();
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 1);

        //分页条件查询,添加排序条件
        Page<FilmT> page = new Page<>(1, 10, "film_box_office", false);
        List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);

        //将filmTS封装成List<FilmInfoVO>
        for (FilmT filmT : filmTS)
        {
            FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInfoVOInBoxRanking(filmT);
            filmInfoVOList.add(filmInfoVO);
        }

        return filmInfoVOList;
    }

    @Override
    public List<FilmInfoVO> getExpectRanking()
    {
        //需求: 查询出受期待值最高的十名然后返回
        //既然是受期待的电影,那么必然是即将上映的电影
        //所以查询的条件是film_status为2

        List<FilmInfoVO> filmInfoVOList = new ArrayList<>();
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 2);

        //分页条件查询,添加排序条件  条件是按film_preSaleNum从大往小
        Page<FilmT> page = new Page<>(1, 10, "film_preSaleNum", false);
        List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);

        //将filmTS封装成List<FilmInfoVO>
        for (FilmT filmT : filmTS)
        {
            FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInfoVOInExpectRanking(filmT);
            filmInfoVOList.add(filmInfoVO);
        }

        return filmInfoVOList;

    }

    @Override
    public List<FilmInfoVO> getTop()
    {
        //需求: 查询出评分最高的十名然后返回
        //既然是评分最高的电影,那么必然是正在热映的电影
        //所以查询的条件是film_status为1

        List<FilmInfoVO> filmInfoVOList = new ArrayList<>();
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 1);

        //分页条件查询,添加排序条件  条件是按film_score从大往小
        Page<FilmT> page = new Page<>(1, 10, "film_score", false);
        List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);

        //将filmTS封装成List<FilmInfoVO>
        for (FilmT filmT : filmTS)
        {
            FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInfoVOInTop100(filmT);
            filmInfoVOList.add(filmInfoVO);
        }

        return filmInfoVOList;

    }

    // 条件查询页中的查询经典电影的方法实现
    @Override
    public FilmVO getClassicalFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId)
    {
        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> films = new ArrayList<>();

        //经典电影的限制条件是film_status是3
        EntityWrapper<FilmT> wrapper = new EntityWrapper<>();
        wrapper.eq("film_status", 3);

        //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
        //经典电影的排序,默认按照评分
        Page<FilmT> page = null;
        switch (sortId)
        {
            case 1:
                page = new Page<>(nowPage, nums, "film_score", false);
                break;
            case 2:
                page = new Page<>(nowPage, nums, "film_time");
                break;
            case 3:
                page = new Page<>(nowPage, nums, "film_score", false);
                break;
            default:
                page = new Page<>(nowPage, nums, "film_score", false);
                break;
        }


        //首页不需要 直接调用utils中的方法
        FilmUtils.queryNotIndex(wrapper, page, nowPage, nums, sourceId, yearId, catId, filmTMapper, films, filmVO);
        return filmVO;
    }


    // ======================  首页的API实现 end  ======================================


    // ======================  条件列表API实现 start  ======================================

    @Override
    public List<CatInfoVO> getCatInfo()
    {
        List<CatInfoVO> catInfoVOList = new ArrayList<>();

        //直接从数据库获取所有的列表
        //按UUID从小到大排序
        EntityWrapper<CatDictT> entityWrapper = new EntityWrapper<>();
        //List<String> list;
        //String[] strings = {"UUID", "show_name"};
        //list = Arrays.asList(strings);
        //entityWrapper.orderDesc(list);
        entityWrapper.orderBy("UUID");
        List<CatDictT> catDictTList = catDictTMapper.selectList(entityWrapper);
        for (CatDictT catDictT : catDictTList)
        {
            //遍历赋值
            CatInfoVO catInfoVO = FilmUtils.catDictT2CatInfoVO(catDictT);
            catInfoVOList.add(catInfoVO);
        }

        return catInfoVOList;
    }

    @Override
    public List<SourceInfoVO> getSourceInfo()
    {
        List<SourceInfoVO> sourceInfoVOList = new ArrayList<>();

        //按UUID从小到大排序
        EntityWrapper<SourceDictT> entityWrapper = new EntityWrapper<>();
        //List<String> list;
        //String[] strings = {"UUID", "show_name"};
        //list = Arrays.asList(strings);
        //entityWrapper.orderDesc(list);
        entityWrapper.orderBy("UUID");


        List<SourceDictT> sourceDictTList = sourceDictTMapper.selectList(entityWrapper);

        for (SourceDictT sourceDictT : sourceDictTList)
        {
            SourceInfoVO sourceInfoVO = FilmUtils.sourceDictT2SourceInfoVO(sourceDictT);
            sourceInfoVOList.add(sourceInfoVO);
        }

        return sourceInfoVOList;
    }

    @Override
    public List<YearInfoVO> getYearInfo()
    {
        List<YearInfoVO> yearInfoVOList = new ArrayList<>();

        //按UUID从小到大排序
        EntityWrapper<YearDictT> entityWrapper = new EntityWrapper<>();
        //List<String> list;
        //String[] strings = {"UUID", "show_name"};
        //list = Arrays.asList(strings);
        //entityWrapper.orderDesc(list);
        entityWrapper.orderBy("UUID");

        List<YearDictT> yearDictTList = yearDictTMapper.selectList(entityWrapper);

        for (YearDictT yearDictT : yearDictTList)
        {

            YearInfoVO yearInfoVO = FilmUtils.yearDictT2YearInfoVO(yearDictT);
            yearInfoVOList.add(yearInfoVO);
        }

        return yearInfoVOList;
    }


    // ======================  条件列表API实现 end  ======================================


    // ======================= 影片详情 Start =============================================
    //影片详情
    @Override
    public FilmDetailVO getFilmDetail(int searchType, String searchParam)
    {

        FilmDetailVO filmDetailVO = null;
        // searchType 1-按名称  2-按ID的查找
        if (searchType == 1)
        {
            String filmName = "%" + searchParam + "%";
            filmDetailVO = filmTMapper.getFilmDetailByName(filmName);
        }
        else
        {
            filmDetailVO = filmTMapper.getFilmDetailById(searchParam);
        }

        return filmDetailVO;
    }

    @Override
    public FilmDescVO getFilmDesc(String filmId)
    {
        FilmDescVO filmDescVO = new FilmDescVO();

        FilmInfoT filmInfoT = FilmUtils.getFilmInfoT(filmId, filmInfoTMapper);

        filmDescVO.setFilmId(filmInfoT.getFilmId());
        filmDescVO.setBiography(filmInfoT.getBiography());

        return filmDescVO;
    }


    @Override
    public ImgVO getImgs(String filmId)
    {

        ImgVO imgVO = new ImgVO();
        FilmInfoT filmInfoT = FilmUtils.getFilmInfoT(filmId, filmInfoTMapper);
        String filmImgs = filmInfoT.getFilmImgs();
        String[] imgs = filmImgs.split(",");

        imgVO.setMainImg(imgs[0]);
        imgVO.setImg01(imgs[1]);
        imgVO.setImg02(imgs[2]);
        imgVO.setImg03(imgs[3]);
        imgVO.setImg04(imgs[4]);

        return imgVO;
    }

    @Override
    public List<ActorVO> getActor(String filmId)
    {
        return actorTMapper.getActor(filmId);
    }

    @Override
    public ActorVO getDirector(String filmId)
    {
        FilmInfoT filmInfoT = FilmUtils.getFilmInfoT(filmId, filmInfoTMapper);
        //获取导演的编号
        Integer directorId = filmInfoT.getDirectorId();

        //查询出结果
        ActorT director = actorTMapper.selectById(directorId);
        //赋值
        ActorVO actorVO = new ActorVO();
        actorVO.setImgAddress(director.getActorImg());
        actorVO.setDirectorName(director.getActorName());
        return actorVO;
    }

    // ======================= 影片详情 END =============================================


}
