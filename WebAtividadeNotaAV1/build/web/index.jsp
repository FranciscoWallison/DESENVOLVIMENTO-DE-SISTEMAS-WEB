<%-- 
    Document   : index
    Created on : Nov 5, 2016, 8:55:18 PM
    Author     : daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Sistema Consulta Alunos</title>
        <meta charset="UTF-8">
     
    </head>
    <body>
        <h3>Acesso restrito a colaboradores e alunos da Estacio</h3>
        <br>
        <div>Entre com sua matricula e senha para validar o acesso</div>
        <form action="acesso.fic" name="txtForm" method="post" onsubmit="return validaSenha();" >
            
            <p>Matricula: <input type="number" name="matricula" value="14012788" /></p>
            <p>Senha: <input type="password" name="senha" /></p>
            <p><input type="submit" value="Enviar"/></p>
        </form>
        <br>
          <script type="text/javascript">
     function validaSenha(){
         console.log('oi');
     // Guarda o valor do campo NOME na variável nome.
     var nome = document.txtForm.senha.value;
     if(isNaN(nome))
        window.alert("A senha deve ser numérica!");
    
     }
</script>
    </body>
</html>