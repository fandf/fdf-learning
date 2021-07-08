package com.fandf.mall.file.controller;

import cn.hutool.core.io.IoUtil;
import com.fandf.mall.file.fastdfs.FastDFSClientUtil;
import com.fandf.mall.util.RespResult;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.oracle.webservices.internal.api.message.ContentType;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Set;

/**
 * @author dongfengfan
 * @date 2021/7/7 上午11:34
 */
@RestController
@RequestMapping(value = "/file")
@Api(tags = "文件上传下载")
public class UploadController {

    @Autowired
    private FastDFSClientUtil fastDFSClientUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    @ApiOperation("上传")
    public RespResult<String> upload(MultipartFile file) throws IOException {
        return RespResult.ok(fastDFSClientUtil.uploadFile(file));
    }

    /**
     * 文件下载
     * @return
     */
    @GetMapping(value = "/download")
    @ApiOperation("下载")
    public void download(@ApiParam(value = "文件路径",required = true) String path, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        Set<MetaData> metaData = fastDFSClientUtil.getMetaData(path);
        String filename = "";
        for (MetaData data : metaData) {
            if (Objects.equals(data.getName(), FastDFSClientUtil.FILENAME)) {
                filename = data.getValue();
                break;
            }
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        InputStream inputStream = fastDFSClientUtil.download(path);
        ServletOutputStream outputStream = response.getOutputStream();
        IoUtil.copy(inputStream, outputStream);
    }
}
