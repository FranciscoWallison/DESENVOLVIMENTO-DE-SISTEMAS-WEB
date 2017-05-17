package br.estacio.model.dao.json;

import br.estacio.model.Aluno;
import br.estacio.model.dao.AlunoDAO;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

    final class AlunoDAOJson extends AlunoDAO {

    private static AlunoDAOJson alunoDAO = null;

    public static AlunoDAOJson getInstance() {
        if (alunoDAO == null) {
            alunoDAO = new AlunoDAOJson();
            alunoDAO.init();
        }
        return alunoDAO;
    }

    private List<Aluno> listTodosAlunos = null;

    private void init() {
        try {
            listTodosAlunos = new <Aluno>ArrayList();
            
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(new InputStreamReader(getClass().getResourceAsStream("alunos.json")));
            
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                Aluno aluno = new Aluno((String) obj.get("nome"), (Long) obj.get("matricula"));
                listTodosAlunos.add(aluno);
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(AlunoDAOJson.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List getTodosAlunos() {
        return listTodosAlunos;
    }

    public Aluno getAlunoPorMatricula(long matricula) {
        for (Aluno aluno : listTodosAlunos) {
            if (aluno.getMatricula() == matricula ) {
                return aluno;                
            }
        }
        return null;
    }

    public List getAlunosPorNome(String pesquisa) {
        List listaAlunos = new ArrayList();
        for (Aluno aluno : listTodosAlunos) {
            if (aluno.getNome().toLowerCase().contains(pesquisa.toLowerCase())) {
                listaAlunos.add(aluno);
            }
        }
        return listaAlunos;
    }
}
