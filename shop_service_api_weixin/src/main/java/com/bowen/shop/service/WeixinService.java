package com.bowen.shop.service;

import com.bowen.shop.entity.WeixinEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.service
 * @ClassName: WeixinService
 * @Author: Bowen
 * @Description: 微信接口
 * @Date: 2019/11/6 11:14
 * @Version: 1.0.0
 */
@Api(tags = "会员服务接口")
public interface WeixinService {

    @ApiOperation(value = "会员调用微信接口服务")
    @GetMapping("/getApp")
    public WeixinEntity getApp();
}
