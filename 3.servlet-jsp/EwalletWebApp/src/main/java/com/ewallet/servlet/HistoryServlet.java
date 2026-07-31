package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.WalletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    private final WalletService walletService = new WalletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Account user = (Account) req.getSession().getAttribute("user");
        req.setAttribute("transactions", walletService.getHistory(user.getUsername()));
        req.getRequestDispatcher("/WEB-INF/views/history.jsp").forward(req, res);
    }
}
