package com.eventbook.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException; // <— punto, no espacio
import com.eventbook.app.repositories.UserRepository;
import com.eventbook.app.models.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserRepository userRepo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (role == null || role.isBlank()) role = "USER";

        User u = new User(0, name, email, password, role);
        userRepo.save(u);

        resp.sendRedirect(req.getContextPath() + "/login.jsp?reg=1");
    }
}
