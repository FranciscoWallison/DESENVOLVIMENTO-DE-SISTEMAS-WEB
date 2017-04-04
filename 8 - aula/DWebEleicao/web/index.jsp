<%@ include file="/layout/cabecalho.jsp"%>
          <div class="inner cover">
            <h1 class="cover-heading">Qual o seu voto?</h1>
            <!-- <p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an u.</p> -->
            <p class="lead">
                <form method="post" action="aRegistrarVoto">
                    <input name="dvoto" class="btn btn-lg vote btn-secondary" type="number" />
                     <input type="submit" class="btn btn-lg vote btn-secondary" value="Votar">
                 </form>
            </p>
          </div>
<%@ include file="/layout/rodape.jsp"%>