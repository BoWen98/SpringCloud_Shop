package com.bowen.shop.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.bowen.shop.base.BaseApiService;
import com.bowen.shop.base.BaseResponse;
import com.bowen.shop.bean.EntityBeanUtils;
import com.bowen.shop.client.VerificaCodeServiceFeign;
import com.bowen.shop.constants.Constants;
import com.bowen.shop.input.UserInpDTO;
import com.bowen.shop.mapper.UserMapper;
import com.bowen.shop.mapper.entity.UserDo;
import com.bowen.shop.service.MemberRegisterService;
import com.bowen.shop.utils.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VerificaCodeServiceFeign verificaCodeServiceFeign;

    @Transactional
    public BaseResponse<JSONObject> register(@RequestBody UserInpDTO userInpDTO, String registCode) {
        // 1.参数验证
        // String userName = userInpDTO.getUserName();
        // if (StringUtils.isEmpty(userName)) {
        //     return setResultError("用户名称不能为空!");
        // }
        String mobile = userInpDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = userInpDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        // 2.验证码注册码是否正确 暂时省略 会员调用微信接口实现注册码验证
        BaseResponse<JSONObject> verificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile, registCode);
        if (!verificaWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)) {
            return setResultError(verificaWeixinCode.getMsg());
        }
        //3.对用户的密码进行加密
        // MD5 可以解密 暴力破解
        String newPassword = MD5Util.MD5(password);
        userInpDTO.setPassword(newPassword);

        UserDo userDo = EntityBeanUtils.dtoToDo(userInpDTO, UserDo.class);

        // 4.调用数据库插入数据
        return userMapper.register(userDo) > 0 ? setResultSuccess("注册成功") : setResultError("注册失败!");
    }

}
