package com.fandf.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fandf.mall.goods.model.Sku;
import com.fandf.mall.goods.model.SkuAttribute;

import java.util.List;


public interface SkuService extends IService<Sku> {

    /**
     * 根据推广产品分类ID查询指定分类下的产品列表
     * @param id
     * @return
     */
    List<Sku> typeSkuItems(Integer id);

    void delTypeSkuItems(Integer id);

    List<Sku> updateTypeSkuItems(Integer id);
}
