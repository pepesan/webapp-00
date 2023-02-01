package com.cursosdedesarrollo.app;

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

        response.setContentType("text/plain;charset=UTF-8");

        ServletOutputStream out = response.getOutputStream();

        out.print("Hello there from Servlet");
    }
}
