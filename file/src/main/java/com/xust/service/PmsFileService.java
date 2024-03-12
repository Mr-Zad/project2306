package com.xust.service;

import com.xust.entity.PmsFile;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文件表 服务类
 * </p>
 *
 * @author zs
 * @since 2024-03-12
 */
public interface PmsFileService extends IService<PmsFile> {

    PmsFile get(String md5,Long size,String type);
}
