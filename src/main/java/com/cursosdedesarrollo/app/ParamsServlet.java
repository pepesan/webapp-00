package com.cursosdedesarrollo.app;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ParamsServlet",
        urlPatterns = {"/params"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class ParamsServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        handleRequest(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        handleRequest(req, res);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/plain;charset=UTF-8");

        String paramName = "myparam";
        String paramValue = req.getParameter(paramName);
        if(paramValue==null){
            paramValue = "null";
        }
        out.write(paramName);
        out.write(" = ");
        out.write(paramValue);
        out.write("\n");

        paramName = "UNKNOWN";
        paramValue = req.getParameter(paramName);

        if (paramValue==null) {
            out.write("Parameter " + paramName + " not found");
        }

        out.close();

    }
}

