<%@page import="br.estacio.eleicao.modelo.DCandidato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<DCandidato> dLista = (List)request.getAttribute("dLista");
    
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
              for (DCandidato candidato:dLista) {
           %>    
           <tr>
               <td><%= candidato.getNome() %></td>
               <td><%= candidato.getNumero() %></td>
           </tr>
           <% } %>
          
       </table>
    </body>
</html>
