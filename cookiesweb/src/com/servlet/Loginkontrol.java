package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.CookieUtility;







/**
 * Servlet implementation class Loginkontrol
 */
@WebServlet("/Loginkontrol")
public class Loginkontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			    
		
		boolean isMissingValue = false;
		
		
	    String username = request.getParameter("username");
		if (isMissing(username)){
			username="Missing username";
			isMissingValue = true;
		}
		String password = request.getParameter("password");
		if (isMissing(password)){
			username="Missing password";
			isMissingValue = true;
		}
		String  box = request.getParameter("box1");
		if (isMissing(box)){
			username="Missing checked";
			isMissingValue = true;
		}
//------------------------------------------	
		boolean newbie = true;
	    String value =
	      CookieUtility.getCookieValue(request, "username",
	                                     "");
	    String value1 =
	  	      CookieUtility.getCookieValue(request, "password",
	  	                                     "");
	    String title ;
	    if (value.equals(username) && value1.equals(password)) {
	      newbie = false;
	    }
//------------------------------------------
	    if (newbie) {
	    	Cookie c3 = new LivedCookie("username",username);
	        response.addCookie(c3);
	        Cookie c4 = new LivedCookie("password", password);
	        response.addCookie(c4);
	        title = "Welcome aboard";
	    }
	    else{
	    	title = "welcome back";
	    	
	    	}
	   
//-------------------------------------------	    
	    if (isMissingValue) {
	        response.sendRedirect("http://localhost:8080/cookiesweb/login.html");
	      }
	    
	    else {
	    	if (username.equals("Pass") && password.equals("1234")){
	    		Cookie c1 = new LivedCookie("username","Pass");
	            response.addCookie(c1);
	            Cookie c2 = new LivedCookie("password", "1234");
	            response.addCookie(c2);
	    		response.sendRedirect("http://localhost:8080/cookiesweb/index");
	    		}
	    	else{
	    		PrintWriter out = response.getWriter();
	    		response.setContentType("text/html");
	    		String docType =
	    				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	    						"Transitional//EN\">\n";
	        
	        
	    		out.println
	    		(docType +
	    				"<HTML>\n" +
	    				"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	    				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
	    				"<CENTER>\n" +
	    				"<H1 ALIGN>" + title + "</H1>\n" +
	    				"<UL>\n" +
	    				"  <LI><B>First Name</B>: " +
	    				username + "\n" +
	    				"  <LI><B>Last Name</B>: " +
	    				password + "\n" +
	    				
	                     "</UL>\n" +
	    				"</CENTER></BODY></HTML>");
	    	}
	    }
	}
	private boolean isMissing(String param){
		return ((param == null) ||(param.trim().equals("")) );
	}
	
	
	

}
