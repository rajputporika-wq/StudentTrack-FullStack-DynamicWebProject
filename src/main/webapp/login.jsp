<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
  body {
    background-color: #f5f7fa;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: 'Poppins', sans-serif;
  }
  .login-container {
    width: 400px;
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
    padding: 40px 35px;
  }
  .login-title {
    text-align: center;
    font-weight: 600;
    font-size: 1.8rem;
    color: #333333;
    margin-bottom: 25px;
  }
  .form-label {
    font-weight: 500;
    color: #444;
  }
  .form-control {
    border-radius: 8px;
    border: 1px solid #ccc;
    padding: 10px 12px;
  }
  .btn-primary {
    width: 100%;
    border-radius: 8px;
    background-color: #007bff;
    border: none;
    font-weight: 500;
    padding: 10px;
    transition: 0.3s ease;
  }
  .btn-primary:hover {
    background-color: #0056d2;
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
  .alert {
    padding: 8px;
    font-size: 0.9rem;
    text-align: center;
  }
</style>
</head>

<body>

<div class="login-container">

  <div class="login-title">User Login</div>

  <!-- Success / Failure Messages -->
  <% if (request.getAttribute("success") != null) { %>
    <div class="alert alert-success"><%= request.getAttribute("success") %></div>
  <% } %>

	<% if (request.getAttribute("error") != null) { %>
	  <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
	<% } %>

  <!-- Login Form -->
  <form action="login" method="post">
    <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Email address</label>
      <input name="email" type="email" class="form-control" id="exampleInputEmail1" required>
      <div class="form-text">We'll never share your email with anyone else.</div>
    </div>

    <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Password</label>
      <input name="password" type="password" class="form-control" id="exampleInputPassword1" required>
    </div>

    <button type="submit" class="btn btn-primary">Login</button>

    <div class="links">
      <a href="signup.jsp">Create Account</a> |
      <a href="forgotpassword.jsp">Forgot Password?</a>
    </div>
  </form>
</div>

</body>
</html>
