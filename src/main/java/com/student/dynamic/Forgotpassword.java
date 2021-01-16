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

@WebServlet("/forgotpassword")
public class Forgotpassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = null;
		StudentDAO st=new StudentDAOImp();
		resp.setContentType("text/html"); 
		PrintWriter out=resp.getWriter();
		s=st.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			if(s.getPassword().equals(req.getParameter("password"))) {
				req.setAttribute("error","Password already used" );
				RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, resp);
				
				//out.println("<h1> Password already used</h1>");
			}		
			else {
				s.setPassword(req.getParameter("password"));
				if(st.updateStudent(s)) {
					// out.println("<h2>Password changed Successfully</h2>");
					
					req.setAttribute("success","Password changed Successfully" );
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				
				}
				else {
					// out.println("<h2>Something went wrong");
					req.setAttribute("error","Something went wrong" );
					RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
					rd.forward(req, resp);
				}
			}
		}
		else {
			// out.println("<h2>Password Mismatch</h2>");
			
			req.setAttribute("error","Password Mismatch" );
			RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(req, resp);
		}
	}
}
