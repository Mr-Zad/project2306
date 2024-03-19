package com.xust.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xust.entity.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xust.entity.UmsAdmin;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
public interface PmsBrandService extends IService<PmsBrand> {

    IPage<PmsBrand> getPmsBrandPage(Integer pageNo, Integer pageSize, String name);

    Boolean save(String name, String description, MultipartFile file);

    Boolean update(String id,String name ,String description,MultipartFile file);


    Boolean delete(String id, Boolean active);
}
