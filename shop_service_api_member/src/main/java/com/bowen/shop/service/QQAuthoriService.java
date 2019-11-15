package com.bowen.shop.service;

import com.alibaba.fastjson.JSONObject;
import com.bowen.shop.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



public interface QQAuthoriService {
	/**
	 * 根据 openid查询是否已经绑定,如果已经绑定，则直接实现自动登陆
	 * 
	 * @param openid
	 * @return
	 */
	@RequestMapping("/findByOpenId")
    BaseResponse<JSONObject> findByOpenId(@RequestParam("qqOpenId") String qqOpenId);

}
