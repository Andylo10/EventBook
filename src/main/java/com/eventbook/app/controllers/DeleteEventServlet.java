package com.eventbook.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import com.eventbook.app.repositories.EventRepository;

@WebServlet("/admin/delete-event")
public class DeleteEventServlet extends HttpServlet {
    private final EventRepository repo = new EventRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            repo.deleteById(id);
        } catch(Exception ignored) {}
        resp.sendRedirect(req.getContextPath()+"/events");
    }
}
