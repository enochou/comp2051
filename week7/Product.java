package com.homework;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

public class Product extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

ProductData Product;
Integer done =0;;
DatabaseOp Dataimp = new DatabaseImp();
System.out.print(request);
System.out.flush();
BufferedReader buff = request.getReader();

String JString= getBodyString(buff);
System.out.println("aaaaaaaaaaaaaaaa" +JString);
Product = new ProductData();
try {
	JsonHelper.toJavaBean(Product,JString);
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//     User = new UserData();
 
// System.out.println("user pass " +User.Password);
// System.out.println("Name" + User.Name);
 done = Dataimp.findProduct(Product);
   
     String responseString=JsonHelper.toJSON(Product).toString() ;
//  Map user = request.getParameterMap();
PrintWriter out = response.getWriter();
out.println(responseString);
out.flush();
out.close();
}

public static String getBodyString(BufferedReader br) {
  String inputLine;
       String str = "";
     try {
       while ((inputLine = br.readLine()) != null) {
        str += inputLine;
       }
       br.close();
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
     return str;
 }

}