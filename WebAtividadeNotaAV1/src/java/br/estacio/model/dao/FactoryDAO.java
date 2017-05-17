package br.estacio.model.dao;

import br.estacio.model.dao.bd.FactoryBD;
import br.estacio.model.dao.json.FactoryJson;

public abstract class FactoryDAO {

    public static enum Persistencia {
        JSON, JavaDB
    }
    
    public static FactoryDAO getInstance(Persistencia tipo) {
        switch ( tipo ) {
            case JSON:   
                 return FactoryJson.getInstance();
            case JavaDB:
                return FactoryBD.getInstance();
            default: 
                return null;
        }
        
    }

    public abstract AlunoDAO getAlunoDAO();
        
    public abstract UsuarioDAO getUsuarioDAO(); 

}
