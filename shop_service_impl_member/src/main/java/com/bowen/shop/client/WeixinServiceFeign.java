package com.bowen.shop.client;

import com.bowen.shop.service.WeixinService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.client
 * @ClassName: WeixinServiceFeign
 * @Author: Bowen
 * @Description: 微信接口feign调用
 * @Date: 2019/11/6 12:22
 * @Version: 1.0.0
 */
@FeignClient("shop-weixin")
public interface WeixinServiceFeign extends WeixinService {


}
