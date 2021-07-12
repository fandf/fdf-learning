package com.fandf.mall.goods.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("产品表")
public class Product {
    @ApiModelProperty("spu")
    private Spu spu;
    @ApiModelProperty("sku")
    private List<Sku> skus;
}
