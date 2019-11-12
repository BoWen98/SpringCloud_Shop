package com.bowen.shop.serviceImpl;

import com.bowen.shop.base.BaseApiService;
import com.bowen.shop.base.BaseResponse;
import com.bowen.shop.bean.EntityBeanUtils;
import com.bowen.shop.constants.Constants;
import com.bowen.shop.mapper.UserMapper;
import com.bowen.shop.mapper.entity.UserDo;
import com.bowen.shop.output.UserOutDTO;
import com.bowen.shop.service.MemberService;
import com.bowen.shop.token.GenerateToken;
import com.bowen.shop.type.TypeCastHelper;
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
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GenerateToken generateToken;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        // 1.验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }

        // 2.根据手机号码查询用户信息 单独定义code 表示是用户信息不存在把
        UserDo userEntity = userMapper.existMobile(mobile);
        if (userEntity == null) {
            return setResultError(Constants.HTTP_RES_CODE_EXISTMOBILE_203, "用户信息不存在!");
        }

        // 3.将do转换成dto
        return setResultSuccess(EntityBeanUtils.doToDto(userEntity, UserOutDTO.class));
    }

    @Override
    public BaseResponse<UserOutDTO> getInfo(String token) {
        // 1.验证token参数
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空!");
        }
        // 2.使用token查询redis 中的userId
        String redisUserId = generateToken.getToken(token);
        if (StringUtils.isEmpty(redisUserId)) {
            return setResultError("token已经失效或者token错误!");
        }
        // 3.使用userID查询 数据库用户信息
        Long userId = TypeCastHelper.toLong(redisUserId);
        UserDo userDo = userMapper.findByUserId(userId);
        if (userDo == null) {
            return setResultError("用户不存在!");
        }
        // 下节课将 转换代码放入在BaseApiService
        return setResultSuccess(EntityBeanUtils.doToDto(userDo, UserOutDTO.class));
    }
}
