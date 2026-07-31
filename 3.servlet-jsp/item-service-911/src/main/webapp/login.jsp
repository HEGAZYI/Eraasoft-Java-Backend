<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', 'Segoe UI', sans-serif;
}

body {
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
	padding: 40px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.container {
	max-width: 420px;
	width: 100%;
	background: rgba(255, 255, 255, 0.95);
	padding: 40px 45px;
	border-radius: 20px;
	box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
}

.text {
	font-size: 2.4rem;
	font-weight: 700;
	text-align: center;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	margin-bottom: 30px;
}

.input-data {
	margin-bottom: 25px;
	position: relative;
}

.input-data label {
	display: block;
	margin-bottom: 6px;
	color: #555;
	font-weight: 500;
}

.input-data input[type=text], .input-data input[type=password] {
	width: 100%;
	padding: 12px 14px;
	border: 2px solid #e0e0e0;
	border-radius: 10px;
	font-size: 1rem;
	transition: border-color 0.3s;
}

.input-data input:focus {
	border-color: #71b7e6;
	outline: none;
}

.remember {
	display: flex;
	align-items: center;
	gap: 8px;
	margin-bottom: 25px;
	color: #555;
}

.button {
	width: 100%;
	padding: 14px;
	border: none;
	border-radius: 50px;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	color: white;
	font-size: 1.1rem;
	font-weight: 600;
	cursor: pointer;
	transition: transform 0.2s, box-shadow 0.2s;
}

.button:hover {
	transform: translateY(-2px);
	box-shadow: 0 8px 20px rgba(113, 183, 230, 0.4);
}

.links {
	text-align: center;
	margin-top: 25px;
}

.links a {
	color: #3498db;
	text-decoration: none;
	margin: 0 8px;
}

.links a:hover {
	text-decoration: underline;
}

.alert {
	padding: 12px 16px;
	border-radius: 10px;
	margin-bottom: 20px;
	font-size: 0.95rem;
}

.alert-error {
	background: #fdecea;
	color: #c0392b;
	border: 1px solid #f5c6cb;
}

.alert-success {
	background: #e8f8f0;
	color: #1e8449;
	border: 1px solid #a9dfbf;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text">Login</div>

		<% if (request.getAttribute("error") != null) { %>
		<div class="alert alert-error"><%= request.getAttribute("error") %></div>
		<% } %>
		<% if ("accountDeleted".equals(request.getParameter("msg"))) { %>
		<div class="alert alert-success">Account deleted successfully.</div>
		<% } %>

		<form action="<%= request.getContextPath() %>/AuthController"
			method="post">
			<input type="hidden" name="action" value="login">
			<div class="input-data">
				<label>Username or Email</label> <input type="text" name="username"
					required
					value="<%= request.getParameter("username") != null ? request.getParameter("username") : "" %>">
			</div>
			<div class="input-data">
				<label>Password</label> <input type="password" name="password"
					required>
			</div>
			<div class="remember">
				<input type="checkbox" name="remember" id="remember"> <label
					for="remember">Remember me</label>
			</div>
			<button type="submit" class="button">Sign In</button>
		</form>
		<div class="links">
			<a href="<%= request.getContextPath() %>/signup.jsp">Create
				account</a> · <a
				href="<%= request.getContextPath() %>/forgot-password.jsp">Forgot
				password?</a>
		</div>
	</div>
</body>
</html>
