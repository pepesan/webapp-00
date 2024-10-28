package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "HtmlServlet",
        urlPatterns = {"/html"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class HtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.handleRequest(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.handleRequest(request, response);
    }

    @Override
    protected  void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.handleRequest(request, response);
    }

    @Override
    protected  void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        this.handleRequest(request, response);
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Objeto HttpServletRequest
        System.out.println("Request URL: "+request.getRequestURL());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Method : "+request.getMethod());
        System.out.println("User Agent: "+request.getHeader("User-Agent"));

        // Objeto HttpServletResponse
        // Definir el tipo de salida
        response.setContentType("text/html;charset=UTF-8");
        // Definir el procesador de la salida
        ServletOutputStream out = response.getOutputStream();
        // Imprimir datos en la salida HTML
        out.print("<html>" +
                "<head><title>Pagina Servlet</title></head>"+
                "<body><h2>" +
                "Pagina generada desde Un Servlet"+
                "</h2></body>"+
                "</html>");
        // Cerrar la salida
        out.close();
    }
}
