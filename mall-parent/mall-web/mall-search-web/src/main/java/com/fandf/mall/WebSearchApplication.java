package com.fandf.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dongfengfan
 * @date 2021/7/17 下午4:19
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.fandf.mall.search.feign")
public class WebSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSearchApplication.class,args);
    }

}
