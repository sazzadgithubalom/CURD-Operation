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

public class UpdateServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1 align='center'>Update Servlet</h1>");
		
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String sqlUrl = "jdbc:mysql://localhost:3306/sazzaddb";
		String sqlUsername = "root";
		String sqlPassword = "root";
		String sqlStatement = "update employee set emp_name=?, emp_sal=? where emp_no=?";
		
		Integer id = Integer.parseInt(req.getParameter("empId"));
		String name = req.getParameter("empName");
		Float sal = Float.parseFloat(req.getParameter("empSal"));
		
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(sqlUrl,sqlUsername,sqlPassword);
			PreparedStatement pst = con.prepareStatement(sqlStatement);
			pst.setString(1, name);
			pst.setFloat(2, sal);
			pst.setInt(3, id);
			int x =pst.executeUpdate();
			
			if(x!=0)
				 out.println("<h1>Data Updated</h1>");
		} catch (ClassNotFoundException e) {
			
		}catch (SQLException e) {
			
		}
		
		
	}
}
