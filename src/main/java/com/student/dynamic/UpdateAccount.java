package com.student.dynamic;

import java.io.IOException;

import com.pentagon.StudentDAO.StudentDAO;
import com.pentagon.StudentDAO.StudentDAOImp;
import com.pentagon.StudentDTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateStudent")
public class UpdateAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    StudentDAO st = new StudentDAOImp();
	    HttpSession session = req.getSession(false);
	    Student s = (Student) session.getAttribute("student");
	    if (s != null) {
	        s.setName(req.getParameter("name"));
	        s.setPh(Long.parseLong(req.getParameter("phone")));
	        s.setEmail(req.getParameter("email"));
	        s.setBranch(req.getParameter("branch"));
	        s.setLoc(req.getParameter("loc"));
	        if (st.updateStudentD(s)) {
	            req.setAttribute("success", "Account update successfully");
	            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
	            rd.forward(req, resp);
	        } else {
	            req.setAttribute("fails", "Not yet updated");
	            RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
	            rd.forward(req, resp);
	        }
	    }
	}
}
