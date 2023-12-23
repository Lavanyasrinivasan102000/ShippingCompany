package com.cester.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.cester.dao.ClientDAO;
import java.io.IOException;
@WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientID = Integer.parseInt(request.getParameter("clientID"));

        ClientDAO clientDAO = new ClientDAO();
        clientDAO.deleteClient(clientID);

        response.sendRedirect("index.jsp");
    }
}
