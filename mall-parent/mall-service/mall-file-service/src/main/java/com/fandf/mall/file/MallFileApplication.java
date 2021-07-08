package com.fandf.mall.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author dongfengfan
 * @date 2021/7/7 上午11:34
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallFileApplication.class, args);
    }

}
