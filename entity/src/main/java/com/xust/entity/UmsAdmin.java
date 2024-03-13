package com.xust.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xust.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UmsAdmin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public UmsAdmin(String name, String phone, String email, Integer gender, String password,String icon) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.icon = icon;
    }

    public UmsAdmin(String id, String name, String phone, String email, Integer gender) {
        super(id);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 1-男 0-女
     */
    private Integer gender;

    /**
     * 登录密码
     */
    @JsonIgnore
    private String password;

    /**
     * 状态
     */
    private Boolean active;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 头像路径
     */
    private String icon;


}
