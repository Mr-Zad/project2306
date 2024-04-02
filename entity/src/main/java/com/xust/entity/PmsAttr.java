package com.xust.entity;

import com.xust.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 分类属性表
 * </p>
 *
 * @author zs
 * @since 2024-03-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PmsAttr extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 分类id
     */
    private String categoryId;

    /**
     * 1-spu 0-sku
     */
    private Integer type;

    /**
     * 排序
     */
    private Long sort;

    //添加用
    public PmsAttr(String name, String categoryId, Integer type) {
        this.name = name;
        this.categoryId = categoryId;
        this.type = type;
    }
    //修改用


    public PmsAttr(String name, Integer type) {
        this.name = name;
        this.type = type;
    }
}
