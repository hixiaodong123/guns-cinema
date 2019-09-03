package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.api.film.vo.film.FilmDetailVO;
import com.stylefeng.guns.rest.common.persistence.model.FilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-29
 */
public interface FilmTMapper extends BaseMapper<FilmT>
{


    FilmDetailVO getFilmDetailByName(@Param("filmName") String filmName);

    FilmDetailVO getFilmDetailById(@Param("UUID") String UUID);

}
