package com.manager.entity;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Recover {
    /** 访问MySQL数据库服务器所在的url */
     private String serverUrl;
     /** 访问MySQL数据库的用户名 */
     private String username;
     /** 访问MySQL数据库的密码 */
     private String password;
     
      
     public String getServerUrl() {
      return serverUrl;
     }
     
     public void setServerUrl(String serverUrl) {
      this.serverUrl = serverUrl;
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
     
     public Recover(String serverUrl,String username, String password) {
      super();
      this.serverUrl=serverUrl;
      this.username = username;
      this.password = password;
     }
     
     public String backup(String backupPath, String dbName) throws IOException {
     
      String backupFile = backupPath+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".sql";
     
      String mysql =backupPath+"mysqldump "+"--host="+serverUrl+" --user=" + username + " --password="+ password + " --opt " + dbName + "> "+backupFile ;
     
      System.out.println("备份"+mysql);
      java.lang.Runtime.getRuntime().exec("cmd /c " + mysql);
    

      System.out.println("备份成功!");
     
      return backupFile;
     
     }
     
     public void restore(String restoreFile, String dbName,String path) throws Exception {
      
      String mysql = path+"mysql "+"-h"+serverUrl+" -u" + username + " -p"+ password + " " + dbName + " < " + restoreFile;
       
//            System.out.println("+++++++++++++++++++++++++++\n"+mysql);
            
      java.lang.Runtime.getRuntime().exec("cmd /c " + mysql);
       
      System.out.println("还原成功!");
     }
     
     public static Recover Backup;
     static {
        String serverUrl="localhost";
       
        String userName = "root";
     
        String pwd = "123123";
        
      	Backup = new Recover(serverUrl,userName, pwd);
     }
     
     public static void Backup() {
    	 try {
			Backup.backup("", "managerdatabase");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public static void Restore(String fileName) {
    	 try {
			Backup.restore(fileName, "managerdatabase","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     public static String[] showAllFile() {
         /**
          * 将目标目录封装成 File 对象。
          */
         File dir = new File(System.getProperty("user.dir"));
//         System.out.println(System.getProperty("user.dir"));
         /**
          * 获取目录下的所有文件和文件夹
          */
         String[] names = dir.list(new FilterBySQL());
         
         return names;
     }
     
//     public static void main(String [] args) {
////    	 Backup();
//    	 Restore("2021-03-18-14-44-31.sql");
////    	 System.out.println(System.getProperty("user.dir"));
////    	 for(String x: showAllFile()) {
////    		 System.out.println(x);
////    	 }
//     }
  
}
class FilterBySQL implements FilenameFilter {
	 
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".sql");
    }
 
}