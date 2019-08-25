package com.oas.validations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registervalidation")
public class Registervalidation extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = null ;
		Date dateofbirth = null;
		String email = null;
		String phoneno = null;
		String username = null;
		String password1 = null;
		String password2 = null;
		int category = 0;
		
		
		if (request.getParameter("name") != null && request.getParameter("name").trim().length() > 0) {
			name = request.getParameter("name");
		}
		if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
			try {
				dateofbirth = (Date) new SimpleDateFormat("dd/MM/yyyy").parse( request.getParameter("dateofbirth"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		
		if(request.getParameter("email")!=null && request.getParameter("email").trim().length()>0) {
			email = request.getParameter("email");
			
		}
		if(request.getParameter("phoneno")!=null && request.getParameter("phoneno").trim().length()>0) {
			phoneno = request.getParameter("phoneno");
			
		}
		if(request.getParameter("username")!=null && request.getParameter("username").trim().length()>0) {
			username = request.getParameter("username");
			
		}
		if(request.getParameter("password1")!=null && request.getParameter("password1").trim().length()>0) {
			password1 = request.getParameter("password1");
			
		}
		if(request.getParameter("password2")!=null && request.getParameter("password2").trim().length()>0) {
			password2 = request.getParameter("password2");
			
		}
		if(request.getParameter("category")!=null && request.getParameter("category").trim().length()>0) {
			category = Integer.parseInt(request.getParameter("category")) ;
			
		}

		
		request.setAttribute("name", name);
		request.setAttribute("dateofbirth", dateofbirth);
		request.setAttribute("email", email);
		request.setAttribute("phoneno", phoneno);
		request.setAttribute("username", username);
		request.setAttribute("password1", password1);
		request.setAttribute("password2", password2);
		request.setAttribute("category", category);
		
		System.out.println("Forwarding from CalculatorController to View!!");
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}
