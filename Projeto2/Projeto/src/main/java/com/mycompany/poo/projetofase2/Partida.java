/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.*;

/**
 *
 * @author Renato
 */
public class Partida {
    private String data;
    private Equipa equipa_casa;
    private Equipa equipa_visitante;
    private Arbitro arbitro;
    private String resultado;
    

    public int getGolos_sofridos_casa() {
        return golos_sofridos_casa;
    }

    public void setGolos_sofridos_casa(int golos_sofridos_casa) {
        this.golos_sofridos_casa = golos_sofridos_casa;
    }

    public int getGolos_marcados_casa() {
        return golos_marcados_casa;
    }

    public void setGolos_marcados_casa(int golos_marcados_casa) {
        this.golos_marcados_casa = golos_marcados_casa;
    }
    private int golos_sofridos_casa = 0;
    private int golos_marcados_casa = 0;
    private boolean terminada = false;
    
    public void terminou(){
        this.terminada = true;
    }
    
    public Equipa getequipa_casa(){
        return this.equipa_casa;
    }
    
    public Equipa getequipa_visitante(){
        return this.equipa_visitante;
    }
    
    public void setequipa_visitante(Equipa a){
        this.equipa_visitante = a;
    }
    public void setequipa_casa(Equipa a){
        this.equipa_casa = a;
    }
    
    public void setdata(String data){
        this.data = data;
    }
    
    public int chance_golo(Equipa a){
        a.definir_tatica();
        a.alterar_moral_treinador();
        Random aleatorio = new Random();
        int chances_minimas = (14 * a.getTreinadorPrincipal().getMoral()) / 100;
        int chances_maximas = (24 *a.getTreinadorPrincipal().getMoral()) / 100;
        int chances_golo = aleatorio.nextInt((chances_maximas + 1) - chances_minimas) + chances_minimas;
        int vantagem_casa = aleatorio.nextInt(3-1)+1;
        if(this.equipa_casa.equals(a)){
            chances_golo = chances_golo + vantagem_casa;
        }
        return chances_golo;
    }
    
    public int probabilidade_marcar_golo(Equipa a){
        int probabilidade = 0;
        Random aleatorio = new Random();
        for(int i = 0; i<a.getJogadoresLista().size(); i++){
            if(a.getJogadoresLista().get(i).getPosJogador().equals("GR")){
                probabilidade = probabilidade + (aleatorio.nextInt(2-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("DEFESA")){
                probabilidade = probabilidade + (aleatorio.nextInt(8-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("MEDIO")){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(31-10)+10)) / 100); 
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("ATACANTE")){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(61-31)+31)) / 100);
            }
        }
        return probabilidade;
    }
    
    public void setarbitro(Arbitro a){
        this.arbitro = a;
    }
    
    public int probabilidade_defender_golo(Equipa a){
        int probabilidade = 0;
        Random aleatorio = new Random();
        for(int i = 0; i<a.getJogadoresLista().size(); i++){
            if(a.getJogadoresLista().get(i).getPosJogador().equals("ATACANTE")){
                probabilidade = probabilidade + (aleatorio.nextInt(2-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("MEDIO")){
                probabilidade = probabilidade + (aleatorio.nextInt(8-0)+0);
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("DEFESA")){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(31-10)+10)) / 100); 
            }
            else if(a.getJogadoresLista().get(i).getPosJogador().equals("GR")){
                probabilidade = probabilidade + (((100 + a.getJogadoresLista().get(i).getOverall()) * (aleatorio.nextInt(61-31)+31)) / 100);
            }
        }
        return probabilidade;
    }
    
    public void golos(){
        int chance_golo_casa = chance_golo(this.equipa_casa);
        System.out.println("Chances casa: " + chance_golo_casa);
        int chance_golo_visitante = chance_golo(this.equipa_visitante);
        System.out.println("Chance fora: " + chance_golo_visitante);
        Random aleatorio = new Random();
        for(int i = 0; i < chance_golo_casa; i ++){
            if(probabilidade_marcar_golo(this.equipa_casa) > probabilidade_defender_golo(this.equipa_visitante)){
                this.golos_marcados_casa = this.golos_marcados_casa + 1;
                int chance_marcar_golo = -1;
                int chance_assistir = -1;
                Jogador marcador = new Jogador("", 0, "", 0);
                Jogador assistente = new Jogador("", 0, "", 0);
                //fazer uma chance pra saber qual jogador da casa marcou o golo
                for(int j=0; j < this.equipa_casa.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_casa.getJogadoresLista().get(j);
                    int chance_marcar_golo_atual = 0;
                    if(jogador_atual.getPosJogador().equalsIgnoreCase("GR")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(2-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("DEFESA")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(8-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("MEDIO")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("ATACANTE")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    if(chance_marcar_golo_atual > chance_marcar_golo){
                        chance_marcar_golo = chance_marcar_golo_atual;
                        marcador = jogador_atual;
                    }
                    else if(chance_marcar_golo_atual > chance_assistir){
                        chance_assistir = chance_marcar_golo_atual;
                        assistente = jogador_atual;
                    }
                }
                marcador.getInfo_ataque().setGolos(marcador.getInfo_ataque().getGolos() + 1);
                assistente.getInfo_ataque().setAssistencias(assistente.getInfo_ataque().getAssistencias() + 1);
            }
            else{ //nao ha golo - ver quem defendeu
                int chance_defender_golo = -1;
                Jogador defensor = new Jogador("", 0, "", 0);
                for(int j=0; j < this.equipa_visitante.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_visitante.getJogadoresLista().get(j);
                    int chance_defender_golo_atual = 0;
                    if(jogador_atual.getPosJogador().equals("GR")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("DEFESA")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("MEDIO")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(30-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("ATACANTE")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(2-0)+0);
                    }
                    if(chance_defender_golo_atual > chance_defender_golo){
                        chance_defender_golo = chance_defender_golo_atual;
                        defensor = jogador_atual;
                    }
            }
                defensor.getInfo_defesa().setGolos_impedidos(defensor.getInfo_defesa().getGolos_impedidos() + 1);

            }
        }
        for(int i = 0; i < chance_golo_visitante; i ++){
            if(probabilidade_marcar_golo(this.equipa_visitante) > probabilidade_defender_golo(this.equipa_casa)){
                this.golos_sofridos_casa = this.golos_sofridos_casa + 1;
                int chance_marcar_golo = -1;
                int chance_assistir = -1;
                Jogador marcador = new Jogador("", 0, "", 0);
                Jogador assistente = new Jogador("", 0, "", 0);
                //fazer uma chance pra saber qual jogador da casa marcou o golo
                for(int j=0; j < this.equipa_visitante.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_visitante.getJogadoresLista().get(j);
                    int chance_marcar_golo_atual = 0;
                    if(jogador_atual.getPosJogador().equals("GR")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(2-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("DEFESA")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(8-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("MEDIO")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("ATACANTE")){
                        chance_marcar_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    if(chance_marcar_golo_atual > chance_marcar_golo){
                        chance_marcar_golo = chance_marcar_golo_atual;
                        marcador = jogador_atual;
                    }
                    else if(chance_marcar_golo_atual > chance_assistir){
                        chance_assistir = chance_marcar_golo_atual;
                        assistente = jogador_atual;
                    }
                }
                marcador.getInfo_ataque().setGolos(marcador.getInfo_ataque().getGolos() + 1);
                assistente.getInfo_ataque().setAssistencias(assistente.getInfo_ataque().getAssistencias() + 1);
            }
            else{ //nao ha golo - ver quem defendeu
                int chance_defender_golo = -1;
                Jogador defensor = new Jogador("", 0, "", 0);
                for(int j=0; j < this.equipa_casa.getJogadoresLista().size(); j++){
                    Jogador jogador_atual = this.equipa_casa.getJogadoresLista().get(j);
                    int chance_defender_golo_atual = 0;
                    if(jogador_atual.getPosJogador().equals("GR")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(100-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("DEFESA")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(50-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("MEDIO")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(30-0)+0);
                    }
                    else if(jogador_atual.getPosJogador().equals("ATACANTE")){
                        chance_defender_golo_atual = jogador_atual.getOverall() + (aleatorio.nextInt(2-0)+0);
                    }
                    if(chance_defender_golo_atual > chance_defender_golo){
                        chance_defender_golo = chance_defender_golo_atual;
                        defensor = jogador_atual;
                    }

              }
                defensor.getInfo_defesa().setGolos_impedidos(defensor.getInfo_defesa().getGolos_impedidos() + 1);
            }
            }
        }
    public void atualizar_infos_equipas(){ // alterar golos das equipas e n de vitorias...
            if(this.golos_marcados_casa > this.golos_sofridos_casa){
                this.equipa_casa.setNumeroVitorias(this.equipa_casa.getNumeroVitorias() + 1);
                this.equipa_visitante.setNumeroDerrotas(this.equipa_visitante.getNumeroDerrotas() + 1);
            }
            else if(this.golos_marcados_casa < this.golos_sofridos_casa){
                this.equipa_visitante.setNumeroVitorias(this.equipa_visitante.getNumeroVitorias() + 1);
                this.equipa_casa.setNumeroDerrotas(this.equipa_casa.getNumeroDerrotas() + 1);
            }
            else if(this.golos_marcados_casa == this.golos_sofridos_casa){
                this.equipa_casa.setNumeroEmpates(this.equipa_casa.getNumeroEmpates() + 1);
                this.equipa_visitante.setNumeroEmpates(this.equipa_visitante.getNumeroEmpates() + 1);
            }
            this.equipa_casa.setNumeroGolos(this.equipa_casa.getNumeroGolos() + this.golos_marcados_casa);
            this.equipa_casa.setNumeroGolosSofridos(this.equipa_casa.getNumeroGolosSofridos() + this.golos_sofridos_casa);
            this.equipa_visitante.setNumeroGolos(this.equipa_visitante.getNumeroGolos() + this.golos_sofridos_casa);
            this.equipa_visitante.setNumeroGolosSofridos(this.equipa_visitante.getNumeroGolosSofridos() + this.golos_marcados_casa);            
    }
    public void estatisticas_defensivas(){
        Random aleatorio = new Random();
        for(int i = 0; i < this.equipa_casa.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            if(atual.getPosJogador().equals("GR")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(3-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador().equals("DEFESA")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(20-6)+6));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(10-3)+3));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(20-6)+6));
            }
            else if(atual.getPosJogador().equals("MEDIO")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(12-2)+2));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(7-1)+1));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(12-2)+2));
            }
            else if(atual.getPosJogador().equals("ATACANTE")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(5-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(5-0)+0));
            }
        }
    for(int i = 0; i < this.equipa_visitante.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            if(atual.getPosJogador().equals("GR")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(3-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador().equals("DEFESA")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(20-6)+6));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(10-3)+3));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(20-6)+6));
            }
            else if(atual.getPosJogador().equals("MEDIO")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(12-2)+2));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(7-1)+1));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(12-2)+2));
            }
            else if(atual.getPosJogador().equals("ATACANTE")){
                atual.getInfo_defesa().setBolas_recuperadas(atual.getInfo_defesa().getBolas_recuperadas() + (aleatorio.nextInt(5-0)+0));
                atual.getInfo_defesa().setCarrinhos_certos(atual.getInfo_defesa().getCarrinhos_certos() + (aleatorio.nextInt(2-0)+0));
                atual.getInfo_defesa().setCortes_certos(atual.getInfo_defesa().getCortes_certos() + (aleatorio.nextInt(5-0)+0));
            }
        }
    }
    
    public void estatisticas_ofensivas(){
        Random aleatorio = new Random();
        for(int i = 0; i < this.equipa_casa.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            if(atual.getPosJogador().equals("GR")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(8-2)+2));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador().equals("DEFESA")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(15-5)+5));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(5-0)+0));
            }
            else if(atual.getPosJogador().equals("MEDIO")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(30-10)+10));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(10-2)+2));
            }            
            else if(atual.getPosJogador().equals("ATACANTE")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(25-8)+8));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(20-5)+5));
            }
            
    }
    for(int i = 0; i < this.equipa_visitante.getJogadoresLista().size(); i ++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            if(atual.getPosJogador().equals("GR")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(8-2)+2));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(2-0)+0));
            }
            else if(atual.getPosJogador().equals("DEFESA")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(15-5)+5));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(5-0)+0));
            }
            else if(atual.getPosJogador().equals("MEDIO")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(30-10)+10));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(10-2)+2));
            }            
            else if(atual.getPosJogador().equals("ATACANTE")){
                atual.getInfo_ataque().setPasses_certos(atual.getInfo_ataque().getPasses_certos() + (aleatorio.nextInt(25-8)+8));
                atual.getInfo_ataque().setDribles_certos(atual.getInfo_ataque().getDribles_certos() + (aleatorio.nextInt(20-5)+5));
            }
            
    }
    }
    
    public boolean demasiados_cartoes_casa(){
        Random aleatorio = new Random();
        int n_expulsos = 0;

        for(int i = 0; i < this.equipa_casa.getJogadoresLista().size(); i++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            int chance_cartao = aleatorio.nextInt(atual.getagressividade() - 0) +0;
            if(chance_cartao > 75){
                System.out.println("Jogador expulso: " + atual.getNome());
                atual.getInfo_defesa().setCartoesvermelhos(atual.getInfo_defesa().getCartoesvermelhos() + 1);
                atual.setdias_indisponiveis(1);
                this.equipa_casa.getJogadores_indisponiveis().add(atual);
                this.equipa_casa.getJogadoresLista().remove(atual);
                n_expulsos = n_expulsos + 1;
            }
            else if(chance_cartao > 50 && chance_cartao <= 75){
                System.out.println("Jogador levou amarelo: " + atual.getNome());
                atual.getInfo_defesa().setCartoesamarelos(atual.getInfo_defesa().getCartoesamarelos() + 1);           
            }
        }
        if(n_expulsos > 4){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean demasiados_cartoes_fora(){
        Random aleatorio = new Random();
        int n_expulsos = 0;
        for(int i = 0; i < this.equipa_visitante.getJogadoresLista().size(); i++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            int chance_cartao = aleatorio.nextInt(atual.getagressividade() - 0) +0;
            if(chance_cartao > 75){
                System.out.println("Jogador expulso: " + atual.getNome());
                atual.getInfo_defesa().setCartoesvermelhos(atual.getInfo_defesa().getCartoesvermelhos() + 1);
                this.equipa_visitante.getJogadores_indisponiveis().add(atual);
                this.equipa_visitante.getJogadoresLista().remove(atual);
                n_expulsos = n_expulsos + 1;
            }
            else if(chance_cartao > 50 && chance_cartao <= 75){
                System.out.println("Jogador levou amarelo: " + atual.getNome());
                atual.getInfo_defesa().setCartoesamarelos(atual.getInfo_defesa().getCartoesamarelos() + 1);           
            }
        }
        if(n_expulsos > 4){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void lesoes(String data){
        Random aleatorio = new Random();
        for(int i = 0; i<this.equipa_visitante.getJogadoresLista().size();i++){
            Jogador atual = this.equipa_visitante.getJogadoresLista().get(i);
            int chance_lesao = aleatorio.nextInt(100 - 0) + 0;
            if(chance_lesao == 99){
                System.out.println("O jogador "+ atual.getNome() + " lesionou-se.");
                int gravidade_lesao = aleatorio.nextInt(6-1)+ 1;
                atual.setdias_indisponiveis(gravidade_lesao);
                this.equipa_visitante.getJogadores_indisponiveis().add(atual);
                this.equipa_visitante.getJogadoresLista().remove(atual);
                atual.novaLesaoaleatoria(data);
            }
        }
        for(int i = 0; i<this.equipa_casa.getJogadoresLista().size();i++){
            Jogador atual = this.equipa_casa.getJogadoresLista().get(i);
            int chance_lesao = aleatorio.nextInt(100 - 0) + 0;
            if(chance_lesao > 94){
                System.out.println("O jogador "+ atual.getNome() + " lesionou-se.");
                int gravidade_lesao = aleatorio.nextInt(6-1)+ 1;
                atual.setdias_indisponiveis(gravidade_lesao);
                this.equipa_casa.getJogadores_indisponiveis().add(atual);
                this.equipa_casa.getJogadoresLista().remove(atual);
                atual.novaLesaoaleatoria(data);
            }
        }
    }
    
    public void executarpartida(){
        if(!this.terminada){
            if(!demasiados_cartoes_casa() && !demasiados_cartoes_fora()){
            golos();
            atualizar_infos_equipas();
            estatisticas_defensivas();
            estatisticas_ofensivas();
            lesoes(this.data);
            this.terminada = true;
            }
            else if(demasiados_cartoes_fora()){
                System.out.println("A equipa visitante teve demasiadas expulsões!");
                lesoes(this.data);
                this.golos_marcados_casa = 3;
                this.golos_sofridos_casa = 0;
                setresultado();
                this.equipa_casa.setNumeroGolos(this.equipa_casa.getNumeroGolos() + 3);
                this.equipa_casa.setNumeroVitorias(this.equipa_casa.getNumeroVitorias() + 1);
                this.equipa_visitante.setNumeroGolosSofridos(this.equipa_visitante.getNumeroGolosSofridos() + 3);
                this.equipa_visitante.setNumeroDerrotas(this.equipa_visitante.getNumeroDerrotas() + 1);
            }
            else if(demasiados_cartoes_casa()){
                lesoes(this.data);
                System.out.println("A equipa da casa teve demasiadas expulsões!");
                this.golos_marcados_casa = 0;
                this.golos_sofridos_casa = 3;
                setresultado();
                this.equipa_visitante.setNumeroGolos(this.equipa_visitante.getNumeroGolos() + 3);
                this.equipa_visitante.setNumeroVitorias(this.equipa_visitante.getNumeroVitorias() + 1);
                this.equipa_casa.setNumeroGolosSofridos(this.equipa_casa.getNumeroGolosSofridos() + 3);
                this.equipa_casa.setNumeroDerrotas(this.equipa_casa.getNumeroDerrotas() + 1);
            
            }
        }
        else{
            System.out.println("Esta partida já foi disputada anteriormente!");
        }
    }
    
    public void setresultado(){
        this.resultado = this.golos_marcados_casa + "-" + this.golos_sofridos_casa;
    }
    public String toString(){
        if(!this.terminada){
            return "Data: " + this.data + "\nEquipa da casa: " + this.equipa_casa.getNome() + "\nEquipa visitante: " + this.equipa_visitante.getNome()+ "\nArbitro: " + this.arbitro.getNome();
        }
        else{
            setresultado();
            return "Data: " + this.data + "\nEquipa da casa: " + this.equipa_casa.getNome() + "\nEquipa visitante: " + this.equipa_visitante.getNome()+ "\nArbitro: " + this.arbitro.getNome() + "\nResultado:" + this.resultado;
        }
    }  
    public Arbitro getArbitro(){
        return this.arbitro;
    }
}
