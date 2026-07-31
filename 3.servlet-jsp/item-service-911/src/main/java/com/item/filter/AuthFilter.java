package com.item.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Protects authenticated pages. Public paths: login, signup, forgot-password, static.
 */
@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static final String[] PUBLIC_PREFIXES = {
            "/login", "/signup", "/forgot-password", "/AuthController",
            "/css/", "/js/", "/error.jsp"
    };

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String path = req.getRequestURI().substring(req.getContextPath().length());
        if (path.isEmpty()) {
            path = "/";
        }

        if (isPublic(path)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (!loggedIn) {
            // try remember-me cookie
            jakarta.servlet.http.Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (jakarta.servlet.http.Cookie c : cookies) {
                    if ("rememberMe".equals(c.getName()) && c.getValue() != null && !c.getValue().isEmpty()) {
                        // simple token presence – full token validation would go in AuthController
                        // for now redirect to login; cookie is used on login page
                        break;
                    }
                }
            }
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean isPublic(String path) {
        if ("/".equals(path) || path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".png")
                || path.endsWith(".jpg") || path.endsWith(".ico")) {
            return true;
        }
        for (String prefix : PUBLIC_PREFIXES) {
            if (path.startsWith(prefix) || path.equals(prefix + ".jsp")) {
                return true;
            }
        }
        // login.jsp, signup.jsp, forgot-password.jsp
        if (path.endsWith("login.jsp") || path.endsWith("signup.jsp")
                || path.endsWith("forgot-password.jsp") || path.endsWith("error.jsp")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
    }
}
