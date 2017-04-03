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

<!DOCTYPE html>
<html>
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
                <a class="nav-link active" href="index">Home</a>
                <a class="nav-link" href="#">Login</a>
                <a class="nav-link" href="#">Register</a>
                <a class="nav-link" href="aListarCandidatos" >Candidatos</a>
              </nav>
            </div>
          </div>
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
          <div class="mastfoot">
            <div class="inner">
              <p>© Equipe <a href="http://github.com/franciscowallison">Francisco Wallison</a>, 2017</p>
            </div>
          </div>

        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="assets/js/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>


