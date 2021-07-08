package com.fandf.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fandf.mall.goods.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongfengfan
 * @date 2021/7/6 下午5:20
 */
public interface BrandService extends IService<Brand> {

    /****
     * 条件查询
     * return List<Brand>
     */
    List<Brand> queryList(Brand brand);

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    Page<Brand> queryPageList(Brand brand,Long currentPage,Long size);

}
