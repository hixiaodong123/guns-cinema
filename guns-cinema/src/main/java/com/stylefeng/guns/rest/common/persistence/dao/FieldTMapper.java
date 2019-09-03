package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;
import com.stylefeng.guns.api.cinema.vo.HallInfoVO;
import com.stylefeng.guns.rest.common.persistence.model.FieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-29
 */
public interface FieldTMapper extends BaseMapper<FieldT>
{
    List<FilmInfoVO> getFilmInfos(@Param("cinemaId") int cinemaId);

    HallInfoVO getHallInfo(@Param("fieldId") int fieldId);

    FilmInfoVO getFilmInfoById(@Param("fieldId") int fieldId);

}
