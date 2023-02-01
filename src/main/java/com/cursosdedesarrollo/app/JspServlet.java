package com.cursosdedesarrollo.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

