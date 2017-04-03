package br.estacio.eleicao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ACandidato {

    private String nome;
    private String avatar;
    private int id;

    public ACandidato(String nome, int id, String avatar) {
        this.nome = nome;
        this.id = id;
        this.avatar = avatar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String Avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ACandidato getCandidato(int id) throws SQLException {

        Connection c = null;
        ACandidato candidato = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/vot","root", "123");
            c.setAutoCommit(true);
            c.setSchema("ROOT");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "SELECT * FROM candidatos WHERE id =" + id;
            ResultSet res = trans.executeQuery(query);

            if (res.next()) {
              candidato = new ACandidato(res.getString("nome"),id,res.getString("avatar"));                
            } 
            res.close();
            c.close();
        }
        return candidato;
    }

    public static boolean registrarVoto(int id) throws SQLException {

        Connection c = null;
        boolean retorno = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/vot", "root", "123");
            c.setAutoCommit(true);
            c.setSchema("ROOT");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "update CANDIDATOS set vot = vot + 1 where id = " + id;
            if (trans.executeUpdate(query) == 1) retorno = true;
            c.close();
        }
        return retorno;
    }
    
    public static boolean registrarCandidato(String id, String nome) throws SQLException {

        Connection c = null;
        boolean retorno = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/vot", "root", "123");
            c.setAutoCommit(true);
            c.setSchema("ROOT");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "INSERT INTO table CANDIDATOS (nome,id)VALUES ("+id+","+nome+")";
            if (trans.executeUpdate(query) == 1) retorno = true;
            c.close();
        }
        return retorno;
    }
    
    
    
    public static List getCandidatos()throws SQLException {

        List lista = new ArrayList();
        Connection c = null;
        ACandidato candidato = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/vot","root", "123");
            c.setAutoCommit(true);
            c.setSchema("ROOT");
        } catch (ClassNotFoundException ex) {
            System.err.println("Falta o driver!");
        }

        if (c != null) {
            Statement trans = c.createStatement();
            String query = "SELECT * FROM candidatos";
            ResultSet res = trans.executeQuery(query);

            if (res.next()) {
              lista = new ACandidato(res.getString("nome"),res.getString("avatar"));           
            } 
            res.close();
            c.close();
        }
        return lista;
    }

}
