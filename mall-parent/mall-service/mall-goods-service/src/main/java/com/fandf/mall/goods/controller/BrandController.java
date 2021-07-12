package com.fandf.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fandf.mall.goods.model.Brand;
import com.fandf.mall.goods.service.BrandService;
import com.fandf.mall.util.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dongfengfan
 * @date 2021/7/6 下午5:20
 */
@RestController
@RequestMapping(value = "/brand")
@Api(tags = "品牌服务")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /****
     * 增加方法
     */
    @PostMapping
    @ApiOperation("新增")
    public RespResult add(@RequestBody Brand brand){
        brandService.save(brand);
        return RespResult.ok();
    }

    /****
     * 修改方法
     */
    @PutMapping
    @ApiOperation("修改")
    public RespResult update(@RequestBody Brand brand){
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /****
     * 删除方法
     */
    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public RespResult delete(@PathVariable(value = "id")String id){
        brandService.removeById(id);
        return RespResult.ok();
    }

    /****
     * 条件查询
     */
    @GetMapping(value = "/search")
    @ApiOperation("查询")
    public RespResult<List<Brand>> queryList(@RequestBody Brand brand){
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    /****
     * 条件查询分页
     */
    @GetMapping(value = "/search/{page}/{size}")
    @ApiOperation("分页查询")
    public RespResult<Page<Brand>> queryPageList(
            @PathVariable(value = "page")Long page,
            @PathVariable(value = "size")Long size,
            @RequestBody Brand brand){
        Page<Brand> pageInfo = brandService.queryPageList(brand,page,size);
        return RespResult.ok(pageInfo);
    }
}
