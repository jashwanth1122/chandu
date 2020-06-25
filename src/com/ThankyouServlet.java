package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ThankyouServlet
 */
public class ThankyouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThankyouServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("year");  
		String p=request.getParameter("month");  
		String e=request.getParameter("day");  
		String c=request.getParameter("am/pm");  
		String d=request.getParameter("time");  
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","");  
		  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
		"insert into appoinment values(?,?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);
		ps.setString(5,d);
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			
			out.println("Appointment Submited thankyou we will contact as soon as possible");
		      
		          
		}catch (Exception e2) {System.out.println(e2);
		}  
		out.close(); 
		
		 
		}  
	}


