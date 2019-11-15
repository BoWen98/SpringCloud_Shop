package com.bowen.shop.portal.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.bowen.shop.base.BaseResponse;
import com.bowen.shop.portal.web.constants.WebConstants;
import com.bowen.shop.portal.web.controller.vo.LoginVo;
import com.bowen.shop.web.core.bean.EntityBeanUtils;
import com.bowen.shop.constants.Constants;
import com.bowen.shop.input.UserLoginInpDTO;
import com.bowen.shop.portal.web.feign.MemberLoginServiceFeign;
import com.bowen.shop.web.core.base.BaseWebController;
import com.bowen.shop.web.core.utils.CookieUtils;
import com.bowen.shop.web.core.utils.RandomValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseWebController {
    /**
     * 跳转到登陆页面页面
     */
    private static final String MB_LOGIN_FTL = "member/login";
    @Autowired
    private MemberLoginServiceFeign memberLoginServiceFeign;
    /**
     * 重定向到首页
     */
    private static final String REDIRECT_INDEX = "redirect:/";

    /**
     * 跳转页面
     *
     * @return
     */
    @GetMapping("/login")
    public String getLogin() {
        return MB_LOGIN_FTL;
    }

    /**
     * 接受请求参数
     *
     * @return
     */
    @PostMapping("/login")
    public String postLogin(@ModelAttribute("loginVo") LoginVo loginVo, Model model, HttpServletRequest request,
                            HttpServletResponse response, HttpSession httpSession) {
        // 1.图形验证码判断
        String graphicCode = loginVo.getGraphicCode();
        if (!RandomValidateCodeUtil.checkVerify(graphicCode, httpSession)) {
            setErrorMsg(model, "图形验证码不正确!");
            return MB_LOGIN_FTL;
        }

        // 2.将vo转换dto调用会员登陆接口
        UserLoginInpDTO userLoginInpDTO = EntityBeanUtils.voToDto(loginVo, UserLoginInpDTO.class);
        userLoginInpDTO.setLoginType(Constants.MEMBER_LOGIN_TYPE_PC);
        String info = webBrowserInfo(request);
        userLoginInpDTO.setDeviceInfor(info);
        BaseResponse<JSONObject> login = memberLoginServiceFeign.login(userLoginInpDTO);
        if (!isSuccess(login)) {
            setErrorMsg(model, login.getMsg());
            return MB_LOGIN_FTL;
        }
        // 3.登陆成功之后如何处理 保持会话信息 将token存入到cookie 里面 首页读取cookietoken 查询用户信息返回到页面展示
        JSONObject data = login.getData();
        String token = data.getString("token");
        CookieUtils.setCookie(request, response, WebConstants.LOGIN_TOKEN_COOKIENAME, token);
        return REDIRECT_INDEX;
    }

}
