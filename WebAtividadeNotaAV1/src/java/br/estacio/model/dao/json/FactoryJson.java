package br.estacio.model.dao.json;

import br.estacio.model.dao.AlunoDAO;
import br.estacio.model.dao.FactoryDAO;
import br.estacio.model.dao.UsuarioDAO;

public final class FactoryJson extends FactoryDAO {
    
    private static FactoryJson factory = null;
    
    private FactoryJson(){
        
    }
    
    public static FactoryDAO getInstance() {
        if (factory == null) {
            factory = new FactoryJson();
        }
        return factory;
    }

    public AlunoDAO getAlunoDAO() {
        return AlunoDAOJson.getInstance();
    }

    public UsuarioDAO getUsuarioDAO() {
        return UsuarioDAOJson.getInstance();
    }
    
    
}
