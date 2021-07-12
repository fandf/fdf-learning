package com.fandf.mall.goods.controller;

import com.fandf.mall.goods.model.SkuAttribute;
import com.fandf.mall.goods.service.SkuAttributeService;
import com.fandf.mall.util.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/skuAttribute")
@CrossOrigin
@Api(tags = "sku属性查询")
public class SkuAttributeController {

    @Autowired
    private SkuAttributeService skuAttributeService;

    /*****
     * 根据分类ID查询属性集合
     */
    @GetMapping(value = "/category/{id}")
    @ApiOperation("根据分类ID查询属性集合")
    public RespResult<List<SkuAttributeController>> categorySkuAttributeList(@PathVariable(value = "id")Integer id){
        List<SkuAttribute> skuAttributes = skuAttributeService.queryList(id);
        return RespResult.ok(skuAttributes);
    }
}
