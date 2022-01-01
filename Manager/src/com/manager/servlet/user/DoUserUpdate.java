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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoUserUpdate() {
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
				//_tmp表示需要类型转化
				String username=request.getParameter("username");
				String isAdmin_tmp=request.getParameter("isAdmin");
				int isAdmin=0;
				try {

				    isAdmin = Integer.valueOf(isAdmin_tmp).intValue();

				} catch (NumberFormatException e) {
					//非数字错误
				    e.printStackTrace();

				}
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String IDcard=request.getParameter("id");
				String age_tmp=request.getParameter("age");
				int age=0;
				try {

				    age = Integer.valueOf(age_tmp).intValue();

				} catch (NumberFormatException e) {
					//非数字错误
				    e.printStackTrace();

				}
				//创建对象
				User u=new User(username,password,isAdmin,name,0,0,IDcard,age);
				//加入数据库
				
				int count=Userdao.update(u);
				
				
				
				
				//成功或失败反馈
				
				if(count>0) {
					response.sendRedirect("/Manager/admin_douserselect?cp="+request.getParameter("npage"));
					
				}else {
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('用户添加失败')");
					out.write("location.href='Manager/admin_touserupdate?username='"+username+"'");
					out.write("</script>");
				}
			}
	}


