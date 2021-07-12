package com.fandf.mall.goods.feign;

import com.fandf.mall.goods.model.Sku;
import com.fandf.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author dongfengfan
 * @date 2021/7/11 下午4:20
 */
@FeignClient(value = "mall-goods")
public interface SkuFeign {

    /****
     * 根据推广分类查询推广产品列表
     */
    @GetMapping(value = "/sku/aditems/type")
    List<Sku> typeItems(@RequestParam(value = "id")Integer id);

    /****
     * 根据推广分类查询推广产品列表
     *
     */
    @DeleteMapping(value = "/sku/aditems/type")
    RespResult delTypeItems(@RequestParam(value = "id")Integer id);

    /****
     * 根据推广分类查询推广产品列表
     */
    @PutMapping(value = "/sku/aditems/type")
    RespResult updateTypeItems(@RequestParam(value = "id")Integer id);

}
