package com.bowen.shop.serviceImpl;

import com.bowen.shop.entity.WeixinEntity;
import com.bowen.shop.service.WeixinService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.ServiceImpl
 * @ClassName: WeixinServiceImpl
 * @Author: Bowen
 * @Description: 微信实现
 * @Date: 2019/11/6 11:44
 * @Version: 1.0.0
 */
@RestController
public class WeixinServiceImpl implements WeixinService {

    @Override
    public WeixinEntity getApp() {
        return new WeixinEntity("libowen", "376512291");
    }
}
