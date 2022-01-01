package com.manager.entity;

public class User {
	private String username; // 用户名
	private String password; // 密码
	private int isAdmin; // 是否为管理员（1是，0不是）
	//int familyID; // 家庭组ID
	//int userID=0; // 用户ID
	private String name; // 用户姓名
	//String called; // 家庭称谓
	private float income; // 总收入
	
	private float expense; // 支出
	private float net_income;//净收入
	//private float salary; // 薪水
	//float balance; // 余额
	private String id; // 身份证
	private int age;//年龄(加到数据库)
	//Date birthday; // 出生日期
	//SecurityAccount sa; // 证券账户
	public User() {
		
	}
	public User(String username, String password, int isAdmin, String name,  float salary,float expense,String iDCard,int age) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.name = name;
		this.income = salary;
		this.expense = expense;
		this.net_income=salary-expense;
		
		this.id = iDCard;
		this.age=age;
	}
	
	public User(String username, String password, int isAdmin, String name,  float salary,float expense,float net_income,String iDCard,int age) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.name = name;
		this.income = salary;
		this.expense = expense;
		this.net_income=net_income;
		
		this.id = iDCard;
		this.age=age;
	}
	public float getNet_income() {
		return net_income;
	}
	public void setNet_income(float net_income) {
		this.net_income = net_income;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public float getExpense() {
		return expense;
	}
	public void setExpense(float expense) {
		this.expense = expense;
	}
/*	public String getIDCard() {
		return id;
	}
	public void setIDCard(String iDCard) {
		id = iDCard;
	}*/
	public int getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
