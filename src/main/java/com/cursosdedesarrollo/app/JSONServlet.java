package com.cursosdedesarrollo.app;

import com.cursosdedesarrollo.app.dtos.Data;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(
        name = "JSONServlet",
        urlPatterns = {"/json"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class JSONServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Obtener el cuerpo de la solicitud HTTP
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while (( line= reader.readLine()) != null) {
            sb.append(line);
        }
        String datosJSON = sb.toString();
        // Convertir los datos JSON en un objeto Java
        Data datos = new ObjectMapper().readValue(datosJSON, Data.class);

        // Acceder a los datos del objeto Java y procesarlos según sea necesario
        String nombre = datos.getNombre();
        Integer edad = datos.getEdad();
        request.setAttribute("nombre", nombre);
        request.setAttribute("edad", edad);
        request.getRequestDispatcher("/WEB-INF/json.jsp")
                .forward(request, response);
    }
}

