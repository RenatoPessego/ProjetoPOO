/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

/**
 *
 * @author Renato
 */
public class Pessoa {
    protected String nome;
    protected int idade;
    protected int overall = 0;

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
    
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade=idade;
    }
}
