package br.estacio.model.dao.bd;

import br.estacio.model.dao.AlunoDAO;
import br.estacio.model.dao.FactoryDAO;
import br.estacio.model.dao.UsuarioDAO;

public final class FactoryBD extends FactoryDAO {
    
    private static FactoryBD factory = null;
    
    private FactoryBD(){
        
    }
    
    public static FactoryDAO getInstance() {
        if (factory == null) {
            factory = new FactoryBD();
        }
        return factory;
    }

    public AlunoDAO getAlunoDAO() {
        return AlunoDAOBD.getInstance();
    }

    public UsuarioDAO getUsuarioDAO() {
        return UsuarioDAOBD.getInstance();
    }
    
    
}
