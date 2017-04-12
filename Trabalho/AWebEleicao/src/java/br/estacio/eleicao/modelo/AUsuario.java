/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.eleicao.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Estácio
 */
public class AUsuario {
    private String name;
    private String email;
    private String senha;
    
    public AUsuario(String email, String senha, String name){
        this.name = name;
        this.email = email;
        this.senha = senha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static AUsuario doLogin(String email, String senha) throws SQLException {

        Connection c = null;
        AUsuario user = null;
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
            String query = "SELECT * FROM users WHERE email = '"
                    + email + " and senha = '"+senha+"'";
            ResultSet res = trans.executeQuery(query);

            if (res.next()) {
              user = new AUsuario(res.getString("email"),null,res.getString("nome"));                
            }else{
               user = new AUsuario("Existe","Existe","Existe");
            }
            res.close();
            c.close();
        }
        return user;
    }
}
