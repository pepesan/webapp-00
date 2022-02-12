package com.cursosdedesarrollo.app;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(
        name = "JServstllet",
        urlPatterns = {"/jstl"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String datos = "Algunos datos";
        request.setAttribute("data", datos);
        Boolean bool = true;
        request.setAttribute("bool", bool);
        List<String> listado = new LinkedList<>();
        listado.add("Hola");
        listado.add("Mundo");
        request.setAttribute("list", listado);
        request.getRequestDispatcher("/WEB-INF/jstl.jsp").forward(request, response);
    }
}
