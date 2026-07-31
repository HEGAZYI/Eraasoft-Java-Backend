package com.ewallet.filter;

import com.ewallet.model.Account;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Protects all private pages. Redirects unauthenticated users to login.
 * Also blocks deactivated accounts.
 */
@WebFilter(urlPatterns = {
        "/dashboard", "/deposit", "/withdraw", "/transfer",
        "/profile", "/change-password", "/history", "/admin/*"
})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session     = req.getSession(false);

        Account user = (session != null) ? (Account) session.getAttribute("user") : null;

        if (user == null) {
            res.sendRedirect(req.getContextPath() + "/login?error=session");
            return;
        }

        // Admin-only routes
        String path = req.getRequestURI();
        if (path.contains("/admin/") && !user.isAdmin()) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Admin access required");
            return;
        }

        chain.doFilter(request, response);
    }
}
