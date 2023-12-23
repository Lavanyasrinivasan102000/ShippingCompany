<%@page import="com.cester.dao.ClientDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
<%@ page import="com.cester.model.Client, com.cester.dao.ClientDAO" %>
<% ClientDAO clientDAO = new ClientDAO(); %>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="px-4 w-100">
<h3 class="text-success">Clients List</h3>
    <table class="table table-bordered">
    
         <thead class="thead-dark">
    		<tr>
            <th>Client ID</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Item Shipped</th>
            <th>Date Received</th>
            <th>Date Shipped</th>
            <th colspan="2">Action </th>

            </tr>
        </thead>
        <tbody>
        
        <% List<Client> clients = clientDAO.getAllClients();
           for (Client client : clients) { %>
        <tr>
            <!-- Display client details in table -->
               <form action="UpdateClientServlet" class="m-0" method="post">
            <td><input name="clientID"  value="<%= client.getClientID() %>" class="form-control form-control-sm" disabled required></td>
            
            <td><input name="name" value="<%= client.getName() %>" required class="form-control form-control-sm"></td>
            <td><input name="contact" value="<%= client.getContact() %>" required class="form-control form-control-sm"></td>
            <td><input name="itemShipped" value="<%= client.getItemShipped() %>" required class="form-control form-control-sm"></td>
            <td><input name="dateReceived" type="date" value="<%= client.getDateReceived() %>" required class="form-control form-control-sm"></td>
            <td><input name="dateShipped" type="date" value="<%= client.getDateShipped() %>" required class="form-control form-control-sm"></td>
             <input type="hidden" name="clientID" value="<%= client.getClientID() %>">
            <td> <button type="submit" class="btn btn-sm btn-primary">Update</button> </td>
            </form>
            <td>
                <form action="DeleteClientServlet" method="post" class="m-0">
                    <input type="hidden" name="clientID" value="<%= client.getClientID() %>">
                    <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                </form>
                </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <h3 class="text-warning">Add Client Form</h3>
       <form  action="AddClientServlet" class="p-3 rounded bg-light shadow-sm" method="post">                         
  <div class="form-row row">
    <div class="form-group col-md-4">
      <label for="clientID">Client ID</label>
      <input name="clientID" class="form-control form-control-sm" id="clientID"required placeholder="Enter Client ID">
    </div>
    <div class="form-group col-md-4">
      <label for="name">Client Name</label>
      <input class="form-control form-control-sm" name="name" id="name" required placeholder="Enter Client Name">
    </div>
  	<div class="form-group col-md-4">
      <label for="contact">Client Contact</label>
      <input name="contact" id="contact" required placeholder="Enter Client Contact" class="form-control form-control-sm" required>
  </div>
  </div> 
  <div class="form-row row mt-3">
     <div class="form-group col-md-4">
    <label for="is">Item Shipped</label>
   <input name="itemShipped" id="is" required placeholder="Enter Item Shipped" class="form-control form-control-sm" required>
  </div>
  <div class="form-group col-md-4">
    <label for="isd">Item Shipped Date</label>
     <input name="dateShipped" id="isd" type="date"  required placeholder="Enter Item Shipped Date" class="form-control form-control-sm" required>
  </div>
  <div class="form-group col-md-4">
    <label for="ird">Item Received Date</label>
    <input name="dateReceived" id="ird" type="date" required placeholder="Enter Item Received Date" class="form-control form-control-sm" required>
  </div>
  <div class="row mt-3 mx-0  justify-content-center">
   <input type="submit" class="col-4 btn btn-sm btn-success" value="Add Client to List">
  </div>
      </div>
  </div>
  
</form>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>
