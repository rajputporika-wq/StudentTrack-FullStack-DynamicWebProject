<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pentagon.StudentDTO.Student" %>
<%@ page import="jakarta.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background: #fff;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        width: 500px;
    }
    h2 {
        text-align: center;
        margin-bottom: 20px;
    }
    label {
        font-weight: bold;
    }
    input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    .btn-container {
        display: flex;
        justify-content: space-between;
        margin-top: 15px;
    }
</style>
</head>
<body>

<%
    Student s = (Student) session.getAttribute("student");

    if (s != null) {
%>

    <div class="container">
        <h2>Update Student Details</h2>

        <form action="updateStudent" method="post">
            <label>ID</label>
            <input type="text" name="id" value="<%= s.getId() %>" readonly>

            <label>Name</label>
            <input type="text" name="name" value="<%= s.getName() %>" required>

            <label>Phone</label>
            <input type="tel" name="phone" value="<%= s.getPh() %>" required>

            <label>Email</label>
            <input type="email" name="email" value="<%= s.getEmail() %>" required>

            
            <label>Branch</label>
            <input type="text" name="branch" value="<%= s.getBranch() %>" required>

            <label>Location</label>
            <input type="text" name="location" value="<%= s.getLoc() %>" required>

            <div class="btn-container">
                <a href="dashboard.jsp" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>

<%
    } else {
        request.setAttribute("error", "Session expired. Please log in again.");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
