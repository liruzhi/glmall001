package com.glmall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 远程调用其他服务的步骤：
 *  1. 引入open-feign
 *  2. 编写一个接口，告诉springCloud该接口需要调用的远程服务
 *  3. 开启远程调用功能
 */

@EnableCaching
//扫描mapper文件夹
@MapperScan("com.glmall.user.mapper")
@EnableDiscoveryClient
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication()
@EnableFeignClients(basePackages = "com.glmall.user.feign")
public class GlmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlmallUserApplication.class, args);
    }

}
