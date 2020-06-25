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
 * Servlet implementation class ComServlet
 */
public class ComServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("name");  
		String p=request.getParameter("componey");  
		String e=request.getParameter("city");  
		String c=request.getParameter("desig");  
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","");  
		  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
		"insert into markett values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			System.out.println("Getting to next.....");
		RequestDispatcher rd=request.getRequestDispatcher("/page3.html");  
	     rd.include(request, response);    
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		
		}  
		  

	

}
