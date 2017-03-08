/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.eleicao.modelo;

/**
 *
 * @author Estácio
 */
public class DCandidato {
    public static String getCandidato(int voto){
        switch (voto) {
            case 23 : return "Wallison 23 ";
            case 60 : return "Wallison 60";
            default: return "cANDIDATO não Encontrado";
              
        }
    }
}
