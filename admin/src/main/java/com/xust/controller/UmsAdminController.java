package com.xust.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xust.VO.ResultJson;
import com.xust.entity.UmsAdmin;
import com.xust.service.UmsAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author zs
 * @since 2024-03-01
 */
@RestController
@RequestMapping("/umsAdmin")
public class UmsAdminController {

    @Resource
    UmsAdminService umsAdminService;

    @GetMapping("/list")
   /* public List<UmsAdmin> list(){
        return umsAdminService.getUmsAdminList();
    }*/
    public ResultJson<IPage<UmsAdmin>> getUmsAdminPage(Integer pageNo, Integer pageSize,String name) throws InterruptedException {

        TimeUnit.MICROSECONDS.sleep(2000);
        //System.out.println(10/0);
        return ResultJson.success(umsAdminService.getUmsAdminPage(pageNo,pageSize,name));

    }

    @PostMapping("/save")
    public ResultJson<Boolean> save(String name, String phone, String email, Integer gender, String password, MultipartFile file) {
        //System.out.println();
        return ResultJson.success(umsAdminService.save(name,phone,email,gender,password,file),"添加管理员成功");
    }

}
