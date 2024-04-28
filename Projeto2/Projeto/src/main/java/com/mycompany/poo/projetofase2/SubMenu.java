/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Paulo
 */
public class SubMenu extends Menu implements Comum {
    @Override
    public void opcoes(){
        System.out.println(
                "1. Registar um jogador \n2. Registar um treinador principal \n"
                +"3. Registar um treinador assistente \n"+"4. Registar uma equipa \n"+"5. Registar um arbítro \n"
                +"6. Ir para o menu\n" + "7. Sair");
    }

    @Override
    public boolean escolhavalida(String a) {
        return super.escolhavalida(a);
    }

    public void escolha(List<Liga> ligas, List<Equipa> equipas,List<TreinadorPrincipal> treinadoresPrincipal,List<Jogador> jogadores,List<Arbitro> arbitros,List<TreinadorAssistente> treinadoresAssistente) {
        System.out.println("Escolha uma das opções: ");
        String escolha = leitura.nextLine().trim();
        boolean sair=true;
        while(!escolhavalida(escolha)&&sair){
            System.out.println("Opção inválida! Escolha uma opção entre 0 e 9: ");
            escolha = leitura.nextLine().trim();
        }
        int escolhaint = escolha.charAt(0) - 48;
        switch(escolhaint){
            case 1:
                registarJogador(jogadores);
                break;
            case 2:
                registarTreinadorPrincipal(treinadoresPrincipal);
                break;
            case 3:
                registarTreinadorAssistente(treinadoresAssistente);
                break;
            case 4:
                registarEquipa(ligas,jogadores,equipas,treinadoresPrincipal,treinadoresAssistente);
                break;
            case 5:
                registarArbitro(arbitros);  
                break;
            case 6:
                //Menu();
                voltarAoMenu(ligas, equipas, treinadoresPrincipal, jogadores, arbitros, treinadoresAssistente);
                break;
            case 7:
                System.exit(0);
                break;  
        }
    }
    //Jogadores com o mesmo nome nao posso adicionar
    public boolean percorrerJogadores(List<Jogador> jogadores,String nomeJogador){
        for(int i=0;i<jogadores.size();i++){
            if(nomeJogador.equalsIgnoreCase(jogadores.get(i).getNome())){
                return true;
            } 
        }
        return false;
    }
 
    public boolean percorrerTreinadoresPrincipal(List<TreinadorPrincipal> treinadores,String nomeTreinador){
        for(int i=0;i<treinadores.size();i++){
            if(nomeTreinador.equalsIgnoreCase(treinadores.get(i).getNome())){
                return true;
            } 
        }
        return false;
    }
    public boolean percorrerTreinadoresAssistente(List<TreinadorAssistente> treinadores,String nomeTreinador){
        for(int i=0;i<treinadores.size();i++){
            if(nomeTreinador.equalsIgnoreCase(treinadores.get(i).getNome())){
                return true;
            } 
        }
        return false;
    }
    
    public boolean percorrerEquipas(List<Equipa> equipas,String nomeEquipa){
        for(int i=0;i<equipas.size();i++){
            if(nomeEquipa.equalsIgnoreCase(equipas.get(i).getNome())){
                return true;
            } 
        }
        return false;
    }
    //true especializacao já existe
    public boolean percorrerTreinadoresEspecializacoes(TreinadorPrincipal treinador, String especializacao) {
    List<String> especializacoes=treinador.GetEspecializacoes();
    int tamanhoListaEspecializacoes=especializacoes.size();

    if(tamanhoListaEspecializacoes > 0){
        for(int i=0;i<tamanhoListaEspecializacoes;i++){
            if(especializacoes.get(i).equalsIgnoreCase(especializacao)){
                return true;
            }
            
        }
    }
    return false;
}
    public boolean percorrerTreinadoresTaticas(TreinadorPrincipal treinador, String tatica) {
    List<String> taticas=treinador.GetTaticaspref();
    int tamanhoListaTaticas=taticas.size();

    if(tamanhoListaTaticas > 0){
        for(int i=0;i<tamanhoListaTaticas;i++){
            if(taticas.get(i).equalsIgnoreCase(tatica)){
                return true;
            }
            
        }
    }
    return false;
}
    
    public boolean contemNumeros(String str){
    char[] strCaracteres = str.toCharArray();
    int strNumCaracteres = strCaracteres.length;
    for (int i=0;i<strNumCaracteres;i++){
        if (Character.isDigit(strCaracteres[i])){
            return true;
        }
    }
    return false;
}
    public boolean contemLetras(String str){
    char[] strCaracteres = str.toCharArray();
    int strNumCaracteres = strCaracteres.length;
    for (int i = 0; i < strNumCaracteres; i++){
        if (Character.isLetter(strCaracteres[i])){
            return true;
        }
    }
    return false;
}

    public String posicaoAdvemOpcao(int posicaoJogadorInt){
        switch(posicaoJogadorInt){
            case 1:
                return "GR";
            case 2:
                return "DEFESA";
            case 3:
                return "MEDIO";
            case 4:
                return "ATACANTE";
        }
        return "Essa posição não existe";
    }
    public boolean idadeJogador(int idadeJogadorInt){
        if(idadeJogadorInt>=16 && idadeJogadorInt<=50){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean agressividadeJogador(int agressividadeJogadorInt){
        if(agressividadeJogadorInt>=0 && agressividadeJogadorInt<=100){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean taticavalida(String str){
    char[] strCaracteres = str.toCharArray();
    int strNumCaracteres = strCaracteres.length;
    int somaCaracteres=0;
    if(strNumCaracteres==3){
        for (int i = 0; i < strNumCaracteres; i++){
        somaCaracteres+=Character.getNumericValue(strCaracteres[i]);
        }
        if(somaCaracteres==10){
            return true;
        }
        else{
            return false;
        }   
    }
    else{
        return false;
    }
    
}
    public String adicionarSeparacaoTatica(String str){
    char[] strCaracteres = str.toCharArray();
    int strNumCaracteres = strCaracteres.length;
    String taticaResultante = String.valueOf(strCaracteres[0]);
        for(int i=1;i<strNumCaracteres;i++){
            taticaResultante += "-" + strCaracteres[i];
        }
        return taticaResultante;
    }
    
    public List<Jogador> mostrarJogadoresPos(String pos,List<Jogador> jogadores){
        List<Jogador> jogadoresDisp=new ArrayList();
        for(int i=0;i<jogadores.size();i++){
            if(jogadores.get(i).getPosJogador().equalsIgnoreCase(pos)){
                if(jogadores.get(i).getEquipa().equals("")){
                    jogadoresDisp.add(jogadores.get(i));
                }
                
            }
        }
        return jogadoresDisp;
    }
    public List<Jogador> mostrarJogadoresPos(List<Jogador> jogadores){
        List<Jogador> jogadoresDisp=new ArrayList();
        for(int i=0;i<jogadores.size();i++){
            if(!(jogadores.get(i).getPosJogador().equals("GR"))){
                if(jogadores.get(i).getEquipa().equals("")){
                    jogadoresDisp.add(jogadores.get(i));
                }
                
            }
        }
        return jogadoresDisp;
    }
    public List<TreinadorPrincipal> mostrarTreinadoresPrincipal(List<TreinadorPrincipal> treinadores){
       List<TreinadorPrincipal> treinadoresDisp=new ArrayList();
       for(int i=0;i<treinadores.size();i++){
           if(treinadores.get(i).getEquipaAtreinar().equals("")){
               treinadoresDisp.add(treinadores.get(i));
           }
       }
       return treinadoresDisp;
    }
    public List<TreinadorAssistente> mostrarTreinadoresAssistente(List<TreinadorAssistente> treinadores){
       List<TreinadorAssistente> treinadoresDisp=new ArrayList();
       for(int i=0;i<treinadores.size();i++){
           if(treinadores.get(i).getEquipaAtreinar().equals("")){
               treinadoresDisp.add(treinadores.get(i));
           }
       }
       return treinadoresDisp;
    }
    
    public void registarJogador(List<Jogador> jogadores){
        Jogador jogadorAAdicionar = new Jogador();
        System.out.println("Introduza o nome do Jogador: ");
        boolean validoNome=true;
        
        while(validoNome){
            String nomeJogador = leitura.nextLine().trim();
            if(nomeJogador.trim().isEmpty()){
                System.out.println("Introduza um nome válido");
                continue;
            }
            else if(percorrerJogadores(jogadores,nomeJogador)){
                System.out.println("Esse jogador já existe, introduza outro");
                continue;
            }
            else if(contemNumeros(nomeJogador)){
                System.out.println("O nome do jogador não pode ter números, introduza um nome válido");
                continue;
            }
            else{
                validoNome=false;
                jogadorAAdicionar.setNome(nomeJogador.trim()); 
                
            }    
        }
        
            boolean validoIdade=true;
            System.out.println("Introduza a idade do jogador entre 16 anos e 50 anos: ");
            while(validoIdade){
                String idadeJogadorLeitura = leitura.nextLine().trim();
                if (contemLetras(idadeJogadorLeitura)) {
                    System.out.println("A idade não pode conter letras. Introduza novamente: ");
                    continue;
                }
                else if(idadeJogadorLeitura.trim().isEmpty()){
                    System.out.println("Introduza uma idade válida");
                    continue;
                }
                int idadeJogador=0;
                if(idadeJogadorLeitura.length()==1 || idadeJogadorLeitura.length()==2){
                    idadeJogador = Integer.parseInt(idadeJogadorLeitura);
                    if(idadeJogador >= 16 && idadeJogador <= 50){
                        validoIdade = false;
                        jogadorAAdicionar.setIdade(idadeJogador);
                        break;
                    }
                    else{
                        System.out.println("Introduza uma idade válida entre 16 anos e 50 anos: ");
                        continue;
                    } 
                }
                else{
                    System.out.println("Introduza uma idade válida entre 16 anos e 50 anos: ");
                    continue;
                }
                
            }
            
        boolean validoPos=true;
        System.out.println("Introduza a sua posição:\n" + "1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
            while(validoPos){
                String posicaoJogadorLeitura = leitura.nextLine().trim();
                if(contemLetras(posicaoJogadorLeitura)){
                    System.out.println("A posição deve ser um número. Introduza novamente: ");
                    continue;
                }
                else if(posicaoJogadorLeitura.trim().isEmpty()){
                    System.out.println("Introduza uma opção válida");
                    continue;
                }
                int posicaoJogadorInt=0;
                if(posicaoJogadorLeitura.length()==1){
                    posicaoJogadorInt = Integer.parseInt(posicaoJogadorLeitura);
                    String posicaoJogador = posicaoAdvemOpcao(posicaoJogadorInt);
                    if(posicaoJogador.equalsIgnoreCase("Essa posição não existe")){
                        System.out.println("Introduza uma opção válida:\n1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
                    }
                    else{
                        validoPos = false;
                        jogadorAAdicionar.setPosJogador(posicaoJogador.trim());  
                        break;
                    }
                }
                else{
                    System.out.println("Introduza uma opção válida:\n1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
                    continue;
                }
                   
            }
        boolean validoAgressividade=true;
        System.out.println("Introduza o nivel de agressividade entre 0 e 100");
            while(validoAgressividade){
                String agressividadeJogadorLeitura = leitura.nextLine().trim();
                if(contemLetras(agressividadeJogadorLeitura)){
                    System.out.println("A agressividade deve ser um número. Introduza novamente: ");
                    continue;
                }
                else if(agressividadeJogadorLeitura.trim().isEmpty()){
                    System.out.println("A posição deve ser um número. Introduza novamente: ");
                    continue;
                }
                if(agressividadeJogadorLeitura.trim().length()>=1 && agressividadeJogadorLeitura.trim().length()<=3){
                    int agressividadeJogadorInt = Integer.parseInt(agressividadeJogadorLeitura.trim());
                        if(agressividadeJogador(agressividadeJogadorInt)){
                            validoAgressividade = false;
                            jogadorAAdicionar.setNivel_agressividade(agressividadeJogadorInt);

                            break;
                        }
                        else{
                            System.out.println("Introduza um nível de agressividade válido entre 0 e 100: ");
                            continue;
                        }   
                }
                else{
                    System.out.println("Introduza um nível de agressividade válido entre 0 e 100: ");
                    continue;
                }
            }
            boolean validoOverall = true;
        System.out.println("Introduza o overall entre 1 e 99:");
        while(validoOverall ){
            String overallLeitura = leitura.nextLine().trim();
            if(contemLetras(overallLeitura)){
                System.out.println("A overall não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(overallLeitura.trim().isEmpty()){
                 System.out.println("Introduza um overall válido");
                continue;
            }
            int overall=0;
            if(overallLeitura.trim().length()==1 || overallLeitura.trim().length()==2){
                overall = Integer.parseInt(overallLeitura.trim());
                if(overall >= 1 && overall <= 99){
                    validoOverall = false;
                    jogadorAAdicionar.setOverall(overall);
                    break;
                }
                else{
                    System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                continue;
            }
            
        }
           jogadores.add(jogadorAAdicionar);
//           System.out.println(jogadorAAdicionar);
//           System.out.println("Equipa: " + jogadorAAdicionar.getEquipa());
    }

    public void registarTreinadorPrincipal(List<TreinadorPrincipal> treinadores){
        TreinadorPrincipal treinadorAAdicionar = new TreinadorPrincipal();
        System.out.println("Introduza o nome do treinador: ");
        boolean validoNome = true;

        while(validoNome){
            String nomeTreinador = leitura.nextLine().trim();
            if (percorrerTreinadoresPrincipal(treinadores, nomeTreinador)){
                System.out.println("Esse treinador já existe, introduza outro");
                continue;
            }
            else if(contemNumeros(nomeTreinador)){
                System.out.println("O nome do treinador não pode ter números, introduza um nome válido");
            }
            else if(nomeTreinador.trim().isEmpty()){
                 System.out.println("Introduza um nome válido");
                continue;
            }
            else{
                validoNome = false;
                treinadorAAdicionar.setNome(nomeTreinador.trim());
                break;
            }
        }

        boolean validoIdade = true;
        System.out.println("Introduza a idade do treinador entre 21 anos e 100 anos: ");
        while(validoIdade){
            String idadeTreinadorLeitura = leitura.nextLine().trim();
            if(contemLetras(idadeTreinadorLeitura)){
                System.out.println("A idade não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(idadeTreinadorLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma idade válida");
                continue;
            }
            int idadeTreinador=0;
            if(idadeTreinadorLeitura.trim().length()==1 || idadeTreinadorLeitura.trim().length()==2 || idadeTreinadorLeitura.trim().length()==3){
                idadeTreinador = Integer.parseInt(idadeTreinadorLeitura.trim());
                if(idadeTreinador >= 21 && idadeTreinador <= 100){
                    validoIdade = false;
                    treinadorAAdicionar.setIdade(idadeTreinador);
                    break;
                }
                else{
                    System.out.println("Introduza uma idade válida entre 21 anos e 100 anos: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza uma idade válida entre 21 anos e 100 anos: ");
                continue;
            }
            
        }

        System.out.println("Introduza a/as especializacoes do treinador: ");
        boolean especializacoesTreinador=true;
        
        while(especializacoesTreinador){
            String especializacao = leitura.nextLine().trim();
            if(percorrerTreinadoresEspecializacoes(treinadorAAdicionar,especializacao)){
                System.out.println("Introduza uma especializacao não repetida: ");
                continue;
            }
            else if(especializacao.trim().isEmpty()){
                System.out.println("Introduza uma especializacao válida: ");
                continue;
            }
            else if(contemNumeros(especializacao)){
                System.out.println("As especializacoes não podem conter números. Introduza novamente: ");
                continue;
            }
            treinadorAAdicionar.ADDEspecializacoes(treinadorAAdicionar.GetEspecializacoes(), especializacao.trim());

            System.out.println("Deseja inserir mais alguma especialização?\n1. SIM\n2. NAO");
            while(true){
                String opcao = leitura.nextLine().trim();
                if(contemLetras(opcao)){
                    System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                    continue;
                }
                else if(opcao.trim().isEmpty()){
                    System.out.println("Introduza uma opção válida");
                    continue;
                }
                
                int opcaoInt=0;
                if(opcao.trim().length()==1){
                    opcaoInt = Integer.parseInt(opcao);
                    if(opcaoInt == 1){
                        System.out.println("Especialização: ");
                        break;
                    }
                    else if(opcaoInt == 2){
                        especializacoesTreinador=false;
                        break;
                    }
                    else{
                        System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                        continue;
                    }  
                }
                else{
                    System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                    continue;
                }
                
            }
        }
        System.out.println("Introduza a/as taticas do treinador respeitando este formato XYZ: ");
        boolean taticasTreinador=true;
        while(taticasTreinador){
            String taticas = leitura.nextLine().trim();
            String taticaAAdicionar=adicionarSeparacaoTatica(taticas);
            if(percorrerTreinadoresTaticas(treinadorAAdicionar,taticaAAdicionar)){
                System.out.println("Introduza uma tatica não repetida: ");
                continue;
            }
            else if(contemLetras(taticas)){
                System.out.println("Introduza uma tatica válida");
                continue;
            }
            else if(taticas.trim().isEmpty()){
                System.out.println("Introduza uma tatica válida");
                continue;
            }
            else{
                if(taticavalida(taticas)){
                    treinadorAAdicionar.ADDTaticaPref(treinadorAAdicionar.GetTaticaspref(), taticaAAdicionar.trim());
                }
                else{
                    System.out.println("Introduza uma tatica válida");
                    continue;
                }
                
            }
            System.out.println("Deseja inserir mais alguma tática?\n1. SIM\n2. NAO");
            while(true){
                String opcao = leitura.nextLine().trim();
                if(contemLetras(opcao)){
                    System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                    continue;
                }
                
                int opcaoInt=0;
                if(opcao.length()==1){
                    opcaoInt = Integer.parseInt(opcao);
                    if(opcaoInt == 1){
                        System.out.println("Tática: ");
                        break;
                    }
                    else if(opcaoInt == 2){
                        taticasTreinador=false;
                        break;
                    }
                    else{
                        System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                        continue;
                    }  
                }
                else{
                    System.out.println("Escolha ou 1 ou 2. Introduza novamente: ");
                    continue;
                }
                
            }
        }
        boolean validoOverall = true;
        System.out.println("Introduza o overall entre 1 e 99:");
        while(validoOverall ){
            String overallLeitura = leitura.nextLine().trim();
            if(contemLetras(overallLeitura)){
                System.out.println("A overall não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(overallLeitura.trim().isEmpty()){
                 System.out.println("Introduza um overall válido");
                continue;
            }
            int overall=0;
            if(overallLeitura.trim().length()==1 || overallLeitura.trim().length()==2){
                overall = Integer.parseInt(overallLeitura.trim());
                if(overall >= 1 && overall <= 99){
                    validoOverall = false;
                    treinadorAAdicionar.setOverall(overall);
                    break;
                }
                else{
                    System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                continue;
            }
            
        }
        treinadores.add(treinadorAAdicionar);
//        System.out.println(treinadorAAdicionar);
    }
    public void registarTreinadorAssistente(List<TreinadorAssistente> treinadoresAssistente){
        TreinadorAssistente treinadorAAdicionar = new TreinadorAssistente();
        System.out.println("Introduza o nome do treinador: ");
        boolean validoNome = true;

        while(validoNome){
            String nomeTreinador = leitura.nextLine().trim();
            if (percorrerTreinadoresAssistente(treinadoresAssistente, nomeTreinador)){
                System.out.println("Esse treinador já existe, introduza outro");
                continue;
            }
            else if(contemNumeros(nomeTreinador)){
                System.out.println("O nome do treinador não pode ter números, introduza um nome válido");
            }
            else if(nomeTreinador.trim().isEmpty()){
                 System.out.println("Introduza um nome válido");
                continue;
            }
            else{
                validoNome = false;
                treinadorAAdicionar.setNome(nomeTreinador.trim());
                break;
            }
        }

        boolean validoIdade = true;
        System.out.println("Introduza a idade do treinador entre 21 anos e 100 anos: ");
        while(validoIdade){
            String idadeTreinadorLeitura = leitura.nextLine().trim();
            if(contemLetras(idadeTreinadorLeitura)){
                System.out.println("A idade não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(idadeTreinadorLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma idade válida");
                continue;
            }
            int idadeTreinador=0;
            if(idadeTreinadorLeitura.trim().length()==1 || idadeTreinadorLeitura.trim().length()==2 || idadeTreinadorLeitura.trim().length()==3){
                idadeTreinador = Integer.parseInt(idadeTreinadorLeitura.trim());
                if(idadeTreinador >= 21 && idadeTreinador <= 100){
                    validoIdade = false;
                    treinadorAAdicionar.setIdade(idadeTreinador);
                    break;
                }
                else{
                    System.out.println("Introduza uma idade válida entre 21 anos e 100 anos: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza uma idade válida entre 21 anos e 100 anos: ");
                continue;
            }
            
        }
        boolean validoPos=true;
        System.out.println("Introduza a posição preferida do treinador:\n" + "1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
            while(validoPos){
                String posicaoTreinadorLeitura = leitura.nextLine().trim();
                if(contemLetras(posicaoTreinadorLeitura)){
                    System.out.println("A posição deve ser um número. Introduza novamente: ");
                    continue;
                }
                else if(posicaoTreinadorLeitura.trim().isEmpty()){
                    System.out.println("Introduza uma opção válida");
                    continue;
                }
                int posicaoTreinadorInt=0;
                if(posicaoTreinadorLeitura.length()==1){
                    posicaoTreinadorInt = Integer.parseInt(posicaoTreinadorLeitura);
                    String posicaoTreinador = posicaoAdvemOpcao(posicaoTreinadorInt);
                    if(posicaoTreinador.equalsIgnoreCase("Essa posição não existe")){
                        System.out.println("Introduza uma opção válida:\n1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
                    }
                    else{
                        validoPos = false;
                        treinadorAAdicionar.setPosicaopreferida(posicaoTreinador.trim());  
                        break;
                    }
                }
                else{
                    System.out.println("Introduza uma opção válida:\n1. GR\n2. DEFESA\n3. MEDIO\n4. ATACANTE");
                    continue;
                }
                   
            }
        boolean validoOverall = true;
        System.out.println("Introduza o overall entre 1 e 99:");
        while(validoOverall ){
            String overallLeitura = leitura.nextLine().trim();
            if(contemLetras(overallLeitura)){
                System.out.println("A overall não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(overallLeitura.trim().isEmpty()){
                 System.out.println("Introduza um overall válido");
                continue;
            }
            int overall=0;
            if(overallLeitura.trim().length()==1 || overallLeitura.trim().length()==2){
                overall = Integer.parseInt(overallLeitura.trim());
                if(overall >= 1 && overall <= 99){
                    validoOverall = false;
                    treinadorAAdicionar.setOverall(overall);
                    break;
                }
                else{
                    System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza um overall válido entre 1 anos e 99: ");
                continue;
            }
            
        }
            treinadoresAssistente.add(treinadorAAdicionar);
        
    }
    //So pode ter 1 guarda redes
    public void registarEquipa(List<Liga> ligas,List<Jogador> jogadores,List <Equipa> equipas,List <TreinadorPrincipal> treinadores,List <TreinadorAssistente> treinadoresAssistente) {
       Equipa EquipaAAdicionar = new Equipa();
       int escolherTreinadorLeituraInt=0;
       int escolherGRLeituraInt=0;
       int valorLiga=-1;
       if(mostrarJogadoresPos("GR",jogadores).size()==0 || 
                mostrarJogadoresPos(jogadores).size()==0 || mostrarTreinadoresPrincipal(treinadores).size()==0
               || mostrarTreinadoresAssistente(treinadoresAssistente).size()==0){
            System.out.println("Não existe elementos suficientes para formar uma equipa: ");
            return;
        }
        System.out.println("Introduza o nome da equipa: ");
        boolean validoNome=true;
        while(validoNome){
            String nomeEquipa = leitura.nextLine().trim();
            if(percorrerEquipas(equipas,nomeEquipa.trim())){
                System.out.println("Essa equipa já existe, introduza outra");
                continue;
            }
            else if(contemNumeros(nomeEquipa)){
                System.out.println("O nome da equipa não pode ter números, introduza um nome válido");
                continue;
            }
            else if(nomeEquipa.trim().isEmpty()){
                System.out.println("Introduza um nome de equipa válido");
                continue;
            }
            else{
                validoNome=false;
                EquipaAAdicionar.setNome(nomeEquipa);
                break;
                
            }    
        
        }
        
        boolean validoLiga = true;
        int percorrerLigasInt=0;
        System.out.println("Introduza a liga da equipa: ");
        String copialigaLeitura="";
        while(validoLiga){
            String ligaLeitura = leitura.nextLine().trim();
            copialigaLeitura=ligaLeitura;
            if(contemNumeros(ligaLeitura)){
                System.out.println("A equipa não pode conter números. Introduza novamente: ");
                continue;
            }
            else if(ligaLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma liga válida");
                continue;
            }
            else{
              validoLiga=false;
              
              for(int z=0;z<ligas.size();z++){
                  if(ligas.get(z).getNome().equalsIgnoreCase(ligaLeitura)){
                      if(ligas.get(z).getjornada()<ligas.get(z).getequipas().size()+1){
                          EquipaAAdicionar.setLiga(ligas.get(z).getNome());
                          valorLiga=z;
                      }
                      else{
                         System.out.println("Não é possível adicionar uma equipa depois de ter começado a segunda volta");
                         return; 
                      }
                      
                      
                  }
              }
              break;
            } 
        }
        boolean validoTreinadorPrincipal = true;
        int posTreinadorPrincipalInt=-1;
        System.out.println("Escolha um treinador principal: ");
        while(validoTreinadorPrincipal){
            for(int i=0;i<mostrarTreinadoresPrincipal(treinadores).size();i++){
                System.out.println(i + 1 + ". " + mostrarTreinadoresPrincipal(treinadores).get(i).getNome());
            }
            String treinadorLeitura = leitura.nextLine().trim();
            
            
            if(contemLetras(treinadorLeitura)){
                System.out.println("Introduza uma opcao válida,sem letras: ");
                continue;
            }
            else if(treinadorLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma opcao válida");
                continue;
            }
            else if(mostrarTreinadoresPrincipal(treinadores).size()>0){
              posTreinadorPrincipalInt = Integer.parseInt(treinadorLeitura);
              posTreinadorPrincipalInt--;
              validoTreinadorPrincipal=false;
              EquipaAAdicionar.setTreinadorPrincipal(mostrarTreinadoresPrincipal(treinadores).get(posTreinadorPrincipalInt));
              break;
            } 
        }
        boolean validoTreinadorAssistente = true;
        int posTreinadorAssistenteInt=-1;
        System.out.println("Escolha um treinador assistente: ");
        while(validoTreinadorAssistente){
            for(int i=0;i<mostrarTreinadoresAssistente(treinadoresAssistente).size();i++){
                System.out.println(i + 1 + ". " + mostrarTreinadoresAssistente(treinadoresAssistente).get(i).getNome());
            }
            String treinadorLeituraAssistente = leitura.nextLine().trim();
            
            
            if(contemLetras(treinadorLeituraAssistente)){
                System.out.println("Introduza uma opcao válida,sem letras: ");
                continue;
            }
            else if(treinadorLeituraAssistente.trim().isEmpty()){
                 System.out.println("Introduza uma opcao válida");
                continue;
            }
            else if(mostrarTreinadoresAssistente(treinadoresAssistente).size()>0){
              posTreinadorAssistenteInt = Integer.parseInt(treinadorLeituraAssistente);
              posTreinadorAssistenteInt--;
              validoTreinadorAssistente=false;
              EquipaAAdicionar.setTreinadorAssistente(mostrarTreinadoresAssistente(treinadoresAssistente).get(posTreinadorAssistenteInt));
              break;
            } 
        }
        boolean validoGR = true;
        int posJogadorInt=0;
        System.out.println("Escolha um treinador: ");
        
        while(validoGR){
            for(int i=0;i<mostrarJogadoresPos("GR",jogadores).size();i++){
                System.out.println(i + 1 + ". " + mostrarJogadoresPos("GR",jogadores).get(i).getNome() + "-" +
                mostrarJogadoresPos("GR",jogadores).get(i).getPosJogador());
            }
            String gkLeitura = leitura.nextLine().trim();
            
            
            if(contemLetras(gkLeitura)){
                System.out.println("Introduza uma opcao válida,sem letras: ");
                continue;
            }
            else if(gkLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma opcao válida");
                continue;
            }
            else if(mostrarJogadoresPos("GR",jogadores).size()>0){
              posJogadorInt = Integer.parseInt(gkLeitura);
              posJogadorInt--;
              validoGR=false;
              EquipaAAdicionar.addJogadores(jogadores,mostrarJogadoresPos("GR",jogadores).get(posJogadorInt));
              break;
            } 
        }
        boolean validoRestoJogadores = true;
        int posRestoJogadorInt=0;
        List<Integer> posJogadorAAdicionarInt= new ArrayList();
        System.out.println("Escolha os restantes jogadores: ");

while (validoRestoJogadores) {
    for (int i = 0; i < mostrarJogadoresPos(jogadores).size(); i++) {
    System.out.println(i + 1 + ". " + mostrarJogadoresPos(jogadores).get(i).getNome() + "-" + mostrarJogadoresPos(jogadores).get(i).getPosJogador());
    }
    String posLeitura = leitura.nextLine().trim();

    if (contemLetras(posLeitura) || posLeitura.isEmpty()) {
        System.out.println("Introduza uma opção válida, sem letras: ");
        continue;
    }

    posRestoJogadorInt = Integer.parseInt(posLeitura) - 1;

    if (posRestoJogadorInt < 0 || posRestoJogadorInt >= mostrarJogadoresPos(jogadores).size()) {
        System.out.println("Introduza uma opção válida");
        continue;
    }

    posJogadorAAdicionarInt.add(posRestoJogadorInt);
    EquipaAAdicionar.addJogadores(jogadores, mostrarJogadoresPos(jogadores).get(posRestoJogadorInt));

    if (EquipaAAdicionar.getJogadoresLista().size() == 11) {
        validoRestoJogadores = false;
        equipas.add(EquipaAAdicionar);
        break;
    }
    
        
    
    
}
    if(valorLiga!=-1){
        ligas.get(valorLiga).addequipa(EquipaAAdicionar);
    }
    if(!percorrerLigas(ligas,copialigaLeitura)){
       Liga novaLiga=new Liga(copialigaLeitura.trim());
       EquipaAAdicionar.setLiga(novaLiga.getNome());
       novaLiga.addequipa(EquipaAAdicionar);
       ligas.add(novaLiga);
                  
        }
//System.out.println(ligas.get(valorLiga));
//System.out.println(ligas);
}
    
    public Jogador removerJogador(List<Jogador> lista, int indice) {
    Jogador jogadorRemovido = lista.remove(indice);
    return jogadorRemovido;
}
    public boolean percorrerArbitros(List<Arbitro> arbitros,String nomeArbitro){
        for(int i=0;i<arbitros.size();i++){
            if(arbitros.get(i).getNome().equalsIgnoreCase(nomeArbitro)){
                return true;
            }
        }
        return false;
    }
    public void registarArbitro(List<Arbitro> arbitros) {
        Arbitro arbitroAAdicionar = new Arbitro();
        System.out.println("Introduza o nome do arbítro: ");
        boolean validoNome=true;
        while(validoNome){
            String nomeArbitro = leitura.nextLine().trim();
            if(percorrerArbitros(arbitros,nomeArbitro.trim())){
                System.out.println("Já existe um arbítro com esse nome, introduza outro");
                continue;
            }
            else if(contemNumeros(nomeArbitro)){
                System.out.println("O nome do arbítro não pode ter números, introduza um nome válido");
                continue;
            }
            else if(nomeArbitro.trim().isEmpty()){
                System.out.println("Introduza um nome válido");
                continue;
            }
            else{
                validoNome=false;
                arbitroAAdicionar.setNome(nomeArbitro.trim());
                break; 
            }    
        }
        boolean validoIdade = true;
        System.out.println("Introduza a idade do arbítro entre 16 anos e 50 anos: ");
        while(validoIdade){
            String idadeArbitroLeitura = leitura.nextLine().trim();
            if(contemLetras(idadeArbitroLeitura)){
                System.out.println("A idade não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(idadeArbitroLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma idade válida");
                continue;
            }
            int idadeArbitro=0;
            if(idadeArbitroLeitura.trim().length()==1 || idadeArbitroLeitura.trim().length()==2){
                idadeArbitro = Integer.parseInt(idadeArbitroLeitura.trim());
                if(idadeArbitro >= 16 && idadeArbitro <= 50){
                    validoIdade = false;
                    arbitroAAdicionar.setIdade(idadeArbitro);
                    break;
                }
                else{
                    System.out.println("Introduza uma idade válida entre 16 anos e 50 anos: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza uma idade válida entre 16 anos e 50 anos: ");
                continue;
            }
            
        }
        boolean validoanosExperienciaArbitro = true;
        System.out.println("Introduza os anos de experiencia entre 0 anos e 30 anos: ");
        while(validoanosExperienciaArbitro){
            String anosExperienciaArbitroLeitura = leitura.nextLine().trim();
            if(contemLetras(anosExperienciaArbitroLeitura)){
                System.out.println("Anos de experiencia não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(anosExperienciaArbitroLeitura.trim().isEmpty()){
                 System.out.println("Introduza anos de experiencia válidos");
                continue;
            }
            int anosExperienciaArbitro=0;
            if(anosExperienciaArbitroLeitura.trim().length()==1 || anosExperienciaArbitroLeitura.trim().length()==2){
                anosExperienciaArbitro = Integer.parseInt(anosExperienciaArbitroLeitura.trim());
                if(anosExperienciaArbitro >= 0 && anosExperienciaArbitro <= 30){
                    validoIdade = false;
                    arbitroAAdicionar.setIdade(anosExperienciaArbitro);
                    break;
                }
                else{
                    System.out.println("Introduza os anos de experiencia entre 0 anos e 30 anos: ");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza os anos de experiencia entre 0 anos e 30 anos: ");
                continue;
            } 
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
    public List<Equipa> equipaLigasDisp(List<Equipa> equipas){
        List<Equipa> equipasQueNaoTemLiga=new ArrayList();
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getLiga().equals("")){
                equipasQueNaoTemLiga.add(equipas.get(i));
            }
        }
        return equipasQueNaoTemLiga;
    }
    public void voltarAoMenu(List<Liga> ligas, List<Equipa> equipas,List<TreinadorPrincipal> treinadoresPrincipal,List<Jogador> jogadores,List<Arbitro> arbitros,List<TreinadorAssistente> treinadoresAssistente) {
        Menu menu = new Menu();
        while(true){
            menu.opcoes();
            menu.escolha(ligas, equipas, treinadoresPrincipal, jogadores, arbitros, treinadoresAssistente, this);
        }
    }
}
