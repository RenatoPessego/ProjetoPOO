/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.*;
import java.lang.Math.*;

/**
 *
 * @author Renato
 */
public class Liga {
    private String nome = "";
    private int jornada = 1;
    
    public int getjornada(){
        return this.jornada;
    }
    private List <Equipa> equipas = new ArrayList();
    private List <Arbitro> arbitros = new ArrayList();
    private List <Partida> partidas = new ArrayList();
    private int ano = 2023;

    
    public Liga(String nome){
           this.nome = nome;
    }
    public Liga(){
        
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void addequipa(Equipa a){
        this.equipas.add(a);
    }
    public void addarbitro(Arbitro a){
        this.arbitros.add(a);
    }
    
    public List<Equipa> getequipas(){
        return this.equipas;
    }
    public List<Arbitro> getarbitros(){
        return this.arbitros;
    }
   
    public void atualizarn_jornadas(){
        if(equipas.size() > 1){
        int n_jogos = equipas.get(1).n_jogos();
        boolean atualizar = true;
        for(int i=0; i< equipas.size(); i++){
            if(equipas.get(i).n_jogos() != n_jogos){
                atualizar = false;
                break;
            }
        }
        if(atualizar){
            if((n_jogos + 1) <= this.equipas.size()){
            this.jornada = n_jogos +1;
            for(int j = 0; j < this.equipas.size(); j++){
                this.equipas.get(j).treinarjogadores();
                this.equipas.get(j).verificarindisponiveis();
            }
            }
            else{
                System.out.println("Começando nova epoca...");
                comecarnovaepoca();
            }
        }
        }
    }
    
    public void comecarnovaepoca(){
        this.jornada = 1;
        this.partidas = new ArrayList();
        this.ano = this.ano + 1;
        for(int i = 0; i < this.equipas.size(); i ++){
            this.equipas.get(i).resetarequipa();
        }
        aumentaridades();
    }
    
    public void aumentaridades(){
        for (int i = 0; i < this.arbitros.size(); i++){
            arbitros.get(i).setIdade(arbitros.get(i).getIdade() + 1);
        }
        for(int j = 0; j<this.equipas.size(); j++){
            Equipa equipa_atual = this.equipas.get(j);
            for(int k = 0; k < equipa_atual.getJogadoresLista().size(); k++){
                Jogador atual = equipa_atual.getJogadoresLista().get(k);
                atual.setIdade(atual.getIdade() + 1);
            }
            equipa_atual.getTreinadorPrincipal().setIdade(equipa_atual.getTreinadorPrincipal().getIdade() + 1);
            equipa_atual.getTreinadorAssistente().setIdade(equipa_atual.getTreinadorAssistente().getIdade() + 1);
        }
    }
    
    public int equipa1_defrontou_equipa2(Equipa a, Equipa b){
        int n_vezes_defrontou = 0;
        for(int i=0; i < partidas.size(); i++){
            Partida partida = partidas.get(i);
            if((partida.getequipa_casa() == a && partida.getequipa_visitante() == b)||(partida.getequipa_casa() == b && partida.getequipa_visitante() == a)){
                n_vezes_defrontou = n_vezes_defrontou + 1;
            }
        }
        return n_vezes_defrontou;
    }
    
    public Equipa casa(Equipa a, Equipa b){ //função usada para saber qual equipa jogou em casa no primeiro jogo(só é útil para equipas que so jogaram entre si uma vez esta temporada)
        Equipa casa = new Equipa();
        for(int i = 0; i < partidas.size(); i++){
            Partida partida = partidas.get(i);
            if((partida.getequipa_casa() == a && partida.getequipa_visitante() == b)){
                casa = a;
            }
            else if((partida.getequipa_casa() == b && partida.getequipa_visitante() == a)){
                casa = b;
            }
            else{
                casa = null;
            }
        }
        return casa;
    }
        public Equipa fora(Equipa a, Equipa b){ //função usada para saber qual equipa jogou fora no primeiro jogo(só é útil para equipas que so jogaram entre si uma vez esta temporada)
        Equipa fora = new Equipa();
        for(int i = 0; i < partidas.size(); i++){
            Partida partida = partidas.get(i);
            if((partida.getequipa_casa() == a && partida.getequipa_visitante() == b)){
                fora = b;
            }
            else if((partida.getequipa_casa() == b && partida.getequipa_visitante() == a)){
                fora = a;
            }
            else{
                fora = null;
            }
        }
        return fora;
    }
   
        
    public String data_jornada(int jornada){
        //temporada começa 11 de agosto(+ou-)
        int dia = 0;
        int mes = 0;
        int ano_d = 0;
        int dias_totais = jornada * 10 ;//uma jornada ocorre a cada x dias;
        if(dias_totais >= 144){
            int dias_totais_temp = dias_totais - 143;
            mes = 1 + (dias_totais_temp/30);
            dia = (dias_totais_temp%30)*30;
            ano_d = this.ano + 1;
        }
        else{
            int dias_totais_temp = 11 + dias_totais;
            mes = 8 + (dias_totais_temp/30);
            dia = (dias_totais_temp%30);
            if(dia == 0){
                dia = 31;
            }
            ano_d = this.ano;
        }
        String data = dia + "-" + mes + "-" + ano_d;
        return data;
    }
        
    public void criarpartida(){
        boolean continuar = false;
        Random aleatorio = new Random();
        Partida nova = new Partida();
        if(this.arbitros.size() > 0)
        {
        int ind_arbitro = aleatorio.nextInt(this.arbitros.size());
        nova.setarbitro(this.arbitros.get(ind_arbitro));
        if(this.jornada < this.equipas.size()){
            while(!continuar){
                int equipa1 = aleatorio.nextInt((equipas.size()) - 0) + 0;
                int equipa2 = aleatorio.nextInt((equipas.size()) - 0) + 0;
                if(equipa1 != equipa2 && (((equipa1_defrontou_equipa2(equipas.get(equipa1),equipas.get(equipa2))))==0)){
                    nova.setequipa_casa(equipas.get(equipa1));
                    nova.setequipa_visitante(equipas.get(equipa2));
                    continuar = true;
                }
                else{
                    continuar = false;
                }
            }
        }
        else if(this.jornada >=this.equipas.size() && this.jornada <= this.equipas.size() * 2 - 2){
            while(!continuar){
            int equipa1 = aleatorio.nextInt(equipas.size()) + 0;
            int equipa2 = aleatorio.nextInt(equipas.size()) + 0;
            if(equipa1 != equipa2 && ((equipa1_defrontou_equipa2(equipas.get(equipa1),equipas.get(equipa2))))==1){
                nova.setequipa_visitante(casa(equipas.get(equipa1),equipas.get(equipa2)));
                nova.setequipa_casa(fora(equipas.get(equipa1),equipas.get(equipa2)));
                continuar = true;
            }
            else{
                continuar = false;
            }
            }

        }
        nova.setdata(data_jornada(this.jornada));
        this.partidas.add(nova);
    }
    else{
        System.out.println("Não há arbitros!");
    }
    }
    
    public List <Partida> Getpartidas(){
        return this.partidas;
    }
    
    public String toString(){
        return "Liga: " + nome + "\nJornada: " + jornada + "\nEquipas: " + equipas;
    }
}
