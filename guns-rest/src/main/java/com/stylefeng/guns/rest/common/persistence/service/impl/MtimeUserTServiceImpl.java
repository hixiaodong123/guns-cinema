package com.stylefeng.guns.rest.common.persistence.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.service.IMtimeUserTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-28
 */
@Service
public class MtimeUserTServiceImpl extends ServiceImpl<MtimeUserTMapper, MtimeUserT> implements IMtimeUserTService {

    @Autowired
    private MtimeUserTMapper mtimeUserTMapper;

    @Override
    public MtimeUserT getUserInfoByUserName(String username) {
        EntityWrapper<MtimeUserT> entityWrapper = new EntityWrapper<>();

        entityWrapper.eq("user_name",username);
        List<MtimeUserT> objectList =(List<MtimeUserT>) mtimeUserTMapper.selectList(entityWrapper);
        if (CollectionUtils.isEmpty(objectList)){
            return null;
        }
        MtimeUserT mtimeUserT = objectList.get(0);
        return mtimeUserT;
    }
}
