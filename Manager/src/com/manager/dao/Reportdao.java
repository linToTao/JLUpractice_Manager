package com.manager.dao;
import java.sql.*;
import java.util.ArrayList;

import com.manager.entity.Report;

public class Reportdao {
	//插入
	public static int insert(Report r) {
		String sql ="insert into report value(?,?,?,?,?,?,?) ";
		
		Object[] params= {
				
				r.getId(),
				r.getUsername(),
				r.getType(),
				r.getName(),
				r.getValue(),
				r.getDay(),
				r.getMessage()
				
		};
		return Basedao.exectuIDU(sql, params);
	}
	public static int del(int id) {
		
		String sql="delete from report where id=?";
		
		Object[] params = { id };
		
		return Basedao.exectuIDU(sql, params);
		
	}
	public static int update(Report r) {
		String sql ="update Report set username=?,type=?,name=?,value=?,day=?,message=?  where id=? ";
		
		Object[] params= {
				
				
				r.getUsername(),
				r.getType(),
				r.getName(),
				r.getValue(),
				r.getDay(),
				r.getMessage(),
				r.getId()
				
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
				sql =" select count(*)from report where name like ?";
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, "%"+keyword+"%");
			}else {
				sql =" select count(*)from report";
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
	public static ArrayList<Report> selectAll(int npage,int count,String keyword){
		ArrayList<Report> list =new ArrayList<Report>();
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		try {
			String sql="";
			if(keyword!=null) {
				sql ="select *from report where name like ? order by id limit ?, ?";
				//直接使用like '%"+keyword+"%' 很不安全安全
				ps=conn.prepareStatement(sql);
				
				ps.setInt(2, count*(npage-1));
				ps.setInt(3, count);
				ps.setString(1, "%"+keyword+"%");
			}else {
				
				sql ="select *from report order by id limit ?, ?";
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, count*(npage-1));
				ps.setInt(2, count);
				
			}
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Report r=new Report();
				
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setType(rs.getString("type"));
				r.setName(rs.getString("name"));
				r.setValue(rs.getFloat("value"));
				r.setDay(rs.getString("day"));
				r.setMessage(rs.getString("message"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}
	
	
	
	public static ArrayList<Report> selectByUsername(String username){
		ArrayList<Report> list =new ArrayList<Report>();
		
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select * from report where username=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Report r = new Report();
				
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setType(rs.getString("type"));
				r.setName(rs.getString("name"));
				r.setValue(rs.getFloat("value"));
				r.setDay(rs.getString("day"));
				r.setMessage(rs.getString("message"));
				

				list.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return list;
	}
	
	
	public static int selectMaxId() {
		int maxId=1;
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		try {
			String sql="";
			sql ="select *from report";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				if(id>maxId) {
					maxId=id;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return maxId;
	}
	public static Report selectById(int id) {
		// TODO Auto-generated method stub
		
		Report r =new Report();
		
		//声明结果集
		ResultSet rs =null;
		//获取连接对象
		Connection conn=Basedao.getconn();
		
		PreparedStatement ps =null;
		
		
		
		try {
			
			String sql="select * from report where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setType(rs.getString("type"));
				r.setName(rs.getString("name"));
				r.setValue(rs.getFloat("value"));
				r.setDay(rs.getString("day"));
				r.setMessage(rs.getString("message"));
				

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		
		return r;
	}
	
	
	
	
	
	
}
