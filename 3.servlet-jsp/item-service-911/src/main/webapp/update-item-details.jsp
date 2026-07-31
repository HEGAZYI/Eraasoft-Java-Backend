<%@page import="com.item.model.Item"%>
<%@page import="com.item.model.ItemDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Item Details</title>
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
	max-width: 600px;
	width: 100%;
	background: rgba(255, 255, 255, 0.95);
	padding: 40px 50px;
	border-radius: 20px;
	box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
}

.text {
	font-size: 2rem;
	font-weight: 700;
	text-align: center;
	background: linear-gradient(45deg, #71b7e6, #9b59b6);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
	margin-bottom: 10px;
}

.sub {
	text-align: center;
	color: #666;
	margin-bottom: 30px;
}

.form-row {
	margin-bottom: 18px;
}

.form-row label {
	display: block;
	margin-bottom: 5px;
	color: #555;
	font-weight: 500;
}

.form-row input, .form-row textarea {
	width: 100%;
	padding: 11px 14px;
	border: 2px solid #e0e0e0;
	border-radius: 10px;
	font-size: 1rem;
}

.form-row textarea {
	min-height: 90px;
	resize: vertical;
}

.button {
	display: block;
	width: 100%;
	max-width: 280px;
	margin: 25px auto 15px;
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
    ItemDetails details = (ItemDetails) request.getAttribute("detailsData");
    if (item == null || details == null) {
        response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Item+details+not+found");
        return;
    }
%>
	<div class="container">
		<div class="text">Update Item Details</div>
		<p class="sub">
			For item: <strong><%= item.getName() %></strong> (ID
			<%= item.getId() %>)
		</p>
		<form action="<%= request.getContextPath() %>/ItemController"
			method="post">
			<input type="hidden" name="action" value="updateDetails"> <input
				type="hidden" name="itemId" value="<%= item.getId() %>">
			<div class="form-row">
				<label>Description</label>
				<textarea name="description" maxlength="1000"><%= details.getDescription() != null ? details.getDescription() : "" %></textarea>
			</div>
			<div class="form-row">
				<label>Category</label> <input type="text" name="category"
					maxlength="100"
					value="<%= details.getCategory() != null ? details.getCategory() : "" %>">
			</div>
			<div class="form-row">
				<label>Manufacturer</label> <input type="text" name="manufacturer"
					maxlength="100"
					value="<%= details.getManufacturer() != null ? details.getManufacturer() : "" %>">
			</div>
			<div class="form-row">
				<label>Warranty (months)</label> <input type="number"
					name="warrantyMonths" min="0"
					value="<%= details.getWarrantyMonths() %>">
			</div>
			<button type="submit" class="button">Update Details</button>
		</form>
		<p class="back">
			<a
				href="<%= request.getContextPath() %>/ItemController?action=showItems">←
				Back To Items</a>
		</p>
	</div>
</body>
</html>
