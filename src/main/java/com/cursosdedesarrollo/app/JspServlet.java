package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "JspServlet",
        urlPatterns = {"/jsp"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Object datos = "Algunos datos";
        Integer numero = 12;
        request.setAttribute("data", datos);
        request.setAttribute("numero", numero);
        request.getRequestDispatcher("/WEB-INF/page.jsp")
                .forward(request, response);
    }
}

