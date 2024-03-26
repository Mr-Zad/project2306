package com.xust.service;

import com.xust.entity.PmsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author zs
 * @since 2024-03-19
 */
public interface PmsCategoryService extends IService<PmsCategory> {

    List<PmsCategory> getAll();

    Boolean save(String name,String parentId,Integer level);

    Boolean update(String id,String name);

    Boolean delete(String id,Boolean active);
}
