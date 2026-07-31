<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="pageTitle" value="Dashboard" scope="request"/>
<%@ include file="layout-header.jsp" %>

<c:if test="${not empty success}">
    <div class="alert alert-success alert-dismissible fade show">${success}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    </div>
</c:if>

<div class="balance-card mb-4">
    <div class="label">Available Balance</div>
    <div class="amount">
        <fmt:formatNumber value="${user.balance}" type="currency" currencySymbol="EGP "/>
    </div>
    <div class="user-info">Welcome back, <strong>${user.username}</strong>
        <c:if test="${user.admin}"> &bull; Admin</c:if>
    </div>
</div>

<div class="row g-3">
    <div class="col-6 col-md-3">
        <a href="${pageContext.request.contextPath}/deposit" class="action-card">
            <div class="icon">💰</div>
            <h5>Deposit</h5>
            <p>Add money</p>
        </a>
    </div>
    <div class="col-6 col-md-3">
        <a href="${pageContext.request.contextPath}/withdraw" class="action-card">
            <div class="icon">💸</div>
            <h5>Withdraw</h5>
            <p>Cash out</p>
        </a>
    </div>
    <div class="col-6 col-md-3">
        <a href="${pageContext.request.contextPath}/transfer" class="action-card">
            <div class="icon">🔄</div>
            <h5>Transfer</h5>
            <p>Send money</p>
        </a>
    </div>
    <div class="col-6 col-md-3">
        <a href="${pageContext.request.contextPath}/history" class="action-card">
            <div class="icon">📄</div>
            <h5>History</h5>
            <p>Transactions</p>
        </a>
    </div>
</div>

<%@ include file="layout-footer.jsp" %>
