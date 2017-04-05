/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.eleicao.servlets;

import br.estacio.eleicao.modelo.ACandidato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
public class AConfirmarVoto extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int numero = Integer.parseInt(request.getParameter("numero"));
            ACandidato.registrarVoto(numero);
            response.sendRedirect("aVotoConfirmado.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(AConfirmarVoto.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
