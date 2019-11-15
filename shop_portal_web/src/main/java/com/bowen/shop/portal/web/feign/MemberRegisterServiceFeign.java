package com.bowen.shop.portal.web.feign;

import com.bowen.shop.service.MemberRegisterService;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("shop-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {

}
