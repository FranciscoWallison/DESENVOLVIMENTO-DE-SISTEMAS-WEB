<%@ include file="/layout/cabecalho.jsp"%>
          <div class="inner cover">
            <h1 class="cover-heading">Esse candidato já foi cadastrado!</h1>
            <!-- <p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an u.</p> -->
            <p class="lead">
                <form action="/deleicao/AcriarCandidato" >
                    <input type="submit" class="btn btn-lg btn-sm"  value='Voltar' /><br><br>
                </form>
            </p>
          </div>
<%@ include file="/layout/rodape.jsp"%>