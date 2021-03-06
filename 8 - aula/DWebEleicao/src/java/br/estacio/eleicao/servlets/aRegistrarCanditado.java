package br.estacio.eleicao.servlets;

import br.estacio.eleicao.modelo.ACandidato;
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
public class aRegistrarCanditado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("erro.html");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try {
            String anome = request.getParameter("anome");
            String aid = request.getParameter("aid");
            boolean creat =  ACandidato.registrarCandidato(Integer.parseInt(aid), anome);
            if(creat){
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/aConfirmarCadastro.jsp");
                 rd.forward(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/aErroCadastro.jsp");
                 rd.forward(request, response);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ARegistrarVoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
