<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
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
        width: 350px;
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        transition: 0.3s;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    .msg {
        color: green;
        text-align: center;
        margin-bottom: 10px;
    }
    .links {
	    text-align: center;
	    margin-top: 15px;
	  }
	  .links a {
	    color: #007bff;
	    text-decoration: none;
	    margin: 0 5px;
	  }
	  .links a:hover {
	    text-decoration: underline;
	  }
</style>
</head>
<body>

    <div class="container">
        <% if(request.getAttribute("success") != null) { %>
            <p class="msg"><%= request.getAttribute("success") %></p>
        <% } %>

        <h1>Forgot Password</h1>

        <form action="forgotpassword" method="post">
            <input type="email" name="email" placeholder="Enter your email" required>
            <input type="tel" name="phone" placeholder="Enter phone number" required>
            <input type="password" name="password" placeholder="Enter new password" required>
            <input type="password" name="confirm" placeholder="Confirm password" required>
            <input type="submit" value="Reset Password">
            <div class="links">
            	<a href="login.jsp" >Back to Login</a>
            </div>
    
        </form>
    </div>

</body>
</html>

