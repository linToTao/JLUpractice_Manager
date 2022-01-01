package com.manager.servlet.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Reportdao;
import com.manager.dao.Userdao;
import com.manager.entity.Report;
import com.manager.entity.User;

/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/admin_doreportadd")
public class DoReportAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoReportAdd() {
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
		String type=request.getParameter("type");
		String name=request.getParameter("name");
		String value_tmp=request.getParameter("value");
		String day=request.getParameter("day");
		String message=request.getParameter("message");
		int id=Reportdao.selectMaxId()+1;
		float value=0;
		try {

			value = Float.parseFloat(value_tmp);

		} catch (NumberFormatException e) {
			//非数字错误
		    e.printStackTrace();
		}
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

		int count=0;
		User u = Userdao.selectByUsername(r.getUsername());
		if(u!=null) {
			if(r.getName().equalsIgnoreCase("收入")) {
				u.setNet_income(u.getNet_income()+r.getValue());
				Userdao.update(u);
				count=Reportdao.insert(r);
			}else if(r.getName().equalsIgnoreCase("支出")) {
				if(u.getNet_income()-r.getValue()>0) {
					u.setNet_income(u.getNet_income()-r.getValue());
					Userdao.update(u);
					count=Reportdao.insert(r);
				}
			}
		}
		

		
		
		//成功或失败反馈
		
		if(count>0) {
			response.sendRedirect("/Manager/admin_doreportselect");
			
		}else {
			response.sendRedirect("/Manager/admin_doreportselect");
		}
	}
	
	
	

}
