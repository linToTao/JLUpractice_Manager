<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
    <c:if test="${isLogin==1 }">
<c:if test="${name.isAdmin==1 }">
<%@ include file="admin_menu.jsp" %>
</c:if>
<c:if test="${name.isAdmin==0 }">
<%@ include file="nor_menu.jsp" %>
</c:if>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span>个人信息管理</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/Manager/admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120">用户类型：</th>
                            <td>${name.isAdmin==1? "管理员":"普通用户"}</td>
                        </tr>
                            <tr>
                                <th>用户名：</th>
                                <td>${name.username }</td>
                            </tr>
                            <tr>
                                <th>密码：</th>
                                <td>${name.password }</td>
                            </tr>
                            <tr>
                            	<th>姓名：</th>
                            	<td>${name.name }</td>
                            </tr>
                            <tr>
                            	<th>身份证：</th>
                            	<td>${name.id }</td>
                            </tr>
                            
                            
                            <tr>
                            	<th>年龄：</th>
                            	<td>${name.age }</td>
                            </tr>
                            <tr>
                            	<th>收入：</th>
                            	<td>${name.income }</td>
                            </tr>
                            <tr>
                            	<th>支出：</th>
                            	<td>${name.expense }</td>
                            </tr>
                            <tr>
                            	<th>净收入：</th>
                            	<td>${name.net_income }</td>
                            </tr>
                            
                            
                            
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>

</c:if>
<c:if test="${isLogin!=1 }">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	暂无用户信息,请先登录
</body>
</html>


</c:if>