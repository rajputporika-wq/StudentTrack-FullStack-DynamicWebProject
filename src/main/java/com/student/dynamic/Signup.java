package com.student.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import com.pentagon.StudentDAO.StudentDAO;
import com.pentagon.StudentDAO.StudentDAOImp;
import com.pentagon.StudentDTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = new Student();
		StudentDAO st= new StudentDAOImp();
		
		PrintWriter out= resp.getWriter();
		
		//String name= req.getParameter("name");
		s.setName(req.getParameter("name"));
		
//		String ph=req.getParameter("phone");
//		long l =Long.parseLong(ph);
//		s.setPh(l);
		s.setPh(Long.parseLong(req.getParameter("phone")));
		
		s.setEmail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		String pass=req.getParameter("password");
		String confirm=req.getParameter("confirm");
		
		if(pass.equals(confirm)) {
			s.setPassword(pass);
			
			if(st.insertStudent(s)) { 
//				System.out.println("Data saved successfully");
//				out.println("<h1> Data saved successfully </h1>");
				
				req.setAttribute("success","Data saved successfully :) ");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req,resp);
			}
			else {
//				System.out.println("Data not yet saved");
//				out.println("<h2>Data not yet saved</h2>");
			
				req.setAttribute("error","Failed to Save :( ");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req,resp);
			}
		}
		else {
			req.setAttribute("error","Password mismatch :( ");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req,resp);
		}
		
	}	
}


  