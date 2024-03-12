package com.xust.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xust.entity.UmsAdmin;
import com.xust.feign.FileService;
import com.xust.mapper.UmsAdminMapper;
import com.xust.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Resource
    UmsAdminMapper umsAdminMapper;

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    FileService fileService;

    @Override
    public IPage<UmsAdmin> getUmsAdminPage(Integer pageNo, Integer pageSize,String name) {

        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)){
            queryWrapper.like("name",name.trim());
        }
        queryWrapper.orderByDesc("sort");
        return this.page(new Page<>(pageNo,pageSize),queryWrapper);
    }

    @Override
    public Boolean save(String name, String phone, String email, Integer gender, String password, MultipartFile file) {

        String icon = fileService.imageUpload(file);
        return this.save(new UmsAdmin(name,phone,email,gender,passwordEncoder.encode(password),icon));
    }
}
