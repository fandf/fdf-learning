package com.fandf.mall.goods.feign;

import com.fandf.mall.goods.model.Category;
import com.fandf.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*****
 * @Author:
 * @Description:
 ****/
@FeignClient(value = "mall-goods")
public interface CategoryFeign {

    /****
     * 根据分类查询分类信息
     */
    @GetMapping(value = "/category/{id}")
    RespResult<Category> one(@PathVariable(value = "id")Integer id);
}
