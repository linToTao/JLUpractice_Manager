package com.manager.servlet.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Reportdao;
import com.manager.entity.Report;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/admin_doreportdel")
public class DoReportDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoReportDel() {
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
				String id_tmp=request.getParameter("id");
				
				int id = Integer.parseInt(id_tmp);
				
				//加入数据库
				
				int count=Reportdao.del(id);
				
				
				
				
				//成功或失败反馈
				
				if(count>0) {
					response.sendRedirect("/Manager/admin_doreportselect?cp="+request.getParameter("cp"));
					
				}else {
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('收支删除失败')");
					out.write("location.href='Manager/admin_doreportselect?cp="+request.getParameter("cp")+"'");
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
		
		String []id=request.getParameterValues("username[]");
		
		for(int i=0;i<id.length;i++) {
			Reportdao.del(Integer.parseInt(id[i]));
		}
		//加入数据库
		
		
		
		
		
		
		//成功或失败反馈
		
		
		response.sendRedirect("/Manager/admin_doreportselect");
			
		
	}

}
