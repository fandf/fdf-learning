package com.fandf.mall.search.controller;

import com.fandf.mall.search.feign.SkuSearchFeign;
import com.fandf.mall.util.RespResult;
import com.fandf.mall.util.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author dongfengfan
 * @date 2021/7/17 下午4:23
 */
@Controller
@RequestMapping(value = "/web/search")
public class SearchController {

    @Autowired
    SkuSearchFeign skuSearchFeign;

    /****
     * 搜索页面跳转
     * @return
     */
    @GetMapping
    public String search(@RequestParam(required = false) Map<String,Object> searchMap, Model model){
        //搜索
        RespResult<Map<String, Object>> resultMap = skuSearchFeign.search(searchMap);

        //组装用户访问的url
        model.addAttribute("url", UrlUtils.map2url("/web/search",searchMap,"page"));
        model.addAttribute("urlsort", UrlUtils.map2url("/web/search",searchMap,"sm","sfield","page"));
        model.addAttribute("result",resultMap.getData());
        model.addAttribute("searchMap",searchMap);
        return "search";
    }

}
