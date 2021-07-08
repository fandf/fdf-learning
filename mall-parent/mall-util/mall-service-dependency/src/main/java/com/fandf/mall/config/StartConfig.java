package com.fandf.mall.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dongfengfan
 * @date 2021/7/6 下午5:15
 */
@Configuration
public class StartConfig {

    /****
     * 分页拦截器
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor pageInterceptor = new PaginationInterceptor();
        // 设置数据类型
        pageInterceptor.setDbType(DbType.MYSQL);
        return pageInterceptor;
    }
}
