package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("type");  
		String p=request.getParameter("action");  
		String e=request.getParameter("trand");  
		String c=request.getParameter("impact");  
		String d=request.getParameter("plan");  
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","");  
		  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
		"insert into pagethree values(?,?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		ps.setString(5,d);
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			System.out.println("Getting toword.....");
		RequestDispatcher rd=request.getRequestDispatcher("/thankyou.html");  
	     rd.include(request, response);  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		
		}  
	}

	


