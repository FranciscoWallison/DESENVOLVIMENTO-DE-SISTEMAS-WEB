<%@page import="br.estacio.eleicao.modelo.DCandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 DCandidato candidato = (DCandidato)request.getAttribute("candidato");
 String nomeCandidato = null;

 if (candidato != null) {
     nomeCandidato = candidato.getNome();
 } else {
     nomeCandidato = "Candidato nao encontrado!";
 }
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
<form method="post" action="dConfirmarVoto" >
    <input type="hidden" name="numero" value="<%= candidato.getNumero()  %>">  
  <input type="submit" value='Confirmar' /><br><br>
</form>
<form>
<input type="submit" value='Voltar' /><br><br>
</form></div>
</body>
</html>
