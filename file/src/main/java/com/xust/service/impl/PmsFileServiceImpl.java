package com.xust.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xust.entity.PmsFile;
import com.xust.mapper.PmsFileMapper;
import com.xust.service.PmsFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author zs
 * @since 2024-03-12
 */
@Service
public class PmsFileServiceImpl extends ServiceImpl<PmsFileMapper, PmsFile> implements PmsFileService {

    @Override
    public PmsFile get(String md5, Long size, String type) {
        QueryWrapper<PmsFile> wrapper = new QueryWrapper<>();
        wrapper.eq("md5",md5)
                .eq("size",size)
                .eq("type",type);

        return this.getOne(wrapper);
    }
}
