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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">数据库信息管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/Manager/admin_dofileselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <td><input class="btn btn-primary btn2" name="sub" value="刷新" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="search-wrap">
                <form action="/Manager/admin_dofilebackup" method="post">
                    <table class="search-tab">
                        <tr>
                            <td><input class="btn btn-primary btn2" name="sub" value="备份" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
               
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th>以往存储记录</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="f" items="${filelist}">
                        <tr>
                        	
                           	<td>${f}</td>
                            <td>
                                <a class="link-update" href="admin_dofilerestore?filename=${f}">恢复</a>
                                
                            
                            
                            
                            </td>
                        </tr>
                        </c:forEach>
                        
                        
                       
                    </table>
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