<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px;
}

.card {
	background: rgba(255, 255, 255, 0.95);
	border-radius: 20px;
	padding: 50px 40px;
	max-width: 500px;
	width: 100%;
	text-align: center;
	box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
}

.icon {
	font-size: 4rem;
	margin-bottom: 20px;
}

h1 {
	color: #e74c3c;
	margin-bottom: 15px;
	font-size: 1.8rem;
}

p {
	color: #555;
	margin-bottom: 30px;
	line-height: 1.5;
}

a {
	display: inline-block;
	padding: 14px 32px;
	background: linear-gradient(45deg, #667eea, #764ba2);
	color: white;
	text-decoration: none;
	border-radius: 50px;
	font-weight: 600;
	transition: transform 0.2s;
}

a:hover {
	transform: translateY(-2px);
}
</style>
</head>
<body>
	<div class="card">
		<div class="icon">⚠️</div>
		<h1>Something went wrong</h1>
		<p>
			<%= request.getParameter("msg") != null
                ? request.getParameter("msg")
                : "An unexpected error occurred. Please try again." %>
		</p>
		<a
			href="<%= request.getContextPath() %>/ItemController?action=showItems">Back
			to Items</a> &nbsp; <a href="<%= request.getContextPath() %>/login.jsp">Login</a>
	</div>
</body>
</html>
