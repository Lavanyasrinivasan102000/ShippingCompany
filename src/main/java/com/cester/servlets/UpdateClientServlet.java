package com.cester.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.cester.dao.ClientDAO;
import com.cester.model.Client;
import java.io.IOException;

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientID = Integer.parseInt(request.getParameter("clientID"));
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String itemShipped = request.getParameter("itemShipped");
        String dateReceived = request.getParameter("dateReceived");
        String dateShipped = request.getParameter("dateShipped");

        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        client.setClientID(clientID);
        client.setName(name);
        client.setContact(contact);
        client.setItemShipped(itemShipped);
        client.setDateReceived(dateReceived);
        client.setDateShipped(dateShipped);

        clientDAO.updateClient(client);

        response.sendRedirect("index.jsp");
    }
}
