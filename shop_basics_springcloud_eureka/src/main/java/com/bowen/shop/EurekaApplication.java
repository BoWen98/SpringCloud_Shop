package com.bowen.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop
 * @ClassName: EurekaApplication
 * @Author: Bowen
 * @Description: Eureka启动类
 * @Date: 2019/11/6 10:41
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
