<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:set var="pageTitle" value="Transaction History" scope="request"/>
<%@ include file="layout-header.jsp" %>

<div class="content-card">
    <h2 class="page-title">📄 Transaction History</h2>

    <c:choose>
        <c:when test="${empty transactions}">
            <p class="text-muted text-center py-4">No transactions yet.</p>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Type</th>
                        <th>Amount</th>
                        <th>Details</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="t" items="${transactions}">
                        <tr>
                            <td class="text-nowrap small">${t.createdAt}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${t.type == 'DEPOSIT'}">
                                        <span class="badge badge-type bg-success">${t.type}</span>
                                    </c:when>
                                    <c:when test="${t.type == 'WITHDRAW'}">
                                        <span class="badge badge-type bg-danger">${t.type}</span>
                                    </c:when>
                                    <c:when test="${t.type == 'TRANSFER'}">
                                        <span class="badge badge-type bg-primary">${t.type}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge badge-type bg-secondary">${t.type}</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:if test="${t.amount > 0}">
                                    <fmt:formatNumber value="${t.amount}" type="currency" currencySymbol="EGP "/>
                                </c:if>
                                <c:if test="${t.amount == 0}">—</c:if>
                            </td>
                            <td class="small text-muted">${t.details}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="layout-footer.jsp" %>
