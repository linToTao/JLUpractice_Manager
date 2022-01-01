package com.manager.servlet.report;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Reportdao;
import com.manager.entity.Report;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/admin_doreportselect")
public class DoReportSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoReportSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int npage=1;//当前页
		int count=8;//每页条数
		
		//获取用户指定页面
		String cp=request.getParameter("cp");
		
		
		//接收用户关键字
		String keyword =request.getParameter("keywords");
		
		
		if(cp!=null) {
			npage=Integer.parseInt(cp);
		}
		
		int  arr[]=Reportdao.totalpage(count,keyword);
		
		
		
		
		//获取所有用户记录
		ArrayList<Report>list =Reportdao.selectAll(npage,count,keyword);
		
		//ArrayList<User>list =Userdao.selectAll();
		
		
		//放入请求对象
		request.setAttribute("tsum", arr[0]);//总记录数
		request.setAttribute("tpage", arr[1]);//总页数
		request.setAttribute("npage", npage);//当前页面
		
		request.setAttribute("reportlist", list);
		
		
		if(keyword!=null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
			
		}
		
		//重定向
		request.getRequestDispatcher("admin_reportcontrol.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
