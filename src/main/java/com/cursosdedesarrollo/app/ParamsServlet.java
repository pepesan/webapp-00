package com.cursosdedesarrollo.app;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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

    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        handleRequest(req, res);
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        handleRequest(req, res);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();
        res.setContentType("text/plain;charset=UTF-8");
        String contextPath = req.getContextPath();
        out.write("ContextPath= "+contextPath + "\n");
        String servletPath = req.getServletPath();
        out.write("ServletPath= "+servletPath + "\n");
        String method = req.getMethod();
        out.write("method= "+method + "\n");
        String queryString = req.getQueryString();
        out.write("QueryString= "+queryString + "\n");
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
            out.write("Parameter " + paramName + " not found \n");
        }

        Map<String,String[]> parameterMap = req.getParameterMap();
        out.write("Parameter List\n");

        parameterMap.forEach(
                (k,v) ->
            {
                System.out.println("Clave: " + k);
                System.out.println("Valor: " + v[0]);
                String s = k + " = " + v[0] + "\n";
                out.write(s);
            });

        out.close();

    }
}

