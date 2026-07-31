package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Already logged in → dashboard
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            res.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }

        String error = req.getParameter("error");
        if ("session".equals(error)) {
            req.setAttribute("error", "Your session has expired. Please login again.");
        }

        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AuthService.Result result = authService.login(username, password);

        if (result.success) {
            // Invalidate old session & create fresh one (session fixation protection)
            HttpSession old = req.getSession(false);
            if (old != null) old.invalidate();

            HttpSession session = req.getSession(true);
            session.setAttribute("user", result.account);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            res.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            req.setAttribute("error", result.message);
            req.setAttribute("username", username);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        }
    }
}
