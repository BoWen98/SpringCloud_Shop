<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>蚂蚁商城-注册</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/layui/css/layui.css">
<link rel="stylesheet" href="/css/register.css">
</head>
<body>

	<div class="house-header">
		<div class="layui-container">
			<div class="house-nav">
				<span class="layui-breadcrumb" lay-separator="|"> <a
					href="login" style="color: #f10a0a!important;">登录</a> <a href="">我的订单</a> <a href="http://wpa.qq.com/msgrd?v=3&uin=483966038&site=qq&menu=yes">在线客服</a>
				</span> <span class="layui-breadcrumb house-breadcrumb-icon"
					lay-separator=" "> <a id="search"><i
						class="layui-icon layui-icon-house-find"></i></a> <a href="login"><i
						class="layui-icon layui-icon-username"></i></a> <a
					href="usershop.html"><i
						class="layui-icon layui-icon-house-shop"></i></a>
				</span>
			</div>
			<div class="house-banner layui-form">
				<a class="banner" href="index"> <img
					src="http://static.itmayiedu.com/12312312312312da.png" alt="家居商城">
				</a>
				<div class="layui-input-inline">
					<input type="text" placeholder="搜索好物" class="layui-input"><i
						class="layui-icon layui-icon-house-find"></i>
				</div>
				<a class="shop" href="usershop"><i
					class="layui-icon layui-icon-house-shop"></i><span
					class="layui-badge">1</span></a>
			</div>
			<ul class="layui-nav close">
				<li class="layui-nav-item layui-this"><a href="index">首页</a></li>
				<li class="layui-nav-item"><a href="list">居家用品</a></li>
				<li class="layui-nav-item"><a href="list">小家电</a></li>
				<li class="layui-nav-item"><a href="list">洗护</a></li>
				<li class="layui-nav-item"><a href="list">厨具</a></li>
				<li class="layui-nav-item"><a href="list">日用品</a></li>
			</ul>
			<button id="switch">
				<span></span><span class="second"></span><span class="third"></span>
			</button>
		</div>
	</div>

	<div class="layui-fulid" id="house-login">
		<div class="layui-form">
			<p>手机号登录</p>
			<div class="layui-input-block login" >
				<i class="layui-icon layui-icon-username"></i> <input type="text"
					required lay-verify="required" placeholder="请输入手机号码"
					class="layui-input">
			</div>

			<div class="layui-input-block login" style="margin-top: 12px;">
				<i class="layui-icon layui-icon-vercode"></i> <input type="text"
					required lay-verify="required" placeholder="请输入密码"
					class="layui-input">
			</div>


			<div class="layui-input-block-weixinQRcode" style="text-align: center;">
				<img alt="" src="http://static.itmayiedu.com/1513928038043.jpg">

				<div style="text-align: center; font-size: 14px; color: #FF5722;">
					关注微信公众号,发送手机号码可获得注册码</div>
			</div>
			
			
				<div class="layui-input-block login" style="margin-top: 12px;">
				<i class="layui-icon layui-icon-vercode"></i> <input type="text"
					required lay-verify="required" placeholder="请输入微信注册码"
					class="layui-input">
			</div>


			<div class="layui-input-block getCode" style="margin-top: 12px;">
				<input type="text" required lay-verify="required"
					placeholder="请输入验证码" class="layui-input">
				<button class="layui-btn">获取验证码</button>
			</div>
			<button class="layui-btn" lay-submit lay-filter="user-login" >注册</button>
		</div>
	</div>

	<div class="house-footer">
		<div class="layui-container">
			<div class="intro">
				<span class="first"><i
					class="layui-icon layui-icon-house-shield"></i>7天无理由退换货</span> <span
					class="second"><i class="layui-icon layui-icon-house-car"></i>满99元全场包邮</span>
				<span class="third"><i
					class="layui-icon layui-icon-house-diamond"></i>100%品质保证</span> <span
					class="last"><i class="layui-icon layui-icon-house-tel"></i>客服400-2888-966</span>
			</div>
			<div class="about">
				<span class="layui-breadcrumb" lay-separator="|"> <a
					href="about.html">关于我们</a> <a href="about.html">帮助中心</a> <a
					href="about.html">售后服务</a> <a href="about.html">配送服务</a> <a
					href="about.html">关于货源</a>
				</span>
				<p>家居商城版权所有 &copy; 2012-2020</p>
			</div>
		</div>
	</div>

	<script src="/layui/layui.js"></script>
	<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
	<!--[if lt IE 9]>
  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
	<script>
		layui.config({
			base : '/js/'
		}).use('house');
	</script>

</body>
</html>