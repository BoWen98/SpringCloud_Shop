package com.bowen.shop.portal.web.feign;

import com.bowen.shop.service.QQAuthoriService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("shop-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
