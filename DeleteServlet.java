package com.sazzad.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1 align='center'>Delete Servlet</h1>");
		
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String sqlUrl = "jdbc:mysql://localhost:3306/sazzaddb";
		String sqlUsername = "root";
		String sqlPassword = "root";
		String sqlStatement = "delete from employee where emp_no=?";
		
		Integer id = Integer.parseInt(req.getParameter("empId"));
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(sqlUrl,sqlUsername,sqlPassword);
			PreparedStatement pst = con.prepareStatement(sqlStatement);
			pst.setInt(1, id);
			int x =pst.executeUpdate();
			
			if(x!=0)
				 out.println("<h1>Data Deleted</h1>");
		} catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}
		
		
	}
}
