<%@page import="br.estacio.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Consulta Alunos</title>
    </head>
     <body>
        <div>Sistema de Consulta de Alunos</div>
        <p>Bem vindo: <%=((Usuario)session.getAttribute("usuario")).getNome()  %></p>
        <br>
        <h3>Consulta por Matricula</h3>
        <small>Deve inserir a matrícula exata, retorna apenas 1(um) aluno</small>
        <form action="matricula.fic" >
            Matrícula: <input type="number" name="matricula" />
            <input type="submit" value="Consulta por Matricula" />
        </form>
        <br><br>
        <h3>Consulta por Nome</h3>
        <small>Retorna uma listagem que coincide com o parâmetro de busca</small>
        <form action="nome.fic" >
            Nome: <input type="text" name="nome" />
            <input type="submit" value="Obter Alunos por Nome" />
        </form>
        <br><br>
        <h3>Lista completa</h3>
        <small>Retorna uma listagem com todos os alunos</small>
        <form action="lista.fic" >
            <input type="submit" value="Obter lista Completa!" />
        </form>
        <br><br>
        <!--
        <h3>Entretenimento</h3>
        Teste se uma palavra é "arretada" (invenção do professor) <br>
          Palavra: <input type="text" name="arretada" onblur="isArretada(this.value);" />            
        -->          
    </body>
</html>
