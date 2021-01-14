package com.student.dynamic;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.pentagon.StudentDAO.StudentDAO;
import com.pentagon.StudentDAO.StudentDAOImp;
import com.pentagon.StudentDTO.Student;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Retrieve the current session (don’t create a new one)
        HttpSession session = request.getSession(false);

        // If no session or not logged in, redirect to login page
        if (session == null || session.getAttribute("student") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get logged-in student from session
        Student student = (Student) session.getAttribute("student");

        // Optional: fetch latest student info from DB
        StudentDAO dao = new StudentDAOImp();
        Student updatedStudent = dao.getStudent(student.getEmail(),student.getPassword());

        // Update session and forward student info to JSP
        session.setAttribute("student", updatedStudent);
        request.setAttribute("student", updatedStudent);

        // Forward to dashboard.jsp
        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }

    // Support POST requests as well (redirect to doGet)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


