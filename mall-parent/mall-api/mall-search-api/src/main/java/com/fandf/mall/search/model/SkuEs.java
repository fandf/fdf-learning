package com.fandf.mall.search.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Map;

/*****
 * @Author:
 * @Description:
 ****/
@Data
@Document(indexName = "shopsearch",type = "skues")
@ApiModel("商品es实体")
public class SkuEs {

    @Id
    @ApiModelProperty("id")
    private String id;
    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    @ApiModelProperty("id")
    private String name;
    @ApiModelProperty("价格")
    private Integer price;
    @ApiModelProperty("数量")
    private Integer num;
    @ApiModelProperty("首页图")
    private String image;
    @ApiModelProperty("图片列表")
    private String images;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
    @ApiModelProperty("spuId")
    private String spuId;
    @ApiModelProperty("分类id")
    private Integer categoryId;
    //Keyword：不分词
    @Field(type= FieldType.Keyword)
    @ApiModelProperty("分类名称")
    private String categoryName;
    @ApiModelProperty("品牌ID")
    private Integer brandId;
    @Field(type=FieldType.Keyword)
    @ApiModelProperty("品牌名称")
    private String brandName;
    @Field(type=FieldType.Keyword)
    @ApiModelProperty("附加属性")
    private String skuAttribute;
    @ApiModelProperty("状态")
    private Integer status;

    //属性映射(动态创建域信息)
    //key=就业薪资
    //value=1万
    //attrMap.就业薪资.keyword=1万
    @ApiModelProperty("属性映射动态信息")
    private Map<String,String> attrMap;
}