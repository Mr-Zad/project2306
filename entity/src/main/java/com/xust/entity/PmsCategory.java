package com.xust.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xust.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author zs
 * @since 2024-03-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class PmsCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public PmsCategory(String name, String parentId, Integer level) {
        this.name = name;
        this.parentId = parentId;
        this.level = level;
    }

    public PmsCategory(String id, String name) {
        super(id);
        this.name = name;
    }

    public PmsCategory(String id, Boolean active) {
        super(id);
        this.active = active;
    }

    /**
     * 分类名称
     */
    private String name;

    /**
     * 上级id
     */
    private String parentId;

    /**
     * 当前层级
     */
    private Integer level;

    /**
     * 状态
     */
    private Boolean active;

    private Long sort;

    @TableField(exist = false) //表示该字段不存在数据库表中，不参与sql
    private List<PmsCategory> children;

}
