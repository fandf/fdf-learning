package com.fandf.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品表")
@TableName(value = "sku")
public class Sku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private String id;

    /**
     * sku名称
     */
    @ApiModelProperty("sku名称")
    private String name;

    /**
     * 价格（分）
     */
    @ApiModelProperty("价格（分）")
    private Integer price;

    /**
     * 库存数量
     */
    @ApiModelProperty("库存数量")
    private Integer num;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String image;

    /**
     * 商品图片列表
     */
    @ApiModelProperty("商品图片列表")
    private String images;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * spuid
     */
    @ApiModelProperty("spuid")
    private String spuId;

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    private Integer categoryId;

    /**
     * 类目名称
     */
    @ApiModelProperty("类目名称")
    private String categoryName;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Integer brandId;

    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    private String skuAttribute;

    /**
     * 商品状态 1-正常，2-下架，3-删除
     */
    @ApiModelProperty("商品状态 1-正常，2-下架，3-删除")
    private Integer status;
}
