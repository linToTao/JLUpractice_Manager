package com.manager.dao;
import java.sql.*;
import java.util.ArrayList;

import com.manager.entity.User;

public class Userdao {
	//插入
	public static int insert(User u) {
		String sql ="insert into User value(?,?,?,?,?,?,?,?,?) ";
		
		Object[] params= {
				
				u.getUsername(),
				u.getPassword(),
				u.getIsAdmin(),
				u.getName(),
				u.getIncome(),
				u.getExpense(),
				u.getNet_income(),
				u.getId(),
				u.getAge()
				
		};
		return Basedao.exectuIDU(sql, params);
	}
	public static int del(String username) {
		
		String sql="delete from user where username=? and isAdmin!=1";
		
		Object[] params = { username };
		
		return Basedao.exectuIDU(sql, params);
		
	}
	public static int update(User u) {
		String sql ="update User set password=?,isAdmin=?,name=?,income=?,expense=?,net_income=?,id=?,age=?  where username=? ";
		
		Object[] params= {
				
				
				u.getPassword(),
				u.getIsAdmin(),
				u.getName(),
				u.getIncome(),
				u.getExpense(),
				u.getNet_income(),
				u.getId(),
				u.getAge(),
				u.getUsername()
				
		};
		return Basedao.exectuIDU(sql, params);
	}
	
	//获取总记录数和总页数   ,count为一页的记录数
	public static int[] totalpage(int count,String keyword) {
		int arr[]= {0,1};
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps =null;
		ResultSet rs=null;
		
		try {
			String sql ="";
			if(keyword!=null) {
				sql =" select count(*)from user where name like ?";
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, "%"+keyword+"%");
			}else {
				sql =" select count(*)from user";
				ps=conn.prepareStatement(sql);
				
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				
				arr[0]=rs.getInt(1);
				if(arr[0]%count==0) {
					arr[1]=arr[0]/count;
				}else {
					arr[1]=arr[0]/count+1;
				}
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
			
			
			
		}
		
		
		return arr;
		
		
		
	}
	public static ArrayList<User> selectAll(int npage,int count,String keyword){
		ArrayList<User> list =new ArrayList<User>();
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="";
			if(keyword!=null) {
				sql ="select *from User where name like ? order by age desc limit ?, ?";
				//直接使用like '%"+keyword+"%' 很不安全安全
				ps=conn.prepareStatement(sql);
				
				ps.setInt(2, count*(npage-1));
				ps.setInt(3, count);
				ps.setString(1, "%"+keyword+"%");
			}else {
				
				sql ="select *from User order by age desc limit ?, ?";
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, count*(npage-1));
				ps.setInt(2, count);
				
			}
			
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User u=new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("isAdmin"),
						rs.getString("name"),
						rs.getFloat("income"),
						rs.getFloat("expense"),
						rs.getFloat("net_income"),
						rs.getString("id"),
						rs.getInt("age")
						
						
						
						
						);
				
				
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}

	
	
/*  查询某一页记录
 * 
 * public static ArrayList<User> selectAll(int count,int npage){
		ArrayList<User> list =new ArrayList<User>();
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			String sql ="select *from User order by age desc limit ?, ?";
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, count*(npage-1));
			ps.setInt(2, count);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User u=new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("isAdmin"),
						rs.getString("name"),
						rs.getFloat("income"),
						rs.getFloat("expense"),
						rs.getFloat("net_income"),
						rs.getString("id"),
						rs.getInt("age")
						
						
						
						
						);
				
				
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}*/
	
/*	//查询全部用户信息
	public static ArrayList<User> selectAll(){
		ArrayList<User> list =new ArrayList<User>();
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			String sql ="select *from User order by age";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User u=new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("isAdmin"),
						rs.getString("name"),
						rs.getFloat("income"),
						rs.getFloat("expense"),
						rs.getFloat("net_income"),
						rs.getString("id"),
						rs.getInt("age")
						
						
						
						
						);
				
				
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}
	*/
	
	
	
	//查找到对应名字的个数
	public static int  selectByUnNum(String username){
		int count=0;
		return  count;
	}
	
	
	
	
	
	//通过usernmae查找
	
	public static User selectByUsername(String username){
		User u=null;
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select * from user where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("isAdmin"),
						rs.getString("name"),
						rs.getFloat("income"),
						rs.getFloat("expense"),
						rs.getFloat("net_income"),
						rs.getString("id"),
						rs.getInt("age")
						
						
						
						
						);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return u;
	}
	//个数
	public static int  selectByNM(String name ,String pwd) {
		
		int count=0;
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select count(*) from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
	}
	
	
	
/*public static int  selectByNM_admin(String name ,String pwd) {
		
		int count=0;
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select count(*) from user where username=? and password=? and isAdin=1?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				count=rs.getInt(1);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return count;
		
	}
	
	*/
	
	//通过用户名和密码查询用户
	public static User selectAdmin(String name,String pwd) {
		User u=null;
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select * from user where username=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				u=new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getInt("isAdmin"),
						rs.getString("name"),
						rs.getFloat("income"),
						rs.getFloat("expense"),
						rs.getFloat("net_income"),
						rs.getString("id"),
						rs.getInt("age")
						
						
						
						
						);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return u;
		
		
	}
	
	
	
	
	
	
}
