<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign Up – E-Wallet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="auth-wrapper">
    <div class="auth-card" style="max-width:460px">
        <div class="brand">
            <div class="logo">📝</div>
            <h1>Create Account</h1>
            <p>Join E-Wallet today</p>
        </div>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <form method="post" action="${pageContext.request.contextPath}/signup" autocomplete="off">
            <div class="mb-3">
                <label class="form-label" for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control"
                       value="${username}" required placeholder="Must start with uppercase">
                <div class="form-text">Min 3 chars, starts with uppercase letter</div>
            </div>
            <div class="mb-3">
                <label class="form-label" for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control"
                       required placeholder="Min 6 chars, upper + lower + digit">
            </div>
            <div class="mb-3">
                <label class="form-label" for="confirmPassword">Confirm Password</label>
                <input type="password" id="confirmPassword" name="confirmPassword" class="form-control"
                       required placeholder="Re-enter password">
            </div>
            <div class="mb-3">
                <label class="form-label" for="phone">Phone Number</label>
                <input type="text" id="phone" name="phone" class="form-control"
                       value="${phone}" required placeholder="01XXXXXXXXX" maxlength="11">
                <div class="form-text">Egyptian format: 11 digits starting with 01</div>
            </div>
            <div class="mb-3">
                <label class="form-label" for="age">Age</label>
                <input type="number" id="age" name="age" class="form-control"
                       value="${age}" required min="18" max="120" placeholder="18+">
            </div>
            <button type="submit" class="btn btn-primary w-100">Create Account</button>
        </form>

        <div class="auth-footer">
            Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a>
        </div>
    </div>
</div>
</body>
</html>
