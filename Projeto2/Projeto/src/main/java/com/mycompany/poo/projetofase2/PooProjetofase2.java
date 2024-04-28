/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo.projetofase2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class PooProjetofase2 {

    public static void main(String[] args) throws IOException {
        List <Equipa> equipas = new ArrayList();
        List <TreinadorPrincipal> treinadores = new ArrayList();
        List <TreinadorAssistente> treinadores_ass = new ArrayList(); 
        List <Jogador> jogadores = new ArrayList();
        List <Arbitro> arbitros = new ArrayList();
        List <Liga> ligas = new ArrayList();
        Menu menu = new Menu();
        SubMenu submenu = new SubMenu();
        menu.menuCaminho(ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass,submenu,menu);
//        
//        if(args.length==0){
//        Menu menu = new Menu();
//        //menu.opcoes();
////        Equipa BENFICA = new Equipa();
////        BENFICA.setLiga("Portuguesa");
////        BENFICA.setNome("Benfica");
////        equipas.add(BENFICA);
////        BENFICA.setTreinador("Lucas",90);
////        BENFICA.getTreinador().setNome("ANIBAL");
////        BENFICA.getTreinador().ADDEspecializacoes(BENFICA.getTreinador().GetEspecializacoes(),"sábio");
////        BENFICA.getTreinador().ADDTaticaPref(BENFICA.getTreinador().GetTaticaspref(),"4-2-2");
////        int temp=BENFICA.getJogadoresLista().size();
////        BENFICA.getJogadoresLista().add(new Jogador("Paulo",10,"S",10));
////        BENFICA.getJogadoresLista().add(new Jogador("S",10,"S",10));
////        
//        Liga Portuguesa = new Liga("Portuguesa");
//        Liga Espanhola = new Liga("Espanhola");
////        Portuguesa.addequipa(BENFICA);
//        Equipa porto = new Equipa("porto","Portuguesa");
//        equipas.add(porto);
//        Equipa benfica = new Equipa("benfica","Portuguesa");
//        equipas.add(benfica);
////        Equipa braga = new Equipa("braga","Portuguesa");
////        equipas.add(braga);
////        Equipa famalicao = new Equipa("famalicao","Portuguesa");
////        equipas.add(famalicao);
////        Equipa vitoria = new Equipa("vitoria","Portuguesa");
////        equipas.add(vitoria);
//        Equipa barcelona = new Equipa("barcelona","Espanhola");
//        equipas.add(barcelona);
////        Equipa valencia = new Equipa("valencia","Espanhola");
////        equipas.add(valencia);
//        Espanhola.addequipa(barcelona);
//
//        //menu.escolha(ligas,equipas);
//        jogadores.add(new Jogador("Paulo",21,"GK",50));
//        jogadores.add(new Jogador("Lucas",21,"DEFESA",50));
//        jogadores.add(new Jogador("Renato",21,"MEDIO",50));
//        jogadores.add(new Jogador("Gabriel",21,"ATACANTE",50));
//        jogadores.add(new Jogador("Manel",21,"GK",50));
//        jogadores.add(new Jogador("Ribeiro",21,"DEFESA",50));
//        jogadores.add(new Jogador("Lopes",21,"MEDIO",50));
//        jogadores.add(new Jogador("Antonio",21,"ATACANTE",50));
//        jogadores.add(new Jogador("Paulino",21,"MEDIO",50));
//        jogadores.add(new Jogador("Paula",21,"ATACANTE",50));
//        jogadores.add(new Jogador("Jubas",21,"MEDIO",50));
//        jogadores.add(new Jogador("Pilantra",21,"ATACANTE",50));
//        
//        //teste
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Paulo",21,"GR",99, 10) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Paul",21,"GR",1, 99) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Pau",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Pa",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("P",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Jaulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Gaulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Faulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Daulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Saulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Aaulo",21,"DEFESA",99, 10) );
//        porto.addJogadores(porto.getJogadoresLista(),new Jogador("Qaulo",21,"DEFESA",99, 10) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Oaulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Yonto",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Taulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Raulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Eaulo",21,"DEFESA",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Waulo",21,"MEDIO",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Baulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("Maulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 99) );
//        benfica.addJogadores(benfica.getJogadoresLista(),new Jogador("ulo",21,"ATACANTE",50, 99) );
//        Arbitro novo = new Arbitro();
//        TreinadorPrincipal roger = new TreinadorPrincipal("Roger", 40, 99);
//        TreinadorPrincipal Conceicao = new TreinadorPrincipal("Conceicao", 40, 79);
//        benfica.setTreinadorPrincipal(roger);
//        porto.setTreinadorPrincipal(Conceicao);
//        novo.setExperiencia(99);
//        novo.setIdade(30);
//        novo.setNome("Gay");
//        Portuguesa.addarbitro(novo);
//        Portuguesa.addequipa(porto);
//        Portuguesa.addequipa(benfica);
//        Equipa sporting = new Equipa("Sporting", "Portuguesa");
//        TreinadorPrincipal Amorim = new TreinadorPrincipal("Amorim", 30, 50);
//        sporting.setTreinadorPrincipal(Amorim);
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//                sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"ATACANTE",50, 50) );
//        sporting.addJogadores(sporting.getJogadoresLista(),new Jogador("aulo",21,"GR",50, 50) );
//
//        //Portuguesa.addequipa(sporting);
//        ligas.add(Espanhola);
//        ligas.add(Portuguesa);
//        //
//        SubMenu subMenu = new SubMenu();
//        while(true){
//        subMenu.opcoes();
//        subMenu.escolha(ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
//        }
//    }
//        else if(args.length==1){
            
            
//        SubMenu subMenu = new SubMenu();
//        while(true){
//        subMenu.opcoes();
//        subMenu.escolha(ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
//        }
//            //leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
//        }
    }
}
