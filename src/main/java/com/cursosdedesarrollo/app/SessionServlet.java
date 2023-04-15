package com.cursosdedesarrollo.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(
        name = "SessionServlet",
        urlPatterns = {"/session"},
        loadOnStartup = 1
//      , asyncSupported = false
)
public class SessionServlet extends HttpServlet {

    public List<String> listado = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        this.handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recuperando la sesión
        HttpSession session = request.getSession();
        Boolean activeSession = false;
        // compruebo si es una sesión nueva o antigua
        if(session.isNew()){
            System.out.println("nueva sesión");
            session.setAttribute("listado", new LinkedList<String>());
            System.out.println("listado inicializado");
        }else{
            System.out.println("sesión antigua");
            this.listado.add("uno");
        }
        this.listado=(List<String>)session.getAttribute("listado");
        activeSession = true;
        request.setAttribute("listado", this.listado);
        request.getRequestDispatcher("/WEB-INF/list.jsp")
                .forward(request, response);
    }
}
