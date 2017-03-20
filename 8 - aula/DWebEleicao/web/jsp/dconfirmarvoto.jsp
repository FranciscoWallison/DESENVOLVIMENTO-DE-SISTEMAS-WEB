<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 String nomeCandidato = (String)request.getAttribute("nomeCandidato");
%>       

<!DOCTYPE html>
<html>
<head>
<title>JSP DConfirmarVoto</title>
</head>
<body>
<div style="margin: auto; text-align: center;" >
<h1>Confirme seu voto: </h1><br>
<h2><%= nomeCandidato %> </h2>
<form method="post" >
<input type="submit" value='Confirmar' /><br><br>
<input type="submit" value='Voltar' /><br><br>
</form></div>
</body>
</html>
