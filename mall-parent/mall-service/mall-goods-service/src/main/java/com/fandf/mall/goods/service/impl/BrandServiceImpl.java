package com.fandf.mall.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fandf.mall.goods.mapper.BrandMapper;
import com.fandf.mall.goods.model.Brand;
import com.fandf.mall.goods.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dongfengfan
 * @date 2021/7/6 下午5:20
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    /****
     * 条件查询
     * return List<Brand>
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //根据name查询品牌
        queryWrapper.like("name", brand.getName());

        //根据initial查询
        queryWrapper.eq("initial", brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        //根据name查询品牌
        if (StrUtil.isNotBlank(brand.getName())) {
            queryWrapper.like("name", brand.getName());
        }
        return brandMapper.selectPage(new Page<>(currentPage, size), queryWrapper);
    }
}
