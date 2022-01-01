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
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">收支信息管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/Manager/admin_doreportselect" method="get">
                    <table class="search-tab">
                        <tr>
                           
                            <th width="140">输入in/out:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords }" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/Manager/admin_doreportdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                    	<input   hidden name="npage" value="${npage }">
                        <a href="reportadd.jsp"><i class="icon-font"></i>新增收支记录</a>
                        <a id="batchDel" href="javascript:delselect('你确定删除这些收支记录吗？','myform')"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                           <th class="tc" width="5%"><input class="allChoose" name="" onclick="selectall(this)" type="checkbox"></th>
                            <th>流水号</th>
                            <th>用户</th>
                            <th>用途</th>
                            <th>种类</th>
                            <th>金额</th>
                            <th>日期</th>
                            <th>备注</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="r" items="${reportlist}">
                        <tr>
                        	<td class="tc"><input name="username[]" value="${u.username}" type="checkbox"></td>
                        	<td>${r.id }</td>
                            <td>${r.username }</td>
                            <td>${r.type }</td>
                            <td>${r.name }</td>
                            <td>${r.value }</td>
                            <td>${r.day }</td>
                           	<td>${r.message }</td>
                            <td>
                                <a class="link-update" href="admin_toreportupdate?id=${r.id }&cp=${npage}">修改</a>
                                
                                <a class="link-del" href="javascript:Delete('你确定删除记录[${ r.id}]吗','/Manager/admin_doreportdel?id=${r.id }&cp=${npage }')">删除</a>
                                
                            
                            
                            
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
                        		
                        		var a=document.getElementsByName('id[]');
                        		
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