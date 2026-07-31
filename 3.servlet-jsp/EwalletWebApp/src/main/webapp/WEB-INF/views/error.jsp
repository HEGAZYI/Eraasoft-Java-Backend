<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error – E-Wallet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="auth-wrapper">
    <div class="auth-card text-center">
        <div class="logo" style="font-size:3rem">⚠️</div>
        <h1 class="h4 mt-2">Something went wrong</h1>
        <p class="text-muted">An unexpected error occurred. Please try again later.</p>
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary mt-2">Go Home</a>
    </div>
</div>
</body>
</html>
