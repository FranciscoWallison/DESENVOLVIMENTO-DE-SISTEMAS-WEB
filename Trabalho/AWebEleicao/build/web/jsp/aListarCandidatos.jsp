
<%@page import="br.estacio.eleicao.modelo.ACandidato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<ACandidato> ALista = (List)request.getAttribute("ALista");
    
%>
<%@ include file="/layout/cabecalho.jsp"%>
          <div class="inner cover">                
                <table class="table">
                    <thead>
                        <tr>
                            <th>Numero</th>
                            <th>Name</th>
                            <th>Foto</th>
                            <th>Votos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            for (ACandidato candidato:ALista) {
                        %>    
                        <tr>
                            <th scope="row"><%= candidato.getId() %></th>
                            <td><%= candidato.getNome() %></td>
                            <td><%= candidato.getAvatar() %></td>
                            <td><%= candidato.getVot() %></td>
                        </tr>
                        
                         <% } %>
                    </tbody>
                   
                </table>
                    
          </div>
<%@ include file="/layout/rodape.jsp"%>