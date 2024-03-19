package com.xust.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xust.entity.PmsBrand;
import com.xust.entity.UmsAdmin;
import com.xust.feign.FileService;
import com.xust.mapper.PmsBrandMapper;
import com.xust.service.PmsBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Resource
    PmsBrandMapper pmsBrandMapper;


    @Resource
    FileService fileService;

    @Override
    public IPage<PmsBrand> getPmsBrandPage(Integer pageNo, Integer pageSize, String name) {

        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)){
            queryWrapper.like("name",name.trim());
        }
        queryWrapper.orderByDesc("sort");
        return this.page(new Page<>(pageNo,pageSize),queryWrapper);
    }

    @Override
    public Boolean save(String name, String description, MultipartFile file) {

        String logo = fileService.imageUpload(file);
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setName(name);
        pmsBrand.setLogo(logo);
        pmsBrand.setDescription(description);
        return this.save(pmsBrand);
    }

    @Override
    public Boolean update(String id, String name, String description, MultipartFile file) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setId(id);
        pmsBrand.setName(name);
        pmsBrand.setDescription(description);
        if (null != file) {
            pmsBrand.setLogo(fileService.imageUpload(file));
        }
        return this.updateById(pmsBrand);
    }

    @Override
    public Boolean delete(String id, Boolean active) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setId(id);
        pmsBrand.setActive(active);
        return this.updateById(pmsBrand);
    }
}
