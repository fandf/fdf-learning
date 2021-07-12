package com.fandf.mall.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category_brand")
@ApiModel("品牌分类表")
public class CategoryBrand {

    @ApiModelProperty("分类id")
    private Integer categoryId;

    @ApiModelProperty("品牌id")
    private Integer brandId;
}
