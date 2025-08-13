package com.eventbook.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import com.eventbook.app.repositories.EventRepository;
import com.eventbook.app.models.Event;

@WebServlet("/admin/events")
public class AdminEventsServlet extends HttpServlet {
    private final EventRepository repo = new EventRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin-events.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dateStr = req.getParameter("date");
        String location = req.getParameter("location");

        boolean ok = name != null && !name.isBlank() && location != null && !location.isBlank();
        LocalDate date = null;
        try { date = LocalDate.parse(dateStr); } catch(Exception e) { ok = false; }

        if(!ok) {
            resp.sendRedirect(req.getContextPath()+"/admin-events.jsp?err=1");
            return;
        }

        repo.save(new Event(0, name, date, location));
        resp.sendRedirect(req.getContextPath()+"/events");
    }
}
