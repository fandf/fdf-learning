package com.fandf.mall.goods.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sku_attribute")
@ApiModel("sku_attribute表")
public class SkuAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 属性名称
     */
    @ApiModelProperty("属性名称")
    private String name;

    /**
     * 属性选项
     */
    @ApiModelProperty("属性选项")
    private String options;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    //对应分类
    @TableField(exist = false)
    private List<Category> categories;

}
