package com.bowen.shop;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop
 * @ClassName: WeixinApplication
 * @Author: Bowen
 * @Description: 微信启动类
 * @Date: 2019/11/6 11:51
 * @Version: 1.0.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@EnableApolloConfig
public class WeixinApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class, args);
    }
}
