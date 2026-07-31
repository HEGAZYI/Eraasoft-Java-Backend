package com.item.controller;

import java.io.IOException;
import java.util.Objects;

import javax.sql.DataSource;

import com.item.model.User;
import com.item.service.UserService;
import com.item.service.impl.UserServiceImpl;
import com.item.util.PasswordUtil;
import com.item.util.ValidationUtil;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int COOKIE_MAX_AGE = 7 * 24 * 60 * 60; // 7 days

    @Resource(name = "jdbc/item")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = "loginPage";
        }
        switch (action) {
            case "logout":
                logout(request, response);
                break;
            case "deleteAccount":
                deleteAccount(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "signup":
                signup(request, response);
                break;
            case "forgotPassword":
                forgotPassword(request, response);
                break;
            case "deleteAccount":
                deleteAccount(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String usernameOrEmail = trim(request.getParameter("username"));
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        if (ValidationUtil.isBlank(usernameOrEmail) || ValidationUtil.isBlank(password)) {
            request.setAttribute("error", "Username/email and password are required.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        UserService userService = new UserServiceImpl(dataSource);
        User user = userService.login(usernameOrEmail, password);

        if (user == null) {
            request.setAttribute("error", "Invalid username/email or password.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());

        if ("on".equalsIgnoreCase(remember) || "true".equalsIgnoreCase(remember)) {
            Cookie cookie = new Cookie("rememberMe", user.getUsername());
            cookie.setMaxAge(COOKIE_MAX_AGE);
            cookie.setHttpOnly(true);
            cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
            response.addCookie(cookie);
        }

        response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
    }

    private void signup(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = trim(request.getParameter("username"));
        String email = trim(request.getParameter("email"));
        String fullName = trim(request.getParameter("fullName"));
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");

        if (!ValidationUtil.isValidUsername(username)) {
            request.setAttribute("error", "Username must be 3-50 characters (letters, numbers, underscore).");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (!ValidationUtil.isValidEmail(email)) {
            request.setAttribute("error", "Please enter a valid email address.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (!ValidationUtil.isValidPassword(password)) {
            request.setAttribute("error", "Password must be at least 6 characters.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (!password.equals(confirm)) {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        UserService userService = new UserServiceImpl(dataSource);
        if (userService.findByUsername(username) != null) {
            request.setAttribute("error", "Username already taken.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (userService.findByEmail(email) != null) {
            request.setAttribute("error", "Email already registered.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        User user = new User(username, email, PasswordUtil.hash(password), fullName);
        boolean ok = userService.register(user);
        if (!ok) {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        // auto-login after signup
        User logged = userService.login(username, password);
        if (logged != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", logged);
            session.setAttribute("userId", logged.getId());
            session.setAttribute("username", logged.getUsername());
        }
        response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
    }

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String email = trim(request.getParameter("email"));
        String newPassword = request.getParameter("newPassword");
        String confirm = request.getParameter("confirmPassword");

        if (!ValidationUtil.isValidEmail(email)) {
            request.setAttribute("error", "Please enter a valid email.");
            request.getRequestDispatcher("/forgot-password.jsp").forward(request, response);
            return;
        }
        if (!ValidationUtil.isValidPassword(newPassword) || !newPassword.equals(confirm)) {
            request.setAttribute("error", "Password must be at least 6 characters and match confirmation.");
            request.getRequestDispatcher("/forgot-password.jsp").forward(request, response);
            return;
        }

        UserService userService = new UserServiceImpl(dataSource);
        User user = userService.findByEmail(email);
        if (user == null) {
            // do not reveal whether email exists
            request.setAttribute("success", "If the email exists, the password has been reset.");
            request.getRequestDispatcher("/forgot-password.jsp").forward(request, response);
            return;
        }

        boolean ok = userService.updatePassword(user.getId(), PasswordUtil.hash(newPassword));
        if (ok) {
            request.setAttribute("success", "Password updated successfully. You can now login.");
        } else {
            request.setAttribute("error", "Failed to update password. Please try again.");
        }
        request.getRequestDispatcher("/forgot-password.jsp").forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // clear remember-me cookie
        Cookie cookie = new Cookie("rememberMe", "");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        Long userId = (Long) session.getAttribute("userId");
        UserService userService = new UserServiceImpl(dataSource);
        boolean ok = userService.deleteAccount(userId);

        session.invalidate();
        Cookie cookie = new Cookie("rememberMe", "");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
        response.addCookie(cookie);

        if (ok) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?msg=accountDeleted");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp?msg=Failed+to+delete+account");
        }
    }

    private static String trim(String s) {
        return s == null ? null : s.trim();
    }
}
