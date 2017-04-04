<%@page import="br.estacio.eleicao.modelo.ACandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 ACandidato candidato = (ACandidato)request.getAttribute("candidato");
 String nomeCandidato = null;

 if (candidato != null) {
     nomeCandidato = candidato.getNome();
     nomeCandidato = candidato.getNome();
 } else {
     nomeCandidato = "Candidato nao encontrado!";
 }
%>       
<%@ include file="/layout/cabecalho.jsp"%>
         <% if(candidato.getId() != 0 ){ %>
          <div class="inner cover">
            <h1 class="cover-heading"><%= nomeCandidato %></h1>
            <img class="rounded-circle" src="img/<%= candidato.getAvatar()  %>" alt="Generic placeholder image" width="140" height="140">
            <p class="lead cover-heading">Confirme seu voto:</p>
            
            <p class="lead">
                <form method="post" action="aConfirmarVoto" >
                    <input type="hidden" name="numero" class="btn btn-lg vote btn-secondary" value="<%= candidato.getId()  %>">  
                    <input type="submit" class="btn btn-lg vote btn-secondary" value='Confirmar' /><br><br>
                </form>
                <form method="post" action="/deleicao/" >
                    <input type="submit" class="btn btn-lg btn-sm"  value='Voltar' /><br><br>
                </form>
            </p>
          </div>
           <% }else{ %>
            <div class="inner cover">
            <h1 class="cover-heading">Candidato inexistente!</h1>
            <!-- <p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an u.</p> -->
            <p class="lead">
                <form action="/deleicao/" >
                    <input type="submit" class="btn btn-lg btn-sm"  value='Voltar' /><br><br>
                </form>
            </p>
          </div>
           <% } %>
<%@ include file="/layout/rodape.jsp"%>