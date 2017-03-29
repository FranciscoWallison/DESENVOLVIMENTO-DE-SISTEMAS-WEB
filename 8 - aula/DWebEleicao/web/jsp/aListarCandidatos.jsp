<%@page import="br.estacio.eleicao.modelo.ACandidato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<ACandidato> ALista = (List)request.getAttribute("Lista");
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table>
          <% 
              for (ACandidato candidato:ALista) {
           %>    
           <tr>
               <td><%= candidato.getNome() %></td>
               <td><%= candidato.getId() %></td>
           </tr>
           <% } %>
          
       </table>
    </body>
</html>
