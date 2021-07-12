package com.fandf.mall.goods.controller;

import com.fandf.mall.goods.model.Product;
import com.fandf.mall.goods.service.SpuService;
import com.fandf.mall.util.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/spu")
@CrossOrigin
@Api(tags = "spu接口")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /*****
     * 产品保存
     */
    @PostMapping(value = "/save")
    @ApiOperation("产品保存")
    public RespResult save(@RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }
}
