<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="pageTitle" value="Admin – Accounts" scope="request"/>
<%@ include file="../layout-header.jsp" %>

<div class="content-card">
    <h2 class="page-title"><i class="bi bi-shield-lock"></i> All Accounts</h2>

    <c:if test="${not empty param.success}">
        <div class="alert alert-success">${param.success}</div>
    </c:if>
    <c:if test="${not empty param.error}">
        <div class="alert alert-danger">${param.error}</div>
    </c:if>

    <div class="table-responsive">
        <table class="table table-hover align-middle">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Phone</th>
                <th>Age</th>
                <th>Balance</th>
                <th>Role</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="acc" items="${accounts}">
                <tr>
                    <td>${acc.id}</td>
                    <td><strong>${acc.username}</strong></td>
                    <td>${acc.phoneNumber}</td>
                    <td>${acc.age}</td>
                    <td>
                        <fmt:formatNumber value="${acc.balance}" type="currency" currencySymbol="EGP "/>
                    </td>
                    <td>
                        <c:if test="${acc.admin}"><span class="badge bg-primary">Admin</span></c:if>
                        <c:if test="${!acc.admin}"><span class="badge bg-secondary">User</span></c:if>
                    </td>
                    <td>
                        <c:if test="${acc.active}"><span class="badge bg-success">Active</span></c:if>
                        <c:if test="${!acc.active}"><span class="badge bg-danger">Inactive</span></c:if>
                    </td>
                    <td>
                        <c:if test="${acc.id != sessionScope.user.id}">
                            <form method="post" action="${pageContext.request.contextPath}/admin/accounts"
                                  class="d-inline" onsubmit="return confirm('Are you sure?');">
                                <input type="hidden" name="accountId" value="${acc.id}">
                                <c:if test="${acc.active}">
                                    <button type="submit" name="action" value="deactivate"
                                            class="btn btn-sm btn-outline-warning">Deactivate</button>
                                </c:if>
                                <c:if test="${!acc.active}">
                                    <button type="submit" name="action" value="activate"
                                            class="btn btn-sm btn-outline-success">Activate</button>
                                </c:if>
                                <button type="submit" name="action" value="delete"
                                        class="btn btn-sm btn-outline-danger"
                                        onclick="return confirm('Delete permanently?');">Delete</button>
                            </form>
                        </c:if>
                        <c:if test="${acc.id == sessionScope.user.id}">
                            <span class="text-muted small">You</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../layout-footer.jsp" %>
