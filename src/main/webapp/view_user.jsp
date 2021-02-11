<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.pentagon.StudentDTO.Student, com.pentagon.StudentDAO.StudentDAO, com.pentagon.StudentDAO.StudentDAOImp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body { font-family: Arial, sans-serif; background-color: #f8f9fa; }
        .navbar {
            background-color: #343a40;
            color: #fff;
            padding: 12px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .navbar-left { font-size: 18px; }
        .navbar-right a {
            color: #fff;
            margin-left: 20px;
            text-decoration: none;
            font-weight: bold;
        }
        .logout-btn {
            background-color: #e74c3c;
            color: #fff;
            padding: 7px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-left: 20px;
            font-weight: bold;
        }
        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 85%;
            background-color: #fff;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:hover { background-color: #f1f1f1; }
    </style>
</head>
<body>

<%
    // ✅ Session validation (no redeclaration of session object)
    if (session == null || session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    Student loggedUser = (Student) session.getAttribute("student");

    // ✅ Allow only admin (id == 1) to view all users
    if (loggedUser.getId() != 1) {
        response.sendRedirect("dashboard.jsp");
        return;
    }

    // ✅ Fetch all users from database
    StudentDAO dao = new StudentDAOImp();
    List<Student> list = dao.getAllStudents();
%>

<!-- ✅ Navbar -->
<div class="navbar">
    <div class="navbar-left">
        Welcome, <%= loggedUser.getName() %>
    </div>
    <div class="navbar-right">
        <a href="dashboard.jsp">Dashboard</a>
        <a href="update.jsp">Update</a>
        <a href="updatePassword.jsp">Update Password</a>
        <form action="logout" method="post" style="display:inline;">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>
</div>

<!-- ✅ User Table -->
<div class="container">
    <h2 class="text-center mt-4 mb-3">All Registered Users</h2>
    <table class="table table-bordered table-striped table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Student s : list) {
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getPh() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getBranch() %></td>
                <td><%= s.getLoc() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
