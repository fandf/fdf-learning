package com.fandf.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author dongfengfan
 * @date 2021/7/6 下午5:20
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.fandf.mall.goods.mapper"})
public class MallGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGoodsApplication.class,args);
    }

}
