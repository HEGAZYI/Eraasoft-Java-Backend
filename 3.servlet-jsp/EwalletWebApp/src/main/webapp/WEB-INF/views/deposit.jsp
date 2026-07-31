<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="pageTitle" value="Deposit" scope="request"/>
<%@ include file="layout-header.jsp" %>

<div class="content-card" style="max-width:480px;margin:0 auto">
    <h2 class="page-title">💰 Deposit Money</h2>

    <c:if test="${not empty success}"><div class="alert alert-success">${success}</div></c:if>
    <c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>

    <form method="post" action="${pageContext.request.contextPath}/deposit">
        <div class="mb-3">
            <label class="form-label" for="amount">Amount (EGP)</label>
            <input type="number" step="0.01" min="0.01" id="amount" name="amount"
                   class="form-control form-control-lg" required placeholder="0.00" autofocus>
        </div>
        <button type="submit" class="btn btn-primary w-100">Confirm Deposit</button>
        <a href="${pageContext.request.contextPath}/dashboard" class="btn btn-outline-secondary w-100 mt-2">Cancel</a>
    </form>
</div>

<%@ include file="layout-footer.jsp" %>
