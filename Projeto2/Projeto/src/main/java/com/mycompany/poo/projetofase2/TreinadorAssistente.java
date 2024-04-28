/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

/**
 *
 * @author Renato
 */
public class TreinadorAssistente extends Treinador {
    private String posicaopreferida = "";

    public String getPosicaopreferida() {
        return posicaopreferida;
    }

    public void setPosicaopreferida(String posicaopreferida) {
        this.posicaopreferida = posicaopreferida;
    }
    
    public String toString(){
        return "Treinador Assistente: " + this.nome + "\nIdade: " + this.idade + "\nEquipa atual: "+this.getEquipaAtreinar()+"\nPosicao preferida: " + this.posicaopreferida+
                "\nOverall: " + this.overall;
                
        
    }
}
