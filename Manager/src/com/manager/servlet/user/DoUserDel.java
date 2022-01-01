package com.manager.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Userdao;
import com.manager.entity.User;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/admin_douserdel")
public class DoUserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				//_tmp表示需要类型转化
				String username=request.getParameter("username");
				
				
				//加入数据库
				
				int count=Userdao.del(username);
				
				
				
				
				//成功或失败反馈
				
				if(count>0) {
					response.sendRedirect("/Manager/admin_douserselect?cp="+request.getParameter("cp"));
					
				}else {
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('用户删除失败')");
					out.write("location.href='Manager/admin_douserselect?cp="+request.getParameter("cp")+"'");
					out.write("</script>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String []usernames=request.getParameterValues("username[]");
		
		for(int i=0;i<usernames.length;i++) {
			Userdao.del(usernames[i]);
		}
		//加入数据库
		
		
		
		
		
		
		//成功或失败反馈
		
		
		response.sendRedirect("/Manager/admin_douserselect");
			
		
	}

}
