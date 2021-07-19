package com.fandf.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fandf.mall.goods.mapper.AdItemsMapper;
import com.fandf.mall.goods.mapper.SkuAttributeMapper;
import com.fandf.mall.goods.mapper.SkuMapper;
import com.fandf.mall.goods.model.AdItems;
import com.fandf.mall.goods.model.Sku;
import com.fandf.mall.goods.model.SkuAttribute;
import com.fandf.mall.goods.service.SkuAttributeService;
import com.fandf.mall.goods.service.SkuService;
import com.fandf.mall.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private AdItemsMapper adItemsMapper;
    @Autowired
    private SkuMapper skuMapper;

    @Override
//    @Cacheable(cacheNames = "ad-items-skus", key = "#id")
    @Cacheable(key ="#id" )
    public List<Sku> typeSkuItems(Integer id) {
        System.out.println("查询数据库");
        //1.查询当前分类下的所有产品列表
        LambdaQueryWrapper<AdItems> wrapper = new LambdaQueryWrapper<AdItems>().eq(AdItems::getType, id);
        List<AdItems> adItems = adItemsMapper.selectList(wrapper);
        //2.根据推广列表查询产品列表
        List<String> skuIds = adItems.stream().map(AdItems::getSkuId).collect(Collectors.toList());
        return this.listByIds(skuIds);
    }

    /***
     * 根据分类id删除指定推广数据
     * @param id
     * @return
     */
    //@CacheEvict(cacheNames = "ad-items-skus",key ="#id" )
    @CacheEvict(key ="#id" )
    @Override
    public void delTypeSkuItems(Integer id) {}

    /****
     * 修改缓存
     * @param id
     * @return
     */
    //@CachePut(cacheNames = "ad-items-skus",key = "#id")
    @CachePut(key = "#id")
    @Override
    public List<Sku> updateTypeSkuItems(Integer id) {
        //1.查询当前分类下的所有列表信息
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        //2.根据推广列表查询产品列表信息
        List<String> skuids = adItems.stream().map(adItem->adItem.getSkuId()).collect(Collectors.toList());
        return skuids==null || skuids.size()<=0? null : this.listByIds(skuids);
    }

    /***
     * 库存递减
     * @param carts
     */
    @Override
    public void decount(List<Cart> carts) {
        for (Cart cart : carts) {
            //语句级控制，防止超卖
            int count = skuMapper.decount(cart.getSkuId(),cart.getNum());
            if(count<=0){
                throw new RuntimeException("库存不足！");
            }
        }
    }

}
