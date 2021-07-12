package com.fandf.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fandf.mall.goods.model.SkuAttribute;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuAttributeMapper extends BaseMapper<SkuAttribute> {

    /****
     * 1、根据分类ID查询属性ID集合
     * 2、根据属性ID集合查询属性集合
     */
    @Select("select * from sku_attribute where id IN(SELECT attr_id FROM category_attr WHERE category_id=#{id})")
    List<SkuAttribute> queryByCategoryId(Integer id);

}
