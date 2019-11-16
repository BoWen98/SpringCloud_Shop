package com.bowen.shop.feign;

import com.bowen.shop.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("shop-member")
public interface MemberServiceFeign extends MemberService {

}
