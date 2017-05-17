<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
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
            <c:forEach var="aluno" items="${listaAlunos}" >
            <tr>
                <td>${aluno.nome}</td>
                <c:set var="color" value="green" />
                <c:if test="${aluno.matricula < '201400000000'}">
                    <c:set var="color" value="yellow" />
                </c:if>
                <c:out escapeXml="false" value="<td><font color='${color}'>${aluno.matricula}</font></td>" /></td>
            </tr>
            </c:forEach>        
        </table>       
    </body>
</html>

