package com.fandf.mall.goods.feign;

import com.fandf.mall.goods.model.Product;
import com.fandf.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****
 * @Author:
 * @Description:
 ****/
@FeignClient(value = "mall-goods")    //服务名字
public interface SpuFeign {

    /***
     * 查询Product
     */
    @GetMapping(value = "/spu/product/{id}")
    RespResult<Product> one(@PathVariable(value = "id")String id);
}
