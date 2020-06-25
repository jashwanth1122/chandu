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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("business");  
		String p=request.getParameter("no Employes");  
		String e=request.getParameter("Year of Commencement");  
		String c=request.getParameter("type");  
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=(Connection) DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/mydb","root","");  
		  
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(  
		"insert into market values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		          
		int i=ps.executeUpdate();  
		if(i>0)  
			System.out.println("GEtting to next page ......");
		RequestDispatcher rd=request.getRequestDispatcher("/page4.html");  
	     rd.include(request, response);  
		      
		          
		}catch (Exception e2) {System.out.println(e2);
		}  
		out.close(); 
		
		 
		}  
	 
		  


	}


