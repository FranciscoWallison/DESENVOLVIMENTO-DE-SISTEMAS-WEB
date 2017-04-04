<%@ include file="/layout/cabecalho.jsp"%>
          <div class="inner cover">
            <h1 class="cover-heading">Criar Candidato!</h1>
            <!-- <p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an u.</p> -->
            <p class="lead">
                <form method="post" action="aRegistrarCanditado">
                    <input name="anome" class="btn btn-secondary" placeholder="Nome" type="text" /><br><br>
                    <input name="aid" class="btn  btn-secondary" placeholder="Numero" type="text" /><br><br>
                    <input type="submit" class="btn btn-lg btn-secondary" value="Votar">
                 </form>
            </p>
          </div>
<%@ include file="/layout/cabecalho.jsp"%>
