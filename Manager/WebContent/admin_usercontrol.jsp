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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户信息管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/Manager/admin_douserselect" method="get">
                    <table class="search-tab">
                        <tr>
                           
                            <th width="140">输入名字:</th>
                           <!--  <td><input   hidden name="npage" value="${npage }"></td>   -->
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/Manager/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    	<input   hidden name="npage" value="${npage }">
                        <a href="useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:delselect('你确定删除这些用户吗？','myform')"><i class="icon-font"></i>批量删除</a>
                        <!-- <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                           <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>账号</th>
                            <th>密码</th>
                            <th>身份</th>
                            <th>姓名</th>
                            <th>收入</th>
                            <th>开销</th>
                            <th>净收入</th>
                            <th>身份证</th>
                            <th>年龄</th>
                            <th>编辑</th>
                        </tr>
                        
                        <c:forEach var="u" items="${userlist}">
                        <tr>
                        	<c:if test="${u.isAdmin==0 }">
                        	<td class="tc"><input name="username[]" value="${u.username}" type="checkbox"></td>
                        	</c:if>
                        	
                        	<c:if test="${u.isAdmin==1 }">
                        	<td class="tc"></td>
                        	</c:if>
                        	
                            <td>${u.username }</td>
                            <td>${u.password }</td>
                            <td>
                            <c:if test="${u.isAdmin==1 }">
                           		 管理员
                            </c:if>
                            <c:if test="${u.isAdmin==0 }">
                           		 普通用户
                            </c:if>
                           </td>
                            <td>${u.name }</td>
                            <td>${u.income }</td>
                            <td>${u.expense }</td>
                            <td>${u.net_income }</td>
                           	<td>${u.id }</td>
                           	<td>${u.age }</td>
                            <td>
                                <a class="link-update" href="admin_touserupdate?username=${u.username }&cp=${npage}">修改</a>
                                
                                <c:if test="${ u.isAdmin==0 }">
                                <a class="link-del" href="javascript:Delete('你确定删除用户[${ u.username}]吗','/Manager/admin_douserdel?username=${u.username }&cp=${npage }')">删除</a>
                                </c:if>
                                <c:if test="${ u.isAdmin==1 }">
                                <a class="link-del" href="#"></a>
                                </c:if>
                            
                            
                            
                            </td>
                        </tr>
                        </c:forEach>
                        
                        <script>
                        	function Delete(mess,url){
                        		if(confirm(mess)){
                        			location.href=url;
                        			
                        		}
                        	}
                        	
                        	
                        	function selectall( o){
                        		
                        		var a=document.getElementsByName('username[]');
                        		
                        		for(var i=0;i<a.length;i++){
                        			
                        			a[i].checked =o.checked;
                        		}
                        	}
                        	
                        	function delselect(mess,formname){
                        		if(confirm(mess)){
                        			var form=document.getElementById(formname);
                        			
                        			form.submit();
                        		}
                        		
                        	}
                        </script>
                       
                    </table>
                    <div  class=list-page>
                    	共${tsum}条记录,当前${npage }/${tpage }页
                    <a   href="admin_douserselect?cp=1${searchParams} ">首页</a>
                    <a   href="admin_douserselect?cp=${npage-1<=0 ?1:npage-1 }${searchParams}">上一页</a>
                    <a   href="admin_douserselect?cp=${npage+1>tpage ? tpage:npage+1 }${searchParams}">下一页</a>
                    <a   href="admin_douserselect?cp=${tpage }">尾页</a>
                    	
                    </div>
                </div>
            </form>
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
