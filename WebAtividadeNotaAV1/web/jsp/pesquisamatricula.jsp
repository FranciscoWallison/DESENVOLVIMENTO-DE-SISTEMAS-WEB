<%@page import="br.estacio.model.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Matricula</title>
    </head>
    <body>
        <div><strong>Matrícula Consultada: <%= request.getParameter("matricula")%> </strong></div>
        <br>
        <%
            Aluno aluno = (Aluno) request.getAttribute("aluno");
            if (aluno == null) {
        %>
            <div>Matrícula não encontrada no sistema!</div>
        <%
            } else {
        %>
        <ul>
            <li>Aluno: <%=aluno.getNome() %> </li>
            <li>Matricula: <%= aluno.getMatricula() %> </li>
        </ul>
        <% } %>
    </body>
</html>
