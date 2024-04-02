package com.xust.controller;


import com.xust.VO.ResultJson;
import com.xust.entity.PmsAttr;
import com.xust.entity.PmsCategory;
import com.xust.service.PmsAttrService;
import com.xust.service.PmsCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 分类属性表 前端控制器
 * </p>
 *
 * @author zs
 * @since 2024-03-26
 */
@RestController
@RequestMapping("/pmsAttr")
public class PmsAttrController {

    @Resource
    PmsAttrService pmsAttrService;
    @Resource
    PmsCategoryService pmsCategoryService;

    @GetMapping("/getCategory")
    public ResultJson<List<PmsCategory>> getCategory(){
        List<PmsCategory> all = pmsCategoryService.getAll();
        return ResultJson.success(all);
    }

    @GetMapping("/list")
    public ResultJson<List<PmsAttr>> list(String[] categoryIds){
        return ResultJson.success(pmsAttrService.list(categoryIds));
    }

    @PostMapping("/save")
    public ResultJson<Boolean> save(String name,String categoryId,Integer type){
        return ResultJson.success(pmsAttrService.save(name,categoryId,type),"添加属性成功");
    }

    @PostMapping("/update")
    public ResultJson<Boolean> update(String name,String id,Integer type){
        return ResultJson.success(pmsAttrService.update(id,name,type),"修改属性成功");
    }

    @PostMapping("/delete")
    public ResultJson<Boolean> delete(String id){
        return ResultJson.success(pmsAttrService.delete(id),"删除属性成功");
    }

    @PostMapping("/getById")
    public ResultJson<PmsAttr> save(String id){
        return ResultJson.success(pmsAttrService.getById(id));
    }
}

