package com.fandf.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*****
 * @Author:
 * @Description:
 ****/
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.fandf.mall.goods.feign"})
public class MallWebPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWebPageApplication.class,args);
    }
}
