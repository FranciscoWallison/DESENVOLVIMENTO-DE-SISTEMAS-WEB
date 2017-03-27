package br.estacio.eleicao.modelo;

import java.util.ArrayList;
import java.util.List;

public class DCandidato {

    private String nome;
    private int numero;

    public DCandidato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public static String getCandidato(int voto) {
        
        switch  (voto) {
            case 23: return "Daniel Mourao Martins";
            case 60: return "Chiquinho da Silva";
            case 22: return "Joana Darc";
            default: return "Candidato Nao Encontrado";
                    
        }
    }
    
    public static List getCandidatos() {
        
        List lista = new ArrayList();
        for (int i = 0; i < 10; i++) {
            DCandidato dCandidato = new DCandidato("Candidato"+Integer.toString(i), i);
            lista.add(dCandidato);
        }
        return lista;
    }
    
}
 