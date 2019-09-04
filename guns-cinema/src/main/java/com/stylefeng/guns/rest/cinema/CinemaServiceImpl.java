package com.stylefeng.guns.rest.cinema;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.cinema.CinemaServiceAPI;
import com.stylefeng.guns.api.cinema.vo.*;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 影院业务实现
 * @author: Lime
 * @create: 2019-08-29 22:38
 **/

@Component
@Service(interfaceClass = CinemaServiceAPI.class)
public class CinemaServiceImpl implements CinemaServiceAPI
{
    @Autowired
    private CinemaTMapper cinemaTMapper;

    @Autowired
    private BrandDictTMapper brandDictTMapper;

    @Autowired
    private AreaDictTMapper areaDictTMapper;

    @Autowired
    private HallDictTMapper hallDictTMapper;

    @Autowired
    private FieldTMapper fieldTMapper;


    //1、根据CinemaQueryVO，查询影院列表
    @Override
    public Page<CinemaVO> getCinemas(CinemaQueryVO cinemaQueryVO){
        // 业务实体集合
        List<CinemaVO> cinemas = new ArrayList<>();

        Page<CinemaT> page = new Page<>(cinemaQueryVO.getNowPage(),cinemaQueryVO.getPageSize());
        // 判断是否传入查询条件 -> brandId,distId,hallType 是否==99
        EntityWrapper<CinemaT> entityWrapper = new EntityWrapper<>();
        if(cinemaQueryVO.getBrandId() != 99){
            entityWrapper.eq("brand_id",cinemaQueryVO.getBrandId());
        }
        if(cinemaQueryVO.getDistrictId() != 99){
            entityWrapper.eq("area_id",cinemaQueryVO.getDistrictId());
        }
        if(cinemaQueryVO.getHallType() != 99){  // %#3#%
            entityWrapper.like("hall_ids","%#+"+cinemaQueryVO.getHallType()+"+#%");
        }

        // 将数据实体转换为业务实体
        List<CinemaT> cinemaTList = cinemaTMapper.selectPage(page, entityWrapper);
        for(CinemaT cinemaT : cinemaTList){
            CinemaVO cinemaVO = new CinemaVO();

            cinemaVO.setUuid(cinemaT.getUuid()+"");
            cinemaVO.setMinimumPrice(cinemaT.getMinimumPrice()+"");
            cinemaVO.setCinemaName(cinemaT.getCinemaName());
            cinemaVO.setCinemaAddress(cinemaT.getCinemaAddress());
            cinemas.add(cinemaVO);
        }

        // 根据条件，判断影院列表总数
        long counts = cinemaTMapper.selectCount(entityWrapper);

        // 组织返回值对象
        Page<CinemaVO> result = new Page<>();
        result.setRecords(cinemas);
        result.setSize(cinemaQueryVO.getPageSize());
        result.setTotal(counts);

        return result;
    }
    //2、根据条件获取品牌列表[除了就99以外，其他的数字为isActive]
    @Override
    public List<BrandVO> getBrands(int brandId){
        boolean flag = false;
        List<BrandVO> brandVOS = new ArrayList<>();
        // 判断brandId是否存在
        BrandDictT brandDictT = brandDictTMapper.selectById(brandId);
        // 判断brandId 是否等于 99
        if(brandId == 99 || brandDictT==null || brandDictT.getUuid() == null){
            flag = true;
        }
        // 查询所有列表
        List<BrandDictT> brandDictTList = brandDictTMapper.selectList(null);
        // 判断flag如果为true，则将99置为isActive
        for(BrandDictT brand : brandDictTList){
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandName(brand.getShowName());
            brandVO.setBrandId(brand.getUuid()+"");
            // 如果flag为true，则需要99，如为false，则匹配上的内容为active
            if(flag){
                if(brand.getUuid() == 99){
                    brandVO.setActive(true);
                }
            }else{
                if(brand.getUuid() == brandId){
                    brandVO.setActive(true);
                }
            }

            brandVOS.add(brandVO);
        }

        return brandVOS;
    }
    //3、获取行政区域列表
    @Override
    public List<AreaVO> getAreas(int areaId){
        boolean flag = false;
        List<AreaVO> areaVOS = new ArrayList<>();
        // 判断brandId是否存在
        AreaDictT areaDictT = areaDictTMapper.selectById(areaId);
        // 判断brandId 是否等于 99
        if(areaId == 99 || areaDictT==null || areaDictT.getUuid() == null){
            flag = true;
        }
        // 查询所有列表
        List<AreaDictT> areaDictTS = areaDictTMapper.selectList(null);
        // 判断flag如果为true，则将99置为isActive
        for(AreaDictT area : areaDictTS){
            AreaVO areaVO = new AreaVO();
            areaVO.setAreaName(area.getShowName());
            areaVO.setAreaId(area.getUuid()+"");
            // 如果flag为true，则需要99，如为false，则匹配上的内容为active
            if(flag){
                if(area.getUuid() == 99){
                    areaVO.setActive(true);
                }
            }else{
                if(area.getUuid() == areaId){
                    areaVO.setActive(true);
                }
            }

            areaVOS.add(areaVO);
        }
        return areaVOS;
    }
    //4、获取影厅类型列表
    @Override
    public List<HallTypeVO> getHallTypes(int hallType){
        boolean flag = false;
        List<HallTypeVO> hallTypeVOS = new ArrayList<>();
        // 判断brandId是否存在
        HallDictT hallDictT = hallDictTMapper.selectById(hallType);
        // 判断brandId 是否等于 99
        if(hallType == 99 || hallDictT==null || hallDictT.getUuid() == null){
            flag = true;
        }
        // 查询所有列表
        List<HallDictT> hallDictTList = hallDictTMapper.selectList(null);
        // 判断flag如果为true，则将99置为isActive
        for(HallDictT hall : hallDictTList){
            HallTypeVO hallTypeVO = new HallTypeVO();
            hallTypeVO.setHalltypeName(hall.getShowName());
            hallTypeVO.setHalltypeId(hall.getUuid()+"");
            // 如果flag为true，则需要99，如为false，则匹配上的内容为active
            if(flag){
                if(hall.getUuid() == 99){
                    hallTypeVO.setActive(true);
                }
            }else{
                if(hall.getUuid() == hallType){
                    hallTypeVO.setActive(true);
                }
            }

            hallTypeVOS.add(hallTypeVO);
        }

        return hallTypeVOS;
    }
    //5、根据影院编号，获取影院信息
    @Override
    public CinemaInfoVO getCinemaInfoById(int cinemaId){

        // 数据实体
        CinemaT cinemaT = cinemaTMapper.selectById(cinemaId);
        // 将数据实体转换成业务实体
        CinemaInfoVO cinemaInfoVO = new CinemaInfoVO();
        cinemaInfoVO.setCinemaAdress(cinemaT.getCinemaAddress());
        cinemaInfoVO.setImgUrl(cinemaT.getImgAddress());
        cinemaInfoVO.setCinemaPhone(cinemaT.getCinemaPhone());
        cinemaInfoVO.setCinemaName(cinemaT.getCinemaName());
        cinemaInfoVO.setCinemaId(cinemaT.getUuid()+"");

        return cinemaInfoVO;
    }

    //6、获取所有电影的信息和对应的放映场次信息，根据影院编号
    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId){

        return fieldTMapper.getFilmInfos(cinemaId);
    }
    //7、根据放映场次ID获取放映信息
    @Override
    public HallInfoVO getFilmFieldInfo(int fieldId){

        return fieldTMapper.getHallInfo(fieldId);
    }
    //8、根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
    @Override
    public FilmInfoVO getFilmInfoByFieldId(int fieldId){

        return fieldTMapper.getFilmInfoById(fieldId);
    }

    @Override
    public OrderQueryVO getOrderNeeds(int fieldId) {

        OrderQueryVO orderQueryVO = new OrderQueryVO();

        FieldT fieldT = fieldTMapper.selectById(fieldId);

        orderQueryVO.setCinemaId(fieldT.getCinemaId()+"");
        orderQueryVO.setFilmPrice(fieldT.getPrice()+"");

        return orderQueryVO;
    }
}
