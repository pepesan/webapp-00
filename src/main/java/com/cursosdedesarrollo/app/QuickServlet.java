package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "QuickServlet",
        urlPatterns = {"/hello"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class QuickServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Objeto HttpServletRequest
        System.out.println("Request URL: "+request.getRequestURL());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Method : "+request.getMethod());
        System.out.println("Method : "+request.getHeader("User-Agent"));

        // Objeto HttpServletResponse
        // Definir el tipo de salida
        response.setContentType("text/plain;charset=UTF-8");
        // Definir el procesador de la salida
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida
        out.print("Hola desde el Servlet QuickServlet");
        // Cerrar la salida
        out.close();
    }
}
