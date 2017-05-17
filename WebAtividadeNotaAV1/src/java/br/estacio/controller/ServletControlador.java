package br.estacio.controller;

import br.estacio.model.Aluno;
import br.estacio.model.Usuario;
import br.estacio.model.dao.FactoryDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FactoryDAO factory = FactoryDAO.getInstance(FactoryDAO.Persistencia.JSON);
        HttpSession session = request.getSession();
        
        String url = request.getRequestURI();

        if (url.contains("acesso.fic")) {
            if (request.getMethod().equals("POST")) {
                String matricula = request.getParameter("matricula");
                String senha = request.getParameter("senha");

                Usuario usuario = factory.getUsuarioDAO().login(matricula, senha);

                if (usuario != null) {
                    session.setAttribute("usuario", usuario);
                    session.setMaxInactiveInterval(10000);
                    request.getRequestDispatcher("pesquisa.jsp").forward(request, response);
                    return;
                }
            }
            response.sendRedirect("index.jsp");
            return;
        }
        
        /* O controle de Sessao foi desabilitado para a atividade
        // Todas as demais requisições devem passar por controle de sessão!!!
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
            
        }
        */
        
        if (url.contains("matricula.fic")) {
            String matricula = request.getParameter("matricula");
            Aluno aluno = factory.getAlunoDAO().getAlunoPorMatricula(new Long(matricula));

            request.setAttribute("aluno", aluno);

            request.getRequestDispatcher("/jsp/pesquisamatricula.jsp").forward(request, response);
        }

        if (url.contains("nome.fic")) {
            String nome = request.getParameter("nome");
            List<Aluno> lista;
            lista = factory.getAlunoDAO().getAlunosPorNome(nome);

            request.setAttribute("listaAlunos", lista);

            request.getRequestDispatcher("/jsp/listagempornome.jsp").forward(request, response);
        }
        
        
        if (url.contains("lista.fic")) {
            List<Aluno> lista;
            lista = factory.getAlunoDAO().getTodosAlunos();

            request.setAttribute("listaAlunos", lista);

            request.getRequestDispatcher("/jsp/listagemcompleta.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
