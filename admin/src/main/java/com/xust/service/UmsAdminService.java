package com.xust.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xust.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
public interface UmsAdminService extends IService<UmsAdmin> {


    IPage<UmsAdmin> getUmsAdminPage(Integer pageNo, Integer pageSize,String name);

    Boolean save(String name, String phone, String email, Integer gender, String password, MultipartFile file);

    Boolean update(String id,String name, String phone, String email, Integer gender,MultipartFile file);


}
