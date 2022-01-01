<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    
    
    
</head>
<body>
<div class="reg" >
    <form style="background:#F1F6FA;" action="/Manager/register" method="post"><h1><a href="index.html"></a></h1>
        <h1 style="padding:0px;margin:0px;font-size:30px;text-align:center;line-gight:60px ;color:#F1F6FA;background:#708090">用户注册</h1>
        <p>
                <input style="width: 15px; height:15px" type="radio" name="isAdmin"  value="0" checked="checked"> 普通用户    
                <input style="width: 15px; height:15px"  type="radio" name="isAdmin" value="1" > 管理员       
                            
        </p>
        <p ><input type="text" name="username" value="" placeholder="请输入用户名"><span ></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="name" value="" placeholder="请确认姓名"><span></span></p>
        <p><input type="text" name="id" value="" placeholder="请确认身份证"><span></span></p>
        <p><input type="text" name="age" value="" placeholder="请确认年龄"><span></span></p>
        
        
        <p><input type="submit" name="" value="注册"></p>
        <p >完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>