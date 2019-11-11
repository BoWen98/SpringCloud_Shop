package com.bowen.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.entity
 * @ClassName: WeixinEntity
 * @Author: Bowen
 * @Description: 微信实体类
 * @Date: 2019/11/6 11:34
 * @Version: 1.0.0
 */
@Data
@ToString
@AllArgsConstructor
public class WeixinEntity {

    private String appId;

    private String appName;
}
