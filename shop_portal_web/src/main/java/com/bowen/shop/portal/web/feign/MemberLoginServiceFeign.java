package com.bowen.shop.portal.web.feign;

import com.bowen.shop.service.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("shop-member")
public interface MemberLoginServiceFeign extends MemberLoginService {

}
