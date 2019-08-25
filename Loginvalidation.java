package com.oas.validations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Loginvalidation")
public class Loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String username = null ;
		String password = null ;
		
				
		if (request.getParameter("username") != null && request.getParameter("username").trim().length() > 0) {
			username = request.getParameter("username");
		}
		if (request.getParameter("password") != null && request.getParameter("password").trim().length() > 0) {
			password = request.getParameter("password");
			
		}
		
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		
		System.out.println("Forwarding from Loginvalidation to LoginDAO!!");
		request.getRequestDispatcher("").forward(request, response);
	}

}
