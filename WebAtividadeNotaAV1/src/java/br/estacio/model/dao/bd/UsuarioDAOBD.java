package br.estacio.model.dao.bd;

import br.estacio.model.Usuario;
import br.estacio.model.dao.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

final class UsuarioDAOBD extends UsuarioDAO {

    private static UsuarioDAOBD usuarioDAO = null;

    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAOBD();
        }
        return usuarioDAO;
    }

    @Override
    public Usuario login(String login, String senha) {

        try {
            Connection con = ConexaoBD.getConnection();
            PreparedStatement stmt = con.prepareStatement("select nome, login from usuario where login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, stringHexa(gerarHash(senha,"SHA-1")));
            ResultSet res = stmt.executeQuery();
            
            Usuario usuario = null;
            
            if (res.next()) {
                usuario = new Usuario(res.getString("nome"),res.getString("login"));
            }
            res.close();
            stmt.close();
            con.close();
            return usuario;
                         
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static String stringHexa(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result
                    += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    //stringHexa(gerarHash(frase, "MD5"))
    //stringHexa(gerarHash(frase, "SHA-1"))
    //stringHexa(gerarHash(frase, "SHA-256"))  
    private static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.reset();
            md.update(frase.getBytes("UTF-8"), 0, frase.length());
            return md.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }

}
