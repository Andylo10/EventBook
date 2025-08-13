package com.eventbook.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import com.eventbook.app.repositories.UserRepository;
import com.eventbook.app.models.User;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserRepository userRepo = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> userOpt = userRepo.findByEmail(email);
        String ctx = req.getContextPath();

        if (userOpt.isPresent() && password != null && password.equals(userOpt.get().getPassword())) {
            User user = userOpt.get();
            HttpSession s = req.getSession(true);
            s.setAttribute("auth", true);
            s.setAttribute("userEmail", user.getEmail());
            s.setAttribute("role", user.getRole());

            Cookie last = new Cookie("lastLogin", LocalDateTime.now().toString());
            last.setPath(ctx.isEmpty()? "/" : ctx);
            last.setMaxAge(60*60*24*30);
            resp.addCookie(last);

            resp.sendRedirect(ctx + "/events");
        } else {
            resp.sendRedirect(ctx + "/login.jsp?err=1");
        }
    }
}
