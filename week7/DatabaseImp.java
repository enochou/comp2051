package com.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseImp implements DatabaseOp  {
	    
	public Integer findProduct(ProductData Product){
		Connection con = null;
		PreparedStatement pre = null;
	    ResultSet result = null;
	    Integer res = 0;
		try {
			DBFactory db = new DBFactory();
		   if (db == null ){
			   System.out.println("Dbfactory was null");
		   }
	    	con = db.getDBConnectionInstance().getConnection();
	    	
	    	if (con == null) 
	    	{
	    		System.out.println("Database wasnot  open");
	    	}
	    	System.out.println("Database was open");
	    	String sql = "select * from product where trim(id)=?";
	  
	    //	System.out.println(sql);
	    	pre = con.prepareStatement(sql);
	    	String ProductId = Product.getId();
	    	
	    
	    	pre.setString(1, ProductId);
	    	
	    	result = pre.executeQuery();
	    	if ( result.next() ) {
	    		Product.setId(result.getString("id"));
	    		Product.setTitle(result.getString("title"));
	    		Product.setArtist(result.getString("artist"));
	    		Product.setPrice(result.getLong("price"));
	    		res = 1;
	    	} else 
	    		res = 0;
	    	
	    } catch (Exception e)
	    {
	    	e.printStackTrace();
	    	res = -1;
	    }
	    finally {
	    	try {
	    		if (result != null) 
	    			result.close();
	    		if (pre != null)
	    			pre.close();
	    		if (con != null)
	    			con.close();   		
	    		System.out.println("Database was closed");
	    	 
	    	} catch (Exception e) 
	    	{   
	    		e.printStackTrace();
	    	}
	    	
	    }
	    System.out.println("return point");
	    System.out.println(res);
		return res;
	    
	}

	

}
