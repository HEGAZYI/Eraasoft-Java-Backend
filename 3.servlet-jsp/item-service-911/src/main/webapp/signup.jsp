<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
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
	max-width: 480px;
	width: 100%;
	background: rgba(255, 255, 255, 0.95);
	padding: 40px 45px;
	border-radius: 20px;
	box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
}

.text {
	font-size: 2.2rem;
	font-weight: 700;
	text-align: center;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	margin-bottom: 25px;
}

.input-data {
	margin-bottom: 18px;
}

.input-data label {
	display: block;
	margin-bottom: 5px;
	color: #555;
	font-weight: 500;
	font-size: 0.95rem;
}

.input-data input {
	width: 100%;
	padding: 11px 14px;
	border: 2px solid #e0e0e0;
	border-radius: 10px;
	font-size: 1rem;
}

.input-data input:focus {
	border-color: #71b7e6;
	outline: none;
}

.button {
	width: 100%;
	padding: 14px;
	border: none;
	border-radius: 50px;
	margin-top: 10px;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	color: white;
	font-size: 1.1rem;
	font-weight: 600;
	cursor: pointer;
}

.button:hover {
	opacity: 0.95;
}

.links {
	text-align: center;
	margin-top: 22px;
}

.links a {
	color: #3498db;
	text-decoration: none;
}

.alert {
	padding: 12px 16px;
	border-radius: 10px;
	margin-bottom: 18px;
	background: #fdecea;
	color: #c0392b;
}
</style>
</head>
<body>
	<div class="container">
		<div class="text">Create Account</div>
		<% if (request.getAttribute("error") != null) { %>
		<div class="alert"><%= request.getAttribute("error") %></div>
		<% } %>
		<form action="<%= request.getContextPath() %>/AuthController"
			method="post">
			<input type="hidden" name="action" value="signup">
			<div class="input-data">
				<label>Username</label> <input type="text" name="username" required
					 maxlength="50" pattern="[A-Za-z0-9_]+">
			</div>
			<div class="input-data">
				<label>Email</label> <input type="email" name="email" required>
			</div>
			<div class="input-data">
				<label>Full Name</label> <input type="text" name="fullName">
			</div>
			<div class="input-data">
				<label>Password</label> <input type="password" name="password"
					required >
			</div>
			<div class="input-data">
				<label>Confirm Password</label> <input type="password"
					name="confirmPassword" required >
			</div>
			<button type="submit" class="button">Sign Up</button>
		</form>
		<div class="links">
			Already have an account? <a
				href="<%= request.getContextPath() %>/login.jsp">Login</a>
		</div>
	</div>
</body>
</html>
