package com.cursosdedesarrollo.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        loadOnStartup = 1,
        urlPatterns = "/jsp2",
        name = "EjemploJspServlet"
)
public class EjemploJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cadena = "valor inicial";
        req.setAttribute("cadena", cadena);
        req.getRequestDispatcher("/WEB-INF/page2.jsp").forward(req,resp);
    }
}
