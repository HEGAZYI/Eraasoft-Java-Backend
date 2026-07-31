package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/change-password")
public class ChangePasswordServlet extends HttpServlet {

    private final AuthService authService = new AuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/change-password.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Account user = (Account) req.getSession().getAttribute("user");
        String current = req.getParameter("currentPassword");
        String newPass = req.getParameter("newPassword");
        String confirm = req.getParameter("confirmPassword");

        if (newPass == null || !newPass.equals(confirm)) {
            req.setAttribute("error", "New passwords do not match");
            req.getRequestDispatcher("/WEB-INF/views/change-password.jsp").forward(req, res);
            return;
        }

        AuthService.Result result = authService.changePassword(user.getId(), current, newPass);

        if (result.success) {
            req.setAttribute("success", result.message);
        } else {
            req.setAttribute("error", result.message);
        }

        req.getRequestDispatcher("/WEB-INF/views/change-password.jsp").forward(req, res);
    }
}
