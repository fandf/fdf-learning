package com.fandf.mall.search.feign;

import com.fandf.mall.search.model.SkuEs;
import com.fandf.mall.util.RespResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*****
 * @Author:
 * @Description:
 ****/
@FeignClient(value = "mall-search")
public interface SkuSearchFeign {


    /*****
     * 增加索引
     */
    @PostMapping(value = "/search/add")
    RespResult add(@RequestBody SkuEs skuEs);

    /***
     * 删除索引
     */
    @DeleteMapping(value = "/search/del/{id}")
    RespResult del(@PathVariable(value = "id")String id);


    /****
     * 商品搜索
     */
    @GetMapping
    RespResult<Map<String,Object>> search(@RequestParam Map<String,Object> searchMap);
}
