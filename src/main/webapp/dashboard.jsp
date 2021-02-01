<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pentagon.StudentDTO.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
        body { font-family: Arial, sans-serif; }
        .navbar {
            background-color: #343a40;
            color: #fff;
            padding: 12px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .navbar-left {
            font-size: 18px;
        }
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
        .container {
            margin: 25px;
        }
        h2 {
            text-align: center;
        }
        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 80%;
            background: #fff;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 9px 14px;
            text-align: center;
        }
        th {
            background: #f2f2f2;
            font-weight: bold;
        }
    </style>
</head>
<body>
	    <%
	Student s = (Student) session.getAttribute("student");
	if (s == null) {
	    response.sendRedirect("login.jsp");
	    return;
	}
	%>
    <div class="navbar">
        <div class="navbar-left">
            Welcome <%= s.getName() %>
        </div>
        <div class="navbar-right">
        	<% if (s.getId() == 1) { %>
			    <a href="view_user.jsp">view_user</a>
			<% } %>
            <a href="update.jsp">Update</a>
            <a href="forgotpassword.jsp">UpdatePassword</a>
            <form action="login.jsp" method="post" style="display:inline;">
                <button class="logout-btn" type="submit">Logout</button>
            </form>
        </div>
    </div>
    <div class="container">
        <h2>User Details</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Branch</th>
                <th>Location</th>
            </tr>
            <tr>
                <td><%= s.getId() %></td>
		        <td><%= s.getName() %></td>
		        <td><%= s.getPh() %></td>
		        <td><%= s.getEmail() %></td>
		        <td><%= s.getBranch() %></td>
		        <td><%= s.getLoc() %></td>
            </tr>
        </table>
    </div>
</body>
</html>
