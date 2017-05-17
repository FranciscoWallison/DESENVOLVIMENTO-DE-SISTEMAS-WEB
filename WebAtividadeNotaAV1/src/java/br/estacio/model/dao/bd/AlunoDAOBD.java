package br.estacio.model.dao.bd;

import br.estacio.model.Aluno;
import br.estacio.model.dao.AlunoDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

    final class AlunoDAOBD extends AlunoDAO {

    private static AlunoDAOBD alunoDAO = null;

    public static AlunoDAOBD getInstance() {
        if (alunoDAO == null) {
            alunoDAO = new AlunoDAOBD();
        }
        return alunoDAO;
    }

    private List getLista(String query) {
        List listaAlunos = new ArrayList();
        try {
            Connection con = ConexaoBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);            
            while (res.next()) {
                Aluno aluno = new Aluno(res.getString("nome"), res.getLong("matricula"));
                listaAlunos.add(aluno);
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listaAlunos;
        
    }
    
    private Aluno getAluno(String query) {
        Aluno aluno = null;
        try {
            Connection con = ConexaoBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query); 
            if ( res.next() ) {
               aluno = new Aluno(res.getString("nome"), res.getLong("matricula"));
            }
            res.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAOBD.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return aluno;
        
    }
    
    public List getTodosAlunos() {
        return getLista("Select matricula, nome from aluno");
    }

    public Aluno getAlunoPorMatricula(long matricula) {
        return getAluno("Select matricula, nome from aluno where matricula = '"+matricula+"'");        
    }

    public List getAlunosPorNome(String pesquisa) {
       if (pesquisa != null) {
           return getLista("Select matricula, nome from aluno where upper(nome) like '%"+pesquisa.toUpperCase()+"%'");
       } else {
           return null;
       }
    }
    
    public static void main (String args[]) {
        System.out.println((new AlunoDAOBD().getAlunosPorNome("silva")).size());
    }
}
