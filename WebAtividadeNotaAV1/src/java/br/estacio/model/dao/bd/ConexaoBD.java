package br.estacio.model.dao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    class ConexaoBD {
    
    private static Connection con = null;
          
    static Connection getConnection() throws SQLException  {
        if (con == null || con.isClosed()) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/alunos","aluno","aluno");
                con.setAutoCommit(true);
                PreparedStatement ps1 = con.prepareStatement("set schema app");
                ps1.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
               System.out.println(ex);
            }
        }
        return con;
    } 
    
}
