package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.WalletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private final WalletService walletService = new WalletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Account sessionUser = (Account) req.getSession().getAttribute("user");

        // Refresh balance from DB
        Optional<Account> fresh = walletService.getAccount(sessionUser.getId());
        if (fresh.isPresent()) {
            Account updated = fresh.get();
            updated.setPasswordHash(null);
            req.getSession().setAttribute("user", updated);
            req.setAttribute("user", updated);
        } else {
            req.setAttribute("user", sessionUser);
        }

        if ("1".equals(req.getParameter("welcome"))) {
            req.setAttribute("success", "Welcome! Your account is ready.");
        }

        req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req, res);
    }
}
