package com.mycompany.poo.projetofase2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.List;

public class Leitura{
    public int numeroLinhasFicheiro(String caminho) throws IOException{
    FileReader inStream = new FileReader(caminho);
    BufferedReader bR = new BufferedReader(inStream);
    String linha=bR.readLine();
    int numeroLinhas=0;
    while(linha!=null){
        numeroLinhas++;
        linha=bR.readLine();
    }
    return numeroLinhas;   
}
    public void lerFicheiroEquipa(String caminho,List<Liga> ligas, List<Equipa> equipas,
    List<TreinadorPrincipal> treinadoresPrincipal,List<Jogador> jogadores,
    List<Arbitro> arbitros,List<TreinadorAssistente> treinadoresAssistente)throws IOException{
        int tamanhoFicheiro= numeroLinhasFicheiro(caminho);
        FileReader inStream = new FileReader(caminho);
        BufferedReader bR = new BufferedReader(inStream);
        Equipa equipaNova = new Equipa();
        TreinadorPrincipal treinadorPrincipalNovo = new TreinadorPrincipal();
        TreinadorAssistente treinadorAssistenteNovo = new TreinadorAssistente();
        

        String linha = bR.readLine();
        String[] equipaInfo={};
        
            lerERegistarTreinadoresEEstatisticas(linha, equipaInfo, bR, equipaNova,
            treinadorPrincipalNovo, treinadorAssistenteNovo, treinadoresAssistente, treinadoresPrincipal);
            lerERegistarJogadoresNaEquipa(equipaNova,jogadores,ligas,equipas,bR,linha);
            
            
    }
    public void lerERegistarTreinadoresEEstatisticas(String linha,String[] equipaInfo,BufferedReader bR,Equipa equipaNova
            ,TreinadorPrincipal treinadorPrincipalNovo,TreinadorAssistente treinadorAssistenteNovo
            ,List<TreinadorAssistente> treinadoresAssistente,List<TreinadorPrincipal> treinadoresPrincipal) throws IOException{
        linha = bR.readLine();
        equipaInfo=linha.split("\\|");

        equipaNova.setNome(equipaInfo[0]);
            equipaNova.setLiga(equipaInfo[1]);
            int desempenhoMed=Integer.parseInt(equipaInfo[2]);
            equipaNova.setDesempenhoMed(desempenhoMed);
            
            int numeroVitorias=Integer.parseInt(equipaInfo[3]);
            equipaNova.setNumeroVitorias(numeroVitorias);
            
            int numeroEmpates=Integer.parseInt(equipaInfo[4]);
            equipaNova.setNumeroEmpates(numeroEmpates);
            
            int umeroDerrotas=Integer.parseInt(equipaInfo[5]);
            equipaNova.setNumeroDerrotas(umeroDerrotas);
            
            int numeroGolos=Integer.parseInt(equipaInfo[6]);
            equipaNova.setNumeroGolos(numeroGolos);
            
            int numeroGolosSofridos=Integer.parseInt(equipaInfo[7]);
            equipaNova.setNumeroGolosSofridos(numeroGolosSofridos);
            
            equipaNova.setTatica(equipaInfo[8]);
            
            treinadorPrincipalNovo.setNome(equipaInfo[9]);
            
            int idadeTreinadorPrincipal=Integer.parseInt(equipaInfo[10]);
            treinadorPrincipalNovo.setIdade(idadeTreinadorPrincipal);
            
            String[] treinadorPrincipalEsp=equipaInfo[11].split("\\#");
            for(int i=0;i<treinadorPrincipalEsp.length;i++){
                treinadorPrincipalNovo.ADDEspecializacoes(treinadorPrincipalNovo.GetEspecializacoes(), treinadorPrincipalEsp[i]);
            }
            
            String[] treinadorPrincipalTaticasPref=equipaInfo[12].split("\\/");
            for(int i=0;i<treinadorPrincipalTaticasPref.length;i++){
                treinadorPrincipalNovo.ADDTaticaPref(treinadorPrincipalNovo.GetTaticaspref(), treinadorPrincipalTaticasPref[i]);
            }
            
            int overallTreinadorPrincipal=Integer.parseInt(equipaInfo[13]);
            treinadorPrincipalNovo.setOverall(overallTreinadorPrincipal);
            
            treinadorAssistenteNovo.setNome(equipaInfo[14]);
            
            int idadeTreinadorAssistente=Integer.parseInt(equipaInfo[15]);
            treinadorAssistenteNovo.setIdade(idadeTreinadorAssistente);
            
            treinadorAssistenteNovo.setPosicaopreferida(equipaInfo[16]);
            
            int overallTreinadorAssistente=Integer.parseInt(equipaInfo[17]);
            treinadorAssistenteNovo.setOverall(overallTreinadorAssistente);
            
            treinadoresPrincipal.add(treinadorPrincipalNovo);
            treinadoresAssistente.add(treinadorAssistenteNovo);
            
            int indiceTreinadorPrincipal=treinadoresPrincipal.indexOf(treinadorPrincipalNovo);
            int indiceTreinadorAssistente=treinadoresAssistente.indexOf(treinadorAssistenteNovo);
            
            if(indiceTreinadorPrincipal!=-1){
                equipaNova.setTreinadorPrincipal(treinadoresPrincipal.get(indiceTreinadorPrincipal));
            }
            if(indiceTreinadorAssistente!=-1){
                equipaNova.setTreinadorAssistente(treinadoresAssistente.get(indiceTreinadorAssistente));
            }
//            System.out.print(equipaNova);
//            System.out.print(treinadoresAssistente.get(indiceTreinadorAssistente));
//            System.out.print(treinadoresPrincipal.get(indiceTreinadorPrincipal));
        
    }
    public void lerERegistarJogadoresNaEquipa(Equipa equipaNova,List<Jogador> jogadores,List<Liga> ligas,List<Equipa> equipas,BufferedReader bR,String linha) throws IOException{
        for(int i=0;i<11;i++){
                linha = bR.readLine();
                String[] equipaJogadores=linha.split("\\|");
                Jogador jogadorNovo = new Jogador();
                jogadorNovo.setNome(equipaJogadores[0]);
                
                int idadeJogadorNovo=Integer.parseInt(equipaJogadores[1]);
                jogadorNovo.setIdade(idadeJogadorNovo);
                jogadorNovo.setPosJogador(equipaJogadores[2]);
                
                int agressividadeJogadorNovo=Integer.parseInt(equipaJogadores[3]);
                jogadorNovo.setNivel_agressividade(agressividadeJogadorNovo);
                
                int overallJogadorNovo=Integer.parseInt(equipaJogadores[4]);
                jogadorNovo.setOverall(overallJogadorNovo);
                
                jogadores.add(jogadorNovo);
                int indiceJogador=jogadores.indexOf(jogadorNovo);
            
                if(indiceJogador!=-1){
                    equipaNova.addJogadores(jogadores, jogadores.get(indiceJogador));
                }
            
            }
            equipas.add(equipaNova);
          
        int equipaIntPos=-1;
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getNome().equalsIgnoreCase(equipaNova.getNome())){
                equipaIntPos=i;
            }
        }
        
        int valorLiga=-1;
        //se a liga existir
        if(percorrerLigas(ligas,equipas.get(equipaIntPos).getLiga())){
            valorLiga=percorrerLigasInt(ligas,equipas.get(equipaIntPos).getLiga());
            ligas.get(valorLiga).addequipa(equipas.get(equipaIntPos));
        }
        else{
            Liga ligaNova= new Liga(equipas.get(equipaIntPos).getLiga());
            ligaNova.addequipa(equipas.get(equipaIntPos));
            ligas.add(ligaNova);
        }
    }
    public boolean percorrerLigas(List<Liga> ligas,String nomeLiga){
        for(int i=0;i<ligas.size();i++){
            if(ligas.get(i).getNome().equalsIgnoreCase(nomeLiga)){
                return true;
            }
        }
        return false;
    }
    public int percorrerLigasInt(List<Liga> ligas,String nomeLiga){
        for(int i=0;i<ligas.size();i++){
            if(ligas.get(i).getNome().equalsIgnoreCase(nomeLiga)){
                return i;
            }
        }
        return -1;
    }
    public boolean percorrerEquipas(List<Equipa> equipas,String nomeEquipa){
        for(int i=0;i<equipas.size();i++){
            if(nomeEquipa.equalsIgnoreCase(equipas.get(i).getNome())){
                return true;
            } 
        }
        return false;
    }
    public void lerFicheiroArbitro(String caminho,List<Liga> ligas, List<Equipa> equipas,
    List<TreinadorPrincipal> treinadoresPrincipal,List<Jogador> jogadores,
    List<Arbitro> arbitros,List<TreinadorAssistente> treinadoresAssistente)throws IOException{
    FileReader inStream = new FileReader(caminho);
    BufferedReader bR = new BufferedReader(inStream);
    //NOME|IDADE|EXPERIENCIA
    
    //cada linha 1 arbitro
    int tamanhoFicheiro= numeroLinhasFicheiro(caminho);
    String linha = bR.readLine();
    String[] arbitroInfo={};
    
    int ultimo=0;
    for(int i=0;i<tamanhoFicheiro-1;i++){
    linha = bR.readLine();
    arbitroInfo=linha.split("\\|");
    
    Arbitro arbitroNovo = new Arbitro();
    arbitroNovo.setNome(arbitroInfo[0]);//3-6
    
    int idadeArbitroNovo=Integer.parseInt(arbitroInfo[1]);//4-7
    arbitroNovo.setIdade(idadeArbitroNovo);
    
    int experienciaArbitroNovo=Integer.parseInt(arbitroInfo[2]);//5-8
    
    arbitroNovo.setExperiencia(experienciaArbitroNovo);
    arbitros.add(arbitroNovo);
//    System.out.println(arbitroNovo);
    }
    
    }
}