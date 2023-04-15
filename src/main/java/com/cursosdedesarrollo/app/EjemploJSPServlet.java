package com.cursosdedesarrollo.app;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        loadOnStartup = 1,
        urlPatterns = "/jsp2",
        name = "EjemploJspServlet"
)
public class EjemploJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {
        String cadena = "valor inicial";
        req.setAttribute("cadena", cadena);
        req.getRequestDispatcher("/WEB-INF/page2.jsp").forward(req,resp);
    }
}
