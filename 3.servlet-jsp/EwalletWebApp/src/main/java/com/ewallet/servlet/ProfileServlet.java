package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.WalletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final WalletService walletService = new WalletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Account sessionUser = (Account) req.getSession().getAttribute("user");
        Optional<Account> fresh = walletService.getAccount(sessionUser.getId());
        req.setAttribute("user", fresh.orElse(sessionUser));
        req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, res);
    }
}
