package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.CookieUtility;
import com.servlet.LivedCookie;

/**
 * Servlet implementation class UserPage
 */
@WebServlet("/index")
public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countString =
			      CookieUtility.getCookieValue(request,
			                                     "accessCount",
			                                     "1");
			    int count = 0;
			    try {
			      count = Integer.parseInt(countString);
			    } catch(NumberFormatException nfe) { }
			    LivedCookie c =
			      new LivedCookie("accessCount",
			                          String.valueOf(count+1));
			    response.addCookie(c);
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String title = "Yönlendirme";
		    String docType =
		      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		      "Transitional//EN\">\n";
		    out.println(docType +
		                "<HTML>\n" +
		                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
		                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		                "<CENTER>\n" +
		                "<H1>" + title + "</H1>\n" +
		                "<H2>Yönlendirme tamamlandi " +
		                "<H1>" + count + "</H1>\n" +
		               
		                "</CENTER></BODY></HTML>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
