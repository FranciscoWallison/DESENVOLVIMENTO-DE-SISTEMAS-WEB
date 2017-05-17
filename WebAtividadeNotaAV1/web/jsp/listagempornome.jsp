<%@page import="br.estacio.model.Aluno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
               List listaAlunos = (List)request.getAttribute("listaAlunos");
 %>
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
        <h1>Listagem Por Nome</h1>
        <h3>parâmetro de consulta: <%= request.getParameter("nome") %></h3>
        <br>
        <table>
            <tr>
                <td><strong>Nome</strong></td>
                <td><strong>Matrícula</strong></td>
            </tr>
            
            <%
                for (int i = 0; i < listaAlunos.size(); i ++) {
                    Aluno aluno = (Aluno)listaAlunos.get(i);
              %>
            
            <tr>
                <td><%= aluno.getNome() %></td>
                <td><%= aluno.getMatricula() %></td>
            </tr>
            <% } %>            
        </table>  
        <script>
            alert('Quantidade de alunos  = ' +  <%=
                listaAlunos.size()
              %>)
            </script>
    </body>
</html>
