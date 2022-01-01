package com.manager.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.dao.Userdao;
import com.manager.entity.User;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=utf-8");
				
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				int count=Userdao.selectByNM(username,password);
				
				if(count>0) {
					HttpSession session=request.getSession();
					User user=Userdao.selectAdmin(username,password);
					session.setAttribute("name", user);
					session.setAttribute("isLogin", "1");
					if(user.getIsAdmin()==1) {
						
						
						session.setAttribute("isAdminLogin", "1");
					
						
					}
					response.sendRedirect("admin_index.jsp");
					
				}else {
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('用户登录失败');");
					out.write("location.href='admin_login.jsp';");
					out.write("</script>");
				}
	}

}
