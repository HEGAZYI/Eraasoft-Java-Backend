<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Change Password" scope="request"/>
<%@ include file="layout-header.jsp" %>

<div class="content-card" style="max-width:480px;margin:0 auto">
    <h2 class="page-title">🔑 Change Password</h2>

    <c:if test="${not empty success}"><div class="alert alert-success">${success}</div></c:if>
    <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

    <form method="post" action="${pageContext.request.contextPath}/change-password">
        <div class="mb-3">
            <label class="form-label" for="currentPassword">Current Password</label>
            <input type="password" id="currentPassword" name="currentPassword"
                   class="form-control" required autofocus>
        </div>
        <div class="mb-3">
            <label class="form-label" for="newPassword">New Password</label>
            <input type="password" id="newPassword" name="newPassword" class="form-control" required>
            <div class="form-text">Min 6 chars, must include upper, lower &amp; digit</div>
        </div>
        <div class="mb-3">
            <label class="form-label" for="confirmPassword">Confirm New Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Update Password</button>
        <a href="${pageContext.request.contextPath}/profile" class="btn btn-outline-secondary w-100 mt-2">Cancel</a>
    </form>
</div>

<%@ include file="layout-footer.jsp" %>
