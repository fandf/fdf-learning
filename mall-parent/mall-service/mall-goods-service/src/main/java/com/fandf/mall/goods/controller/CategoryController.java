package com.fandf.mall.goods.controller;

import com.fandf.mall.goods.model.Category;
import com.fandf.mall.goods.service.CategoryService;
import com.fandf.mall.util.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/category")
@CrossOrigin
@Api(tags = "商品分类接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /****
     * 根据分类父ID查询子分类
     */
    @GetMapping(value = "/parent/{id}")
    @ApiOperation("根据分类父ID查询子分类")
    public RespResult<List<Category>> findByParentId(@PathVariable("id")Integer id){
        return RespResult.ok(categoryService.findByParentId(id));
    }

}
