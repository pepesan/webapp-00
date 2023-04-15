package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(
        name = "ParametrosServlet",
        urlPatterns = {"/params3"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class ParametrosServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp);
    }

    protected void handleRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/plain;charset=UTF-8");
        out.write("Hola método: "+ req.getMethod()+"\n");
        String valor = req.getParameter("myparam");
        if (valor == null ){
            valor = "null";
        }
        out.write("Parámetro myparam: "+ valor+"\n");
        out.write("Listado de Parámetros \n");
        Map<String, String[]> parametros = req.getParameterMap();
        parametros.forEach((k,v)->{
            out.write(k+ " : "+ v[0]+ "\n");
        });
        out.close();

    }
}
