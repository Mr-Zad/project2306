package com.xust.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xust.entity.PmsAttr;
import com.xust.mapper.PmsAttrMapper;
import com.xust.service.PmsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 分类属性表 服务实现类
 * </p>
 *
 * @author zs
 * @since 2024-03-26
 */
@Service
public class PmsAttrServiceImpl extends ServiceImpl<PmsAttrMapper, PmsAttr> implements PmsAttrService {

    @Override
    public List<PmsAttr> list(String[] categoryIds) {

        List<PmsAttr> list = new ArrayList<>();
        for (String categoryId : categoryIds) {
            list.addAll(getCategoryId(categoryId));
        }
        return list;
    }

    public List<PmsAttr> getCategoryId(String categoryId){
        QueryWrapper<PmsAttr> queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id",categoryId).orderByAsc("sort");
        return this.list(queryWrapper);
    }
    @Override
    public Boolean save(String name, String categoryId, Integer type) {
        return this.save(new PmsAttr(name,categoryId,type));
    }

    @Override
    public Boolean update(String id, String name, Integer type) {
        PmsAttr pmsAttr = new PmsAttr(name,type);
        pmsAttr.setId(id);
        return this.updateById(pmsAttr);
    }

    @Override
    public Boolean delete(String id) {
        return this.removeById(id);
    }
}
