<%@page import="com.item.model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Item</title>
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
	max-width: 560px;
	width: 100%;
	background: rgba(255, 255, 255, 0.95);
	padding: 40px 50px;
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
	margin-bottom: 35px;
}

.form-row {
	margin-bottom: 22px;
}

.form-row label {
	display: block;
	margin-bottom: 6px;
	color: #555;
	font-weight: 500;
}

.form-row input {
	width: 100%;
	padding: 12px 14px;
	border: 2px solid #e0e0e0;
	border-radius: 10px;
	font-size: 1rem;
}

.form-row input:focus {
	border-color: #71b7e6;
	outline: none;
}

.button {
	display: block;
	width: 100%;
	max-width: 280px;
	margin: 30px auto 20px;
	padding: 14px;
	border: none;
	border-radius: 50px;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	color: white;
	font-size: 1.1rem;
	font-weight: 600;
	cursor: pointer;
}

.back {
	text-align: center;
}

.back a {
	color: #666;
	text-decoration: none;
}
</style>
</head>
<body>
	<%
    Item item = (Item) request.getAttribute("itemData");
    if (item == null) {
        response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Item+not+found");
        return;
    }
%>
	<div class="container">
		<div class="text">Update Item</div>
		<form action="<%= request.getContextPath() %>/ItemController"
			method="post">
			<input type="hidden" name="action" value="updateItem"> <input
				type="hidden" name="id" value="<%= item.getId() %>">
			<div class="form-row">
				<label>Name</label> <input type="text" name="name" required
					maxlength="100" value="<%= item.getName() %>">
			</div>
			<div class="form-row">
				<label>Price</label> <input type="number" name="price" required
					min="0.01" step="0.01" value="<%= item.getPrice() %>">
			</div>
			<div class="form-row">
				<label>Total Number</label> <input type="number" name="totalNumber"
					required min="0" step="1" value="<%= item.getTotalNumber() %>">
			</div>
			<button type="submit" class="button">Update</button>
		</form>
		<p class="back">
			<a
				href="<%= request.getContextPath() %>/ItemController?action=showItems">Back
				To Items</a>
		</p>
	</div>
</body>
</html>
