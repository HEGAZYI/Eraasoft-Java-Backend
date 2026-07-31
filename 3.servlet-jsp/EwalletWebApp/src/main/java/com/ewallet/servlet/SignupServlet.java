package com.ewallet.servlet;

import com.ewallet.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            res.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm  = req.getParameter("confirmPassword");
        String phone    = req.getParameter("phone");
        String ageStr   = req.getParameter("age");

        // Keep form data on error
        req.setAttribute("username", username);
        req.setAttribute("phone", phone);
        req.setAttribute("age", ageStr);

        if (password == null || !password.equals(confirm)) {
            req.setAttribute("error", "Passwords do not match");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, res);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid age");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, res);
            return;
        }

        AuthService.Result result = authService.register(username, password, phone, age);

        if (result.success) {
            // Auto-login after signup
            HttpSession old = req.getSession(false);
            if (old != null) old.invalidate();

            HttpSession session = req.getSession(true);
            session.setAttribute("user", result.account);
            session.setMaxInactiveInterval(30 * 60);

            res.sendRedirect(req.getContextPath() + "/dashboard?welcome=1");
        } else {
            req.setAttribute("error", result.message);
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, res);
        }
    }
}
