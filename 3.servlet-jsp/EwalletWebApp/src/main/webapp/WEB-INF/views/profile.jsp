<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="pageTitle" value="Profile" scope="request"/>
<%@ include file="layout-header.jsp" %>

<div class="content-card" style="max-width:520px;margin:0 auto">
    <h2 class="page-title">👤 Account Details</h2>

    <table class="table table-borderless">
        <tr>
            <th class="text-muted" style="width:40%">Username</th>
            <td><strong>${user.username}</strong></td>
        </tr>
        <tr>
            <th class="text-muted">Phone</th>
            <td>${user.phoneNumber}</td>
        </tr>
        <tr>
            <th class="text-muted">Age</th>
            <td>${user.age}</td>
        </tr>
        <tr>
            <th class="text-muted">Balance</th>
            <td><strong class="text-success">
                <fmt:formatNumber value="${user.balance}" type="currency" currencySymbol="EGP "/>
            </strong></td>
        </tr>
        <tr>
            <th class="text-muted">Status</th>
            <td>
                <c:choose>
                    <c:when test="${user.active}">
                        <span class="badge bg-success">Active</span>
                    </c:when>
                    <c:otherwise>
                        <span class="badge bg-danger">Inactive</span>
                    </c:otherwise>
                </c:choose>
                <c:if test="${user.admin}">
                    <span class="badge bg-primary ms-1">Admin</span>
                </c:if>
            </td>
        </tr>
        <c:if test="${not empty user.createdAt}">
            <tr>
                <th class="text-muted">Member Since</th>
                <td>${user.createdAt}</td>
            </tr>
        </c:if>
    </table>

    <a href="${pageContext.request.contextPath}/change-password" class="btn btn-outline-primary">
        🔑 Change Password
    </a>
</div>

<%@ include file="layout-footer.jsp" %>
