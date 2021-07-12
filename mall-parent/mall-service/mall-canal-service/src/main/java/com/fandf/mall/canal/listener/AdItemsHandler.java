package com.fandf.mall.canal.listener;

import com.fandf.mall.goods.feign.SkuFeign;
import com.fandf.mall.goods.model.AdItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/*****
 * @Author:
 * @Description:
 ****/
@Component
@CanalTable(value = "ad_items")
public class AdItemsHandler implements EntryHandler<AdItems> {

    @Autowired
    private SkuFeign skuFeign;

    /****
     * 数据库增加数据，执行该方法
     * @param adItems
     */
    @Override
    public void insert(AdItems adItems) {
        System.out.println("新增------" + adItems);
        //重新加载缓存
        skuFeign.updateTypeItems(adItems.getType());
    }

    /****
     * 数据库修改数据，执行该方法
     */
    @Override
    public void update(AdItems before, AdItems after) {
        System.out.println("修改前---" + before);
        System.out.println("修改后---" + after);
        if(before.getType() != null && before.getType().intValue()!=after.getType().intValue()){
            //重新加载变更前分类的ID对应的推广产品
            skuFeign.updateTypeItems(before.getType());
        }

        //重新加载缓存
        skuFeign.updateTypeItems(after.getType());
    }

    /****
     * 数据库删除数据，执行该方法
     */
    @Override
    public void delete(AdItems adItems) {
        System.out.println("删除" + adItems);
        skuFeign.delTypeItems(adItems.getType());
    }
}
