package com.xust.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xust.VO.ResultJson;
import com.xust.entity.PmsBrand;
import com.xust.entity.UmsAdmin;
import com.xust.service.PmsBrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {
    @Resource
    PmsBrandService pmsBrandService;

    @GetMapping("/list")
    public ResultJson<IPage<PmsBrand>> getUmsAdminPage(Integer pageNo, Integer pageSize, String name) throws InterruptedException {

        TimeUnit.MICROSECONDS.sleep(2000);
        //System.out.println(10/0);
        return ResultJson.success(pmsBrandService.getPmsBrandPage(pageNo, pageSize, name));

    }

    @PostMapping("/save")
    public ResultJson<Boolean> save(String name, String description,MultipartFile file) {
        //System.out.println();
        return ResultJson.success(pmsBrandService.save(name,description,file), "添加品牌成功");
    }

    @GetMapping("/getById")
    public ResultJson<PmsBrand> getById(String id){
        return ResultJson.success(pmsBrandService.getById(id));
    }

    @PostMapping("/update")
    public ResultJson<Boolean> update(String id,String name, String description, MultipartFile file){

        return ResultJson.success(pmsBrandService.update(id,name,description,file),"修改品牌成功");
    }

    @PostMapping("/delete")
    public ResultJson<Boolean> delete(String id,Boolean active){

        return ResultJson.success(pmsBrandService.delete(id,active));
    }

}
