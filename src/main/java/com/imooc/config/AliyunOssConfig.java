package com.imooc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "aliyunOss")
//@PropertySource(value = "classpath:aliyun.properties")
public class AliyunOssConfig {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String urlPrefix;

}
