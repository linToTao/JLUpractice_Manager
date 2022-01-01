package com.manager.servlet.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.entity.Recover;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/admin_dofileselect")
public class DoFileSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoFileSelect() {
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
		
		
		
		//接收用户关键字
//		String keyword =request.getParameter("keywords");
		
		
		
		
		//获取所有用户记录
		ArrayList<String>list = new ArrayList<String>(Arrays.asList(Recover.showAllFile()));
		
		//ArrayList<User>list =Userdao.selectAll();
		ArrayList<String>list1 = new ArrayList<String>();
		
		for(int i = list.size()-1;i>-1 && i >list.size()-11;i--) {
			list1.add(list.get(i));
		}
		
		request.setAttribute("filelist", list1);
		
		//重定向
		request.getRequestDispatcher("admin_filecontrol.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
