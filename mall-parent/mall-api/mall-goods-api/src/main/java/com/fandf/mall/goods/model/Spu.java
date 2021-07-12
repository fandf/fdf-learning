package com.fandf.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "spu")
@ApiModel("spu")
public class Spu {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String id;

    /**
     * spu名
     */
    @ApiModelProperty("spu名")
    private String name;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String intro;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Integer brandId;

    /**
     * 一级分类
     */
    @ApiModelProperty("一级分类")
    private Integer categoryOneId;

    /**
     * 二级分类
     */
    @ApiModelProperty("二级分类")
    private Integer categoryTwoId;

    /**
     * 三级分类
     */
    @ApiModelProperty("三级分类")
    private Integer categoryThreeId;

    /**
     * 图片列表
     */
    @ApiModelProperty("图片列表")
    private String images;

    /**
     * 售后服务
     */
    @ApiModelProperty("售后服务")
    private String afterSalesService;

    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String content;

    /**
     * 规格列表
     */
    @ApiModelProperty("规格列表")
    private String attributeList;

    /**
     * 是否上架，0已下架，1已上架
     */
    @ApiModelProperty("是否上架，0已下架，1已上架")
    private Integer isMarketable;

    /**
     * 是否删除，0:未删除，1：已删除
     */
    @ApiModelProperty("是否删除，0:未删除，1：已删除")
    private Integer isDelete;

    /**
     * 审核状态，0：未审核，1：已审核，2：审核不通过
     */
    @ApiModelProperty("审核状态，0：未审核，1：已审核，2：审核不通过")
    private Integer status;
}
