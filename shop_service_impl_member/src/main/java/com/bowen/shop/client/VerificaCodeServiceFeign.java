package com.bowen.shop.client;

import com.bowen.shop.service.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;



@FeignClient("shop-weixin")
public interface VerificaCodeServiceFeign extends VerificaCodeService {

}
