<%-- 
    Document   : DRegistrarVoto
    Created on : 15/03/2017, 18:40:42
    Author     : Estácio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    String nomeCandidato = (String)request.getAttribute("nomeCandidato");
%>

<!DOCTYPE html>
<html>
<head>

    <title>JSP Comfirma VOTO</title>
</head>
<body>

    <div style="margin: auto; text-align: center;" >

        <h1>Confirme seu voto</h1><br>
        
        <h2><%= nomeCandidato %></h2>

        <form method="post" >
            <input type="submit" value='Confirmar' /><br><br>
            <input type="submit" value='Voltar' /><br><br>
        </form>
    </div>
</body>
</html>

