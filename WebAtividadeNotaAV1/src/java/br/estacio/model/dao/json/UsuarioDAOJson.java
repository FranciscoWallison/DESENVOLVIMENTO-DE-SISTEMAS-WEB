package br.estacio.model.dao.json;

import br.estacio.model.Usuario;
import br.estacio.model.dao.UsuarioDAO;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

final class UsuarioDAOJson extends UsuarioDAO {

    private static UsuarioDAOJson usuarioDAO = null;
    
    private List<Usuario> listTodosUsuarios = null;


    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAOJson();
            usuarioDAO.init();
        }
        return usuarioDAO;
    }

    
     private void init() {
        try {
            listTodosUsuarios = new <Usuario>ArrayList();

            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(new InputStreamReader(getClass().getResourceAsStream("usuarios.json")));
            
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                Usuario usuario = new Usuario((String) obj.get("nome"), (String) obj.get("login"),(String) obj.get("senha"));
                listTodosUsuarios.add(usuario);
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(AlunoDAOJson.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    @Override
    public Usuario login(String login, String senha) {

         for (Usuario usuario : listTodosUsuarios) {
            if (stringHexa(gerarHash(senha,"SHA-1")).equals(usuario.getSenha())) {
                return usuario;                
            }
        }
        return null;
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
