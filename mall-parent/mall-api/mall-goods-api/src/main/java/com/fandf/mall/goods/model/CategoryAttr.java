package com.fandf.mall.goods.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category_attr")
@ApiModel("商品类目属性表")
public class CategoryAttr {

    @ApiModelProperty("商品分类id")
    private Integer categoryId;

    @ApiModelProperty("属性分类id")
    private Integer attrId;

}
