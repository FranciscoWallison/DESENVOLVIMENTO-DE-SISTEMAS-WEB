package br.estacio.eleicao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DCandidato {

    private String nome;
    private int numero;

    public DCandidato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static DCandidato getCandidato(int numero) throws SQLException {

        Connection c = null;
        DCandidato candidato = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/sample","usuario", "senha");
            c.setAutoCommit(true);
            c.setSchema("APP");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "select nome from t_candidato where numero = " + numero;
            ResultSet res = trans.executeQuery(query);

            if (res.next()) {
              candidato = new DCandidato(res.getString("nome"),numero);                
            } 
            res.close();
            c.close();
        }
        return candidato;
    }

     public static boolean registrarVoto(int numero) throws SQLException {

        Connection c = null;
        boolean retorno = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/eleicao", "usuario", "senha");
            c.setAutoCommit(true);
            c.setSchema("APP");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "update t_candidato set votos = votos + 1 where numero = " + numero;
            if (trans.executeUpdate(query) == 1) retorno = true;
            c.close();
        }
        return retorno;
    }
    
    
    
    public static List getCandidatos() {

        List lista = new ArrayList();
        for (int i = 0; i < 10; i++) {
            DCandidato dCandidato = new DCandidato("Candidato" + Integer.toString(i), i);
            lista.add(dCandidato);
        }
        return lista;
    }

}
