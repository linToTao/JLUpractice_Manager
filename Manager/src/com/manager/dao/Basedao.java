package com.manager.dao;
import java.sql.*;
public class Basedao {
	static {
		//加载链接
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getconn() {//连接方法
		//创建连接对象
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ManagerDataBase?useSSL=false&serverTimezone=UTC","root","123123");
			//System.out.println("Connect 成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return conn;	
	}
	
	public static int exectuIDU(String sql,Object[]params) {//增删改 通用语句
		int count=0;
		
		
		Connection conn=Basedao.getconn();
		
		//sql语句
		PreparedStatement ps=null;
		
		
		
		try {
			ps=conn.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++) {
				ps.setObject(i+1,params[i]);
			}
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null,ps,conn);
		}
		
		
		return count;
	}
	
	
	
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {//断开连接
		
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
