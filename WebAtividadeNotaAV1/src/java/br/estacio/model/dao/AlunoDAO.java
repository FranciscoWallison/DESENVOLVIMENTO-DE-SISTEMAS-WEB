package br.estacio.model.dao;

import br.estacio.model.Aluno;
import java.util.List;


public abstract class AlunoDAO {

    public abstract List getTodosAlunos();
        
    public abstract Aluno getAlunoPorMatricula(long matricula); 

    public abstract List getAlunosPorNome(String pesquisa);
}
