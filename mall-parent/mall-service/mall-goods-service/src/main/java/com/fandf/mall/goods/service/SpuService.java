package com.fandf.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fandf.mall.goods.model.Product;
import com.fandf.mall.goods.model.Sku;
import com.fandf.mall.goods.model.Spu;

import java.util.List;


public interface SpuService extends IService<Spu> {

    /****
     * 产品保存
     */
    void saveProduct(Product product);

    Product findBySupId(String id);

}
