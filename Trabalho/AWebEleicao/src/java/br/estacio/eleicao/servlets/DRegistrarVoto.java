package br.estacio.eleicao.servlets;

import br.estacio.eleicao.modelo.DCandidato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
      
        try {
            String voto = request.getParameter("dvoto");
            DCandidato cand = DCandidato.getCandidato(Integer.parseInt(voto));
            request.setAttribute("candidato", cand);
            
            RequestDispatcher rd = request.getRequestDispatcher("/dConfirmarVotoJSP");
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DRegistrarVoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}