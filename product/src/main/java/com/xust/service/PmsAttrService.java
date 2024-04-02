package com.xust.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xust.entity.PmsAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 分类属性表 服务类
 * </p>
 *
 * @author zs
 * @since 2024-03-26
 */
public interface PmsAttrService extends IService<PmsAttr> {

    List<PmsAttr> list(String[] categoryIds);
    Boolean save(String name, String categoryId, Integer type);
    Boolean update(String id,String name,Integer type);
    Boolean delete(String id);
}
