package com.xust.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//提取出来，统一管理id

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
}
