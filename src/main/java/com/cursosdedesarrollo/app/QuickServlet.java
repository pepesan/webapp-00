package com.cursosdedesarrollo.app;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
