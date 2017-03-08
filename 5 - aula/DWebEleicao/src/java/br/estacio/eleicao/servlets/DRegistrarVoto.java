package br.estacio.eleicao.servlets;

import br.estacio.eleicao.modelo.DCandidato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class DRegistrarVoto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("erro.html");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String voto = request.getParameter("dvoto");
        String nomeCandidato = DCandidato.getCandidato(Integer.parseInt(voto));
       
        request.setAttribute("nomeCandidato", nomeCandidato);
        
        RequestDispatcher rd = request.getRequestDispatcher("/dConfirmarVoto");
        rd.forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
