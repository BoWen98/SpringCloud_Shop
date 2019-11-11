package com.bowen.shop.serviceImpl;

import com.bowen.shop.base.BaseApiService;
import com.bowen.shop.base.BaseResponse;
import com.bowen.shop.constants.Constants;
import com.bowen.shop.entity.UserEntity;
import com.bowen.shop.mapper.UserMapper;
import com.bowen.shop.service.MemberService;
import org.apache.commons.lang.StringUtils;
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
public class MemberServiceImpl extends BaseApiService<UserEntity> implements MemberService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResponse<UserEntity> existMobile(String mobile) {
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        // 2.根据手机号码查询用户信息 单独定义code 表示是用户信息不存在把
        UserEntity userEntity = userMapper.existMobile(mobile);
        if (userEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户信息不存在!");
        }
        // 对特殊铭感字段需要做脱敏
        userEntity.setPassword(null);
        return setResultSuccess(userEntity);
    }
}
