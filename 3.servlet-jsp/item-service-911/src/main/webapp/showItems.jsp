<%@page import="com.item.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show Items</title>
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
	align-items: flex-start;
	padding: 30px 20px;
}

.layer {
	background: rgba(255, 255, 255, 0.95);
	border-radius: 20px;
	box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
	padding: 40px;
	max-width: 1200px;
	width: 100%;
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	flex-wrap: wrap;
	gap: 15px;
	margin-bottom: 25px;
}

h1 {
	color: #333;
	font-size: 2.4rem;
	font-weight: 700;
	background: linear-gradient(45deg, #667eea, #764ba2);
	-webkit-background-clip: text;
	-webkit-text-fill-color: transparent;
}

.user-bar {
	display: flex;
	align-items: center;
	gap: 12px;
	flex-wrap: wrap;
}

.user-bar span {
	color: #555;
	font-weight: 500;
}

.user-bar a, .btn {
	display: inline-block;
	padding: 10px 20px;
	border-radius: 25px;
	text-decoration: none;
	font-weight: 500;
	font-size: 0.9rem;
	transition: all 0.3s;
	cursor: pointer;
	border: none;
}

.btn-primary {
	background: linear-gradient(45deg, #667eea, #764ba2);
	color: white;
	box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
}

.btn-danger {
	background: linear-gradient(45deg, #f44336, #FF9800);
	color: white;
}

.btn-outline {
	background: transparent;
	border: 2px solid #667eea;
	color: #667eea;
}

.btn:hover {
	transform: translateY(-2px);
}

table {
	width: 100%;
	border-collapse: separate;
	border-spacing: 0;
	margin-bottom: 30px;
	overflow: hidden;
	border-radius: 15px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

thead {
	background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

thead tr th {
	color: white;
	font-weight: 600;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-size: 0.85rem;
	padding: 18px 12px;
	text-align: left;
}

tbody tr {
	transition: all 0.3s;
	border-bottom: 1px solid rgba(0, 0, 0, 0.05);
}

tbody tr:nth-child(even) {
	background-color: rgba(102, 126, 234, 0.05);
}

tbody tr:hover {
	background-color: rgba(102, 126, 234, 0.1);
}

tbody td {
	padding: 16px 12px;
	color: #555;
	font-size: 0.95rem;
}

td strong {
	color: #333;
	font-weight: 600;
}

td a {
	display: inline-block;
	padding: 6px 14px;
	margin: 2px 4px 2px 0;
	border-radius: 20px;
	text-decoration: none;
	font-weight: 500;
	font-size: 0.8rem;
	text-transform: uppercase;
	letter-spacing: 0.3px;
}

.a-update {
	background: linear-gradient(45deg, #4CAF50, #8BC34A);
	color: white;
}

.a-delete {
	background: linear-gradient(45deg, #f44336, #FF9800);
	color: white;
}

.a-details {
	background: linear-gradient(45deg, #2196F3, #03A9F4);
	color: white;
}

.no-items {
	width: 100%;
	max-width: 500px;
	margin: 60px auto;
	padding: 30px;
	text-align: center;
	font-size: 1.6rem;
	font-weight: bold;
	color: #fff;
	background: linear-gradient(135deg, #ff6b6b, #ee5253);
	border-radius: 15px;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.25);
}

.center {
	text-align: center;
	margin-top: 20px;
}

@media ( max-width : 768px) {
	table {
		display: block;
		overflow-x: auto;
	}
	h1 {
		font-size: 1.8rem;
	}
}
</style>
</head>
<body>
	<%
    List<Item> items = (List<Item>) request.getAttribute("itemsData");
    String username = (String) session.getAttribute("username");
%>
	<div class="layer">
		<div class="header">
			<h1>Items</h1>
			<div class="user-bar">
				<% if (username != null) { %>
				<span>User: <%= username %></span> <a class="btn btn-outline"
					href="<%= request.getContextPath() %>/AuthController?action=logout">Logout</a>
				<a class="btn btn-danger"
					href="<%= request.getContextPath() %>/AuthController?action=deleteAccount"
					onclick="return confirm('Permanently delete your account?');">Delete
					Account</a>
				<% } else { %>
				<a class="btn btn-primary"
					href="<%= request.getContextPath() %>/login.jsp">Login</a>
				<% } %>
			</div>
		</div>

		<%
    if (items == null || items.isEmpty()) {
%>
		<div class="no-items">No items found.</div>
		<div class="center">
			<a class="btn btn-primary"
				href="<%= request.getContextPath() %>/add-item.jsp">Add Item</a>
		</div>
		<%
    } else {
%>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>PRICE</th>
					<th>TOTAL</th>
					<th>DETAILS</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<% for (Item item : items) { %>
				<tr>
					<td><strong><%= item.getId() %></strong></td>
					<td><%= item.getName() %></td>
					<td><%= String.format("%.2f", item.getPrice()) %></td>
					<td><%= item.getTotalNumber() %></td>
					<td>
						<% if (item.hasDetails()) { %> <a class="a-details"
						href="<%= request.getContextPath() %>/ItemController?action=showUpdateDetails&amp;itemId=<%= item.getId() %>">Update
							Details</a> <% } else { %> <a class="a-details"
						href="<%= request.getContextPath() %>/ItemController?action=showAddDetails&amp;itemId=<%= item.getId() %>">Add
							Details</a> <% } %>
					</td>
					<td><a class="a-update"
						href="<%= request.getContextPath() %>/ItemController?action=showItem&amp;id=<%= item.getId() %>">Update</a>
						<a class="a-delete"
						href="<%= request.getContextPath() %>/ItemController?action=deleteItem&amp;id=<%= item.getId() %>"
						onclick="return confirm('Delete this item and its details?');">Delete</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<div class="center">
			<a class="btn btn-primary"
				href="<%= request.getContextPath() %>/add-item.jsp">Add Item</a>
		</div>
		<% } %>
	</div>
</body>
</html>
