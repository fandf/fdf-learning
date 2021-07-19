package com.fandf.mall.goods.controller;

import com.fandf.mall.goods.model.Product;
import com.fandf.mall.goods.model.Sku;
import com.fandf.mall.goods.service.SkuService;
import com.fandf.mall.goods.service.SpuService;
import com.fandf.mall.model.Cart;
import com.fandf.mall.util.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sku")
@CrossOrigin
@Api(tags = "sku接口")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /*****
     * 产品保存
     */
    @GetMapping(value = "/aditems/type")
    @ApiOperation("首页展示列表")
    public RespResult<List<Sku>> save(Integer id){
        return RespResult.ok(skuService.typeSkuItems(id));
    }

    /****
     * 根据推广分类查询推广产品列表
     */
    @DeleteMapping(value = "/aditems/type")
    public RespResult delTypeItems(@RequestParam(value = "id")Integer id){
        skuService.delTypeSkuItems(id);
        return RespResult.ok();
    }

    /****
     * 根据推广分类查询推广产品列表
     *
     */
    @PutMapping(value = "/aditems/type")
    public RespResult updateTypeItems(@RequestParam(value = "id")Integer id){
        //修改
        skuService.updateTypeSkuItems(id);
        return RespResult.ok();
    }

    /****
     * 根据ID获取Sku
     */
    @GetMapping(value = "/{id}")
    public RespResult<Sku> one(@PathVariable(value = "id") String id){
        Sku sku = skuService.getById(id);
        return RespResult.ok(sku);
    }

    /***
     * 库存递减
     * @param carts
     * @return
     */
    @PostMapping(value = "/dcount")
    public RespResult decount(@RequestBody List<Cart> carts){
        skuService.decount(carts);
        return RespResult.ok();
    }

}
