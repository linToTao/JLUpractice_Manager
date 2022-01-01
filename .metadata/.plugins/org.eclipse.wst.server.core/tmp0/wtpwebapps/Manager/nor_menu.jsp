<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8"/>
    <title>家庭理财管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">首页</a></li>
                
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <!-- <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li> -->
                <li><span >用户【 ${name.name} 】    您好!</span></li> 
                <li></li>
                <li></li>
                
                <li><a href="/Manager/logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font"></i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="admin_info.jsp"><i class="icon-font"></i>个人信息管理</a></li>
                        
                        <li><a href="problem.jsp"><i class="icon-font"></i>用户报表管理</a></li>
                        
                        <li><a href="/Manager/admin_doreportselect?cp=1"><i class="icon-font"></i>收支信息管理</a></li>
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>