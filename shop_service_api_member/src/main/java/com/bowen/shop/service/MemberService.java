package com.bowen.shop.service;

import com.bowen.shop.entity.WeixinEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.service
 * @ClassName: MemberService
 * @Author: Bowen
 * @Description: 会员接口
 * @Date: 2019/11/6 12:14
 * @Version: 1.0.0
 */
@Api(tags = "微信服务")
public interface MemberService {

    @ApiOperation(value = "微信服务接口")
    @GetMapping("/getAppToWeixin")
    public WeixinEntity getAppToWeixin();
}
