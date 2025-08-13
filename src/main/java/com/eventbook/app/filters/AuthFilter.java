package com.eventbook.app.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String ctx = req.getContextPath();
        String uri = req.getRequestURI().substring(ctx.length());

        boolean isStatic = uri.startsWith("/resources/") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg");
        boolean isPublic = uri.equals("/login") || uri.equals("/login.jsp") || uri.equals("/register") || uri.equals("/register.jsp") || uri.equals("/auth/logout") || isStatic;

        if (isPublic) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = req.getSession(false);
        boolean auth = session != null && Boolean.TRUE.equals(session.getAttribute("auth"));

        if ((uri.equals("/events") || uri.startsWith("/admin/")) && !auth) {
            resp.sendRedirect(ctx + "/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
