<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="pageTitle" value="Transfer" scope="request"/>
<%@ include file="layout-header.jsp" %>

<div class="content-card" style="max-width:480px;margin:0 auto">
    <h2 class="page-title">🔄 Transfer Money</h2>
    <p class="text-muted mb-3">Available:
        <strong><fmt:formatNumber value="${sessionScope.user.balance}" type="currency" currencySymbol="EGP "/></strong>
    </p>

    <c:if test="${not empty success}"><div class="alert alert-success">${success}</div></c:if>
    <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

    <form method="post" action="${pageContext.request.contextPath}/transfer">
        <div class="mb-3">
            <label class="form-label" for="receiver">Receiver Username</label>
            <input type="text" id="receiver" name="receiver" class="form-control"
                   value="${receiver}" required placeholder="Username of recipient" autofocus>
        </div>
        <div class="mb-3">
            <label class="form-label" for="amount">Amount (EGP)</label>
            <input type="number" step="0.01" min="0.01" id="amount" name="amount"
                   class="form-control form-control-lg" required placeholder="0.00">
        </div>
        <button type="submit" class="btn btn-primary w-100">Send Transfer</button>
        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-outline-secondary w-100 mt-2">Cancel</a>
    </form>
</div>

<%@ include file="layout-footer.jsp" %>
