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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/Manager/admin_doreportselect">收支信息管理</a><span class="crumb-step">&gt;</span><span>新增收支</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/Manager/admin_doreportadd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
	                        <tr>
	                            <th width="120"><i class="require-red">*</i>用户类型：</th>
	                            <td>
	                                <select name="name" id="catid" class="required">
	                                    
	                                    <option value="收入">收入</option><option value="支出">支出</option>
	                                </select>
	                            </td>
	                        </tr>
                            <tr>
                                <th>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="username" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>用途：</th>
                                <td><input class="common-text" name="type" size="50" value="" type="text"></td>
                            </tr>
                            <tr>
                            	<th>金额：</th>
                                <td><input class="common-text" name="value" size="50" value="" type="text"></td>    
                            </tr>
                            <tr>
                            	<th>日期：</th>
                                <td><input class="common-text date-picker" name="day" size="50" value="" type="text"></td>    
                            </tr>
                            
                            <tr>
                            	<th>备注：</th>
                                <td><input class="common-text" name="message" size="50" value="" type="text"></td>    
                            </tr>
                            
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
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
