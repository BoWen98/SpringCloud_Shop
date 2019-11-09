package com.bowen.shop.serviceImpl;

import com.bowen.shop.client.WeixinServiceFeign;
import com.bowen.shop.entity.WeixinEntity;
import com.bowen.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop
 * @ClassName: MemberServiceImpl
 * @Author: Bowen
 * @Description: 会员接口实现类
 * @Date: 2019/11/6 12:16
 * @Version: 1.0.0
 */
@RestController
public class MemberServiceImpl implements MemberService {

    @Autowired
    WeixinServiceFeign weixinServiceFeign;

    @Override
    public WeixinEntity getAppToWeixin() {
        return weixinServiceFeign.getApp();
    }
}
