package com.eventbook.app.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import com.eventbook.app.repositories.EventRepository;

@WebServlet("/events")
public class EventsServlet extends HttpServlet {
    private final EventRepository repo = new EventRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("events", repo.findAll());
        req.getRequestDispatcher("/events.jsp").forward(req, resp);
    }
}
