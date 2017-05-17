package br.estacio.model.dao;

import br.estacio.model.Aluno;
import br.estacio.model.Usuario;
import java.util.List;


public abstract class UsuarioDAO {

    public abstract Usuario login(String login, String senha);
        
}
