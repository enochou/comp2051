package com.homework;

import java.sql.Connection;


public class DBFactory {
    
   
    private DBConnection dbConn = new DBConnection();
    
   
    public DBConnection getDBConnectionInstance(){
        
        if(dbConn==null){
            dbConn = new DBConnection();
      //      System.out.println("Instande = null");
            return dbConn;
        }
       
        else{
       // 	System.out.println("Instande has benn isntantiated");
            return dbConn;
        }
    }
    
    
    public void closeConnection(Connection conn){
       
        if(dbConn==null){
            dbConn = new DBConnection();
        }
        dbConn.closeConnection(conn);
    }
    
}