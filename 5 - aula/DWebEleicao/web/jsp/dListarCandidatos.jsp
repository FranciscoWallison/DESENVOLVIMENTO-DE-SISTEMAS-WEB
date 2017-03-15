<%-- 
    Document   : dListarCandidatos
    Created on : 15/03/2017, 19:53:16
    Author     : Estácio
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List dLista = (List)request.getAttribute("dLista");
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
                for(DCandidato candidato:dlista){
                
            %>
                
            <tr>
                <td>
                    <%= candidato.getName() %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
