package com.fandf.mall.file.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author dongfengfan
 * @date 2021/7/7 下午1:39
 */
@Configuration
@Import(FdfsClientConfig.class)
public class FastDFSConfig {
}
