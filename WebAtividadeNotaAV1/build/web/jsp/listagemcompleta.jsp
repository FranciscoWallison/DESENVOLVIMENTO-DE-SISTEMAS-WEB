<%@page import="br.estacio.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Alunos</title>
        <style>
            table { border-collapse: collapse; align-self: center; }
            table, td { border: 1px solid black; padding: 10px; }
        </style>
    </head>
    <body>
        <h1>Listagem Completa</h1>
        <br>
        <table>
            <tr>
                <td><strong>Nome</strong></td>
                <td><strong>Matrícula</strong></td>
            </tr>
            
            <%
                List<Aluno> listaAlunos = (List)request.getAttribute("listaAlunos");
                for (Aluno aluno : listaAlunos ) {                   
            %>            
            <tr>
                <td><%= aluno.getNome() %></td>
                <td><%= aluno.getMatricula() %></td>
            </tr>
            <% } %>            
        </table>       
    </body>
</html>
