<%@page language="java" session="true" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Sistema de Eleicao</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/cover.css" rel="stylesheet">
      
    <!-- FONT AWESOME -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    
    <link href="assets/css/style.css" rel="stylesheet">
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand logo">Vot</h3>
              <nav class="nav nav-masthead">
                <a class="nav-link" href="/deleicao/">Home</a>
                <% if(session.getAttribute( "email" ) != null  ){%>
                    <a class="nav-link" href="AcriarCandidato">Register Candidato</a>
                    <a class="nav-link" href="aListarCandidatos" >Candidatos</a>
                <% }else{ %>               
                    <a  href=""class="nav-link" data-toggle="modal" data-target="#myModalLogin">
                        <i class="fa fa-user"></i>
                        Login
                    </a>
                 <% } %>
              </nav>
            </div>
          </div>
            
            
<!-- Modal Loogin -->
<div class="modal fade" id="myModalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"> <i class="fa fa-user"></i>Login</h4>
      </div>
            <form action="aLogin" method="POST"><!-- FORM -->
        <div class="modal-body">
          <div class="form-group">
            <div class="input-group">
              <span class="input-group-addon" id="email-ico"><span class="fa fa-envelope" aria-hidden=true></span></span>
              <input name="aEmail" type="email" class="form-control" placeholder="Email" id="recipient-name" aria-describedby="email-ico">
            </div>
          </div>
          <div class="form-group">
            <div class="input-group">
              <span class="input-group-addon" id="senha-ico"><span class="fa fa-pencil" aria-hidden=true></span></span>
              <input type="password" name="aPassword" class="form-control" placeholder="Senha" id="recipient-name" aria-describedby="senha-ico">
            </div>
          </div>
      </div>
      <div class="modal-footer">
        <input type="submit" class="btn btn-primary" value="Fazer Login">
      </div>
    </form><!-- END FORM -->
    </div>
  </div>
</div>
<!-- End Modal Loogin -->