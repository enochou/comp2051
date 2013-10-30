package com.homework;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
  
    private final static String DB_URL = "jdbc:oracle:thin:@192.168.169.10:1523:orcl";
    

    private final static String DB_DRIVER = "oracle.jdbc.OracleDriver";
    
   
    private final static String DB_USERNAME = "hr";
    

    private final static String DB_PASSWORD = "hr";
    
   
    public Connection getConnection(){
       
        Connection conn = null;
        try{
            
            Class.forName(DB_DRIVER);
         //  System.out.println("get Connection begin");
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch(Exception ex){
        //	System.out.println("get Connect Catch");
            ex.printStackTrace();
        }
        return conn;
    }
    
    
    public void closeConnection(Connection conn){
        try{
            if(conn!=null){
               
                if(!conn.isClosed()){
                    conn.close();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}