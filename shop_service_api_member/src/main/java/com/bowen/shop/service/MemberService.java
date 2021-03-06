package com.bowen.shop.service;


import com.bowen.shop.base.BaseResponse;
import com.bowen.shop.input.UserLoginInpDTO;
import com.bowen.shop.output.UserOutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: SpringCloud_Shop
 * @Package: com.bowen.shop.service
 * @ClassName: MemberService
 * @Author: Bowen
 * @Description: 会员接口
 * @Date: 2019/11/6 12:14
 * @Version: 1.0.0
 */
@Api(tags = "微信服务")
public interface MemberService {

    /**
     * 根据手机号码查询是否已经存在,如果存在返回当前用户信息
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "根据手机号码查询是否已经存在")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"),})
    @PostMapping("/existMobile")
    BaseResponse<UserOutDTO> existMobile(@RequestParam("mobile") String mobile);


    @PostMapping("/getUserInfo")
    @ApiOperation(value = "/getUserInfo")
    BaseResponse<UserOutDTO> getInfo(@RequestParam("token") String token);

    /**
     * SSO认证系统登陆接口
     *
     * @param userLoginInpDTO
     * @return
     */
    @PostMapping("/ssoLogin")
    public BaseResponse<UserOutDTO> ssoLogin(@RequestBody UserLoginInpDTO userLoginInpDTO);
}
