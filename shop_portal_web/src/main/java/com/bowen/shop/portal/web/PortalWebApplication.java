package com.bowen.shop.portal.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.potal.web
 * @ClassName: PortalWebApplication
 * @Author: Bowen
 * @Description: 门户
 * @Date: 2019/11/12 21:51
 * @Version: 1.0.0
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableEurekaClient
@EnableFeignClients
public class PortalWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalWebApplication.class, args);
    }
}
