package com.xust.entity;

import com.xust.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PmsBrand extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌LOGO
     */
    private String logo;

    /**
     * 品牌详情
     */
    private String description;

    /**
     * 状态
     */
    private Boolean active;

    /**
     * 排序
     */
    private Long sort;


}
