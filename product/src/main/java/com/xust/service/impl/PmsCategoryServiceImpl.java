package com.xust.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xust.core.PowernodeException;
import com.xust.entity.PmsCategory;
import com.xust.mapper.PmsCategoryMapper;
import com.xust.service.PmsCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author zs
 * @since 2024-03-19
 */
@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory> implements PmsCategoryService {

    @Override
    @Cacheable(value = "pms",key = "'category'")
    public List<PmsCategory> getAll() {
        /*QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByAsc("sort");*/
        return this.getByParentId("");
    }

    public List<PmsCategory> getByParentId(String parentId){

        QueryWrapper<PmsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",parentId).orderByAsc("sort");

        List<PmsCategory> list = this.list(queryWrapper);
        for (PmsCategory pmsCategory : list) {
            pmsCategory.setChildren(getByParentId(pmsCategory.getId()));
        }
        return list;
    }

    @Override
    @CacheEvict(value = "pms",key = "'category'")
    public Boolean save(String name, String parentId, Integer level) {
        return this.save(new PmsCategory(name,parentId,level));
    }

    @Override
    @CacheEvict(value = "pms",key = "'category'")
    public Boolean update(String id, String name) {
        return this.updateById(new PmsCategory(id,name));
    }

    @Override
    @CacheEvict(value = "pms",key = "'category'")
    public Boolean delete(String id, Boolean active) {
        if (!active && this.getChildrenActive(id) > 0){
            throw new PowernodeException("存在未禁用的子分类");
        }

        if (active && !this.getParentActive(id)){
            throw  new PowernodeException("父分类为启用");
        }
        return this.updateById(new PmsCategory(id,active));
    }


    //判断子类启用的数量
    public int getChildrenActive(String id){
        QueryWrapper<PmsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id).eq("active",1);
        return  this.count(queryWrapper);
    }

    //判断父类的状态
    public Boolean getParentActive(String id){
        PmsCategory pmsCategory = this.getById(id);
        String parentId = pmsCategory.getParentId();
        if (StringUtils.isBlank(parentId)){
            return true;
        }
        Boolean active = this.getById(parentId).getActive();
        return active;
    }
}
