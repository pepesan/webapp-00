package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
        name = "FormServlet",
        urlPatterns = {"/form"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processForm(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processForm(request, response);
    }

    private void processForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Enumeration<String> parametros = request.getParameterNames();
        System.out.println(parametros.hasMoreElements());
        while (parametros.hasMoreElements()) {
            String paramName = parametros.nextElement();
            System.out.println("parametro: " + paramName);
            // Obtener el valor de cada parámetro
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];

                // Procesar el valor del parámetro como sea necesario
                // Por ejemplo, imprimir el nombre y el valor del parámetro
                System.out.println(paramName + " = " + paramValue);
            }
        }
        String texto = request.getParameter("texto");
        System.out.println("Parameretro recibido: " +texto);
        if (texto !=null && texto.length() > 0)
            request.setAttribute("texto", texto);
        else {
            request.setAttribute("texto", "");
        }

        request.getRequestDispatcher("/WEB-INF/form.jsp")
                .forward(request, response);
    }
}

