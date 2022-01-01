package com.manager.servlet.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.entity.Recover;

@WebServlet("/admin_dofilerestore")
public class DoFileRestore extends HttpServlet {
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DoFileRestore() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Recover.Backup.Restore(request.getParameter("filename"));
//		System.out.println("DoFileBackup! "+System.getProperty("user.dir"));
		
		response.sendRedirect("/Manager/admin_dofileselect");
		
		
		
	}
}


