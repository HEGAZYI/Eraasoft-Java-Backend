package com.ewallet.servlet;

import com.ewallet.model.Account;
import com.ewallet.service.WalletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {

    private final WalletService walletService = new WalletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String path = req.getPathInfo();
        if (path == null || path.equals("/") || path.equals("/accounts")) {
            req.setAttribute("accounts", walletService.getAllAccounts());
            req.getRequestDispatcher("/WEB-INF/views/admin/accounts.jsp").forward(req, res);
        } else {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String idStr  = req.getParameter("accountId");

        int accountId;
        try {
            accountId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            res.sendRedirect(req.getContextPath() + "/admin/accounts?error=invalid");
            return;
        }

        // Prevent admin from deleting/deactivating themselves
        Account current = (Account) req.getSession().getAttribute("user");
        if (current.getId() == accountId) {
            res.sendRedirect(req.getContextPath() + "/admin/accounts?error=self");
            return;
        }

        WalletService.Result result;
        switch (action != null ? action : "") {
            case "deactivate" -> result = walletService.deactivate(accountId);
            case "activate"   -> result = walletService.activate(accountId);
            case "delete"     -> result = walletService.deleteAccount(accountId);
            default           -> {
                res.sendRedirect(req.getContextPath() + "/admin/accounts?error=action");
                return;
            }
        }

        String param = result.success ? "success=" + result.message : "error=" + result.message;
        res.sendRedirect(req.getContextPath() + "/admin/accounts?" + param);
    }
}
