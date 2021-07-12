package com.fandf.mall.search.service;


import com.fandf.mall.search.model.SkuEs;

import java.util.Map;

public interface SkuSearchService {

    /****
     * 搜索数据
     */
    Map<String,Object> search(Map<String,Object> searchMap);

    //增加索引
    void add(SkuEs skuEs);
    //删除索引
    void del(String id);
}
