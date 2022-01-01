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
 * Servlet implementation class DoUserUpdate
 */
@WebServlet("/admin_doreportupdate")
public class DoReportUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoReportUpdate() {
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
				int id=Integer.parseInt(request.getParameter("id"));
				String username=request.getParameter("username");
				String type=request.getParameter("type");
				String name=request.getParameter("name");
				float value=Float.parseFloat(request.getParameter("id"));
				String day=request.getParameter("day");
				String message=request.getParameter("message");
				
				//创建对象
				Report r = new Report();
				
				r.setId(id);
				r.setUsername(username);
				r.setType(type);
				r.setName(name);
				r.setValue(value);
				r.setDay(day);
				r.setMessage(message);
				//加入数据库
				
				int count=Reportdao.update(r);
				
				
				
				
				//成功或失败反馈
				
				if(count>0) {
					response.sendRedirect("/Manager/admin_doreportselect?cp="+request.getParameter("npage"));
					
				}else {
					PrintWriter out=response.getWriter();
					out.write("<script>");
					out.write("alert('收支更新失败')");
					out.write("location.href='Manager/admin_toreportupdate?id='"+id+"'");
					out.write("</script>");
				}
			}
	}


