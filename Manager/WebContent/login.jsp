<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post"><h1><a href="index.html"></a></h1>
    <h1 style="padding:0px;margin:0px;font-size:30px;padding-left:120px;textline-gight:60px ;">普通用户登录</h1>
        <p></p>
        <div  class="msg-warn hide" style=" text-align: center;margin-left: 80px;" ><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p  style=" text-align: center"><input type="text" name="username" value="" placeholder="用户名"></p>
        <p  style=" text-align: center"><input type="text" name="password" value="" placeholder="密码"></p>
        <p  style=" text-align: center"><input type="submit" name="" value="登  录"></p>
        <p   style=" text-align: center">
        <a class="" href="reg.jsp">免费注册</a><!-- <a href="forget.html">忘记密码？</a> -->
        <a>           </a>
        <a style="padding-left:20px"  href="admin_login.jsp">管理员登录区</a>
        </p>
    </form>
</div>
</body>
</html>