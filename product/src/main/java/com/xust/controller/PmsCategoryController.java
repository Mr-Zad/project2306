package com.xust.controller;


import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xust.VO.ResultJson;
import com.xust.entity.PmsCategory;
import com.xust.service.PmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author zs
 * @since 2024-03-19
 */
@RestController
@RequestMapping("/pmsCategory")
public class PmsCategoryController {

    @Resource
    PmsCategoryService pmsCategoryService;

    @GetMapping("/list")
    public ResultJson<List<PmsCategory>> getPmsCategoryList(){
        return ResultJson.success(pmsCategoryService.getAll());
    }

    @GetMapping("/getById")
    public ResultJson<PmsCategory> getById(String id){
        return ResultJson.success(pmsCategoryService.getById(id));
    }

    @PostMapping("/save")
    public ResultJson<Boolean> save(String name,String parentId,Integer level){
        return ResultJson.success(pmsCategoryService.save(name,parentId,level),"添加分类成功");
    }

    @PostMapping("/update")
    public ResultJson<Boolean> update(String id,String name){
        return ResultJson.success(pmsCategoryService.update(id,name),"更新分类成功");
    }

    @PostMapping("/delete")
    public ResultJson<Boolean> delete(String id,Boolean active){
        return ResultJson.success(pmsCategoryService.delete(id,active),active? "启用分类成功":"禁用分类成功");
    }
}
