package com.cursosdedesarrollo.app;

import com.cursosdedesarrollo.app.dtos.Data;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/hola")
public class EjemploServlet extends HttpServlet {
    // manage the get petition
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Definir el procesador de la salida
        ServletOutputStream out = response.getOutputStream();
        Data data = new Data();
        data.setNombre("Juan");
        data.setEdad(23);
        System.out.println(data);
        // Imprimir datos en la salida HTML
        out.print("<html>" +
                "<head><title>Pagina Servlet</title></head>"+
                "<body><h2>" +
                data +
                "</h2></body>"+
                "</html>");
        // Cerrar la salida
        out.close();
    }
}
