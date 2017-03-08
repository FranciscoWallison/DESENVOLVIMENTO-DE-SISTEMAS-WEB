/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.eleicao.modelo;

/**
 *
 * @author daniel
 */
public class DCandidato {
    
    public static String getCandidato(int voto) {
        
        switch  (voto) {
            case 23: return "Daniel Mourao Martins";
            case 60: return "Chiquinho da Silva";
            case 22: return "Joana Darc";
            default: return "Candidato Nao Encontrado";
                    
        }
    }
    
}
