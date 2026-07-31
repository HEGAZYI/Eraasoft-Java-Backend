package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.WalletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

    private final WalletService walletService = new WalletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/deposit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Account user = (Account) req.getSession().getAttribute("user");
        String amount = req.getParameter("amount");

        WalletService.Result result = walletService.deposit(user.getId(), user.getUsername(), amount);

        if (result.success) {
            user.setBalance(result.newBalance);
            req.getSession().setAttribute("user", user);
            req.setAttribute("success", result.message + " New balance: " + result.newBalance);
        } else {
            req.setAttribute("error", result.message);
        }

        req.getRequestDispatcher("/WEB-INF/views/deposit.jsp").forward(req, res);
    }
}
