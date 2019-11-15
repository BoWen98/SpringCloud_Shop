<#include "../base/head.ftl"/>


<div class="layui-fulid" id="house-login">
    <form action="qqJointLogin" method="post">
        <div class="layui-form">
            <p>
                <img alt="" src="${avatarURL100}">
            </p>

            <span style="margin-left: 15px; color: #ff662f;"> 您正在使用
					QQ绑定蚂蚁课堂【已注册】账户</span>


            <div class="layui-input-block login" style="margin-top: 25px;">
                <i class="layui-icon layui-icon-username"></i> <input type="text"
                                                                      required lay-verify="required" name="mobile"
                                                                      value="${(loginVo.mobile)!''}"
                                                                      placeholder="请输入手机号码"
                                                                      class="layui-input">
            </div>

            <div class="layui-input-block login">
                <i class="layui-icon layui-icon-vercode"></i> <input
                        type="password" required lay-verify="required" name="password"
                        value="${(loginVo.password)!''}" placeholder="请输入密码"
                        class="layui-input">
            </div>


            <span
                    style="color: red; font-size: 20px; font-weight: bold; font-family: '楷体', '楷体_GB2312';">${error!''}</span>
            <button class="layui-btn" style="margin-top: 5px;" lay-submit
                    lay-filter="user-login">绑定
            </button>

            <span style="margin-left: 25%; padding-top: 30px;"> <a
                        href="register" style="color: #009100;"> 【未注册】蚂蚁课堂账户？</a></span>
        </div>
    </form>
</div>

<#include "../base/bottom.ftl"/>
<script src="/res/layui/layui.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script>
    layui.config({
        base: '/res/static/js/'
    }).use('house');

    function getVerify(obj) {
        obj.src = "getVerify?" + Math.random();
    }
</script>

</body>
</html>