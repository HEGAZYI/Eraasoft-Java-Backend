package com.ewallet.servlet;

import com.ewallet.dao.AccountDAO;
import com.ewallet.model.Account;
import com.ewallet.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

/**
 * One-time setup: creates / resets the default Admin account.
 * Password: Admin@123
 * REMOVE or protect this servlet in production!
 */
@WebServlet("/setup-admin")
public class SetupAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        AccountDAO dao = new AccountDAO();

        try {
            Optional<Account> existing = dao.findByUsername("Admin");
            String hash = PasswordUtil.hash("Admin@123");

            if (existing.isPresent()) {
                dao.updatePassword(existing.get().getId(), hash);
                out.println("Admin password reset to: Admin@123");
            } else {
                Account admin = new Account("Admin", hash, "01000000000", 30);
                admin.setAdmin(true);
                admin.setBalance(BigDecimal.ZERO);
                dao.create(admin);
                out.println("Admin account created. Username: Admin  Password: Admin@123");
            }
            out.println("IMPORTANT: Remove /setup-admin servlet in production!");
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace(out);
        }
    }
}
