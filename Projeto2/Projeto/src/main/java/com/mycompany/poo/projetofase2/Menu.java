/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Paulo
 */
public class Menu implements Comum {
    Scanner leitura = new Scanner(System.in);
    public void opcoes(){
        System.out.println("1. Aceder informações de um jogador \n2. Aceder informações de um treinador \n"
                + "3. Aceder informações de uma equipa \n4. Criar uma partida \n"
                + "5. Estatísticas de Equipa" +"\n6. Mostrar tabela de uma liga" + "\n7. Ir para o submenu"+"\n8. Sair");
    }
    public boolean escolhavalida(String a){
        if(a.isEmpty()){
            return false;
        }
        else if(a.length() > 1){
            return false;
        }
        else if(a.length() == 1){
            int b = a.charAt(0); //converte char para o valir int da tabela ASCII
            if ((b >=49) && (b <= 57)){
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
   
    
    public void acederinfojogadores(List <Liga> ligas){
        System.out.println("Digite o nome completo do jogador: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                for(int k = 0; k<ligas.get(j).getequipas().get(i).getJogadoresatuais().size(); k++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getJogadoresatuais().get(k).getNome())){
                        System.out.println("Equipa: " + ligas.get(j).getequipas().get(i).getNome());
                        ligas.get(j).getequipas().get(i).getJogadoresatuais().get(k).mostrarinfojogador();
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                    }
        
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void acederinfotreinadores(List <Liga> ligas){
        System.out.println("Digite o nome completo do Treinador: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getTreinadorPrincipal().nome)){
                        System.out.println(ligas.get(j).getequipas().get(i).getTreinadorPrincipal());
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void acederinfoequipa(List <Liga> ligas){
        System.out.println("Digite o nome da equipa: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getNome())){
                        ligas.get(j).getequipas().get(i).DesempenhoMedio();
                        System.out.println(ligas.get(j).getequipas().get(i));
                        System.out.println("Jogadores:");
                        for(int k=0; k<ligas.get(j).getequipas().get(i).getJogadoresatuais().size();k++){
                            ligas.get(j).getequipas().get(i).getJogadoresatuais().get(k).mostrarinfojogador();
                        }
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Nome não existe!");
        }
    }
    
    public void criarpartida(List <Liga> ligas){
        boolean continuar = false;
        Liga escolhida = new Liga();
        while(!continuar ){
            System.out.println("Digite a liga onde quer criar uma partida: ");
            String escolha = leitura.nextLine();
            for(int i = 0; i < ligas.size(); i ++){
                if(ligas.get(i).getNome().equalsIgnoreCase(escolha)){
                    continuar = true;
                    escolhida = ligas.get(i);
                    break;
                }
            }
            if(!continuar){
                System.out.println("Liga não existe");
            }
            else{
                System.out.println("Criando uma partida da liga escolhida...");
            }
        }
        if(escolhida.getequipas().size() >= 2 && escolhida.getequipas().size()%2 ==0 && escolhida.getarbitros().size() > 0){
        escolhida.atualizarn_jornadas();
        escolhida.criarpartida();
        System.out.println("partida criada");
        Partida partida = escolhida.Getpartidas().get(escolhida.Getpartidas().size()-1);
        System.out.println("A partida criada foi: ");
        System.out.println(partida.toString());
        System.out.println("Executando partida...");
        if(partida.getequipa_casa().getJogadoresLista().size() >= 7 && partida.getequipa_visitante().getJogadoresLista().size() >= 7){
            System.out.println("A equipa que começa com a posse de bola é:" + partida.getArbitro().lancarMoedaAoAr(partida.getequipa_casa(), partida.getequipa_visitante()));
            partida.executarpartida();
        }
        else{
            if(partida.getequipa_casa().getJogadoresLista().size() >= 7 && partida.getequipa_visitante().getJogadoresLista().size() < 7){
                System.out.println("A equipa visitante não tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_casa().setNumeroVitorias(partida.getequipa_casa().getNumeroVitorias() + 1);
                partida.getequipa_casa().setNumeroGolos(partida.getequipa_casa().getNumeroGolos() + 3);
                partida.getequipa_visitante().setNumeroDerrotas(partida.getequipa_visitante().getNumeroDerrotas() + 1);
                partida.getequipa_visitante().setNumeroGolosSofridos(partida.getequipa_visitante().getNumeroGolosSofridos() + 3);
                partida.setGolos_marcados_casa(partida.getGolos_marcados_casa() + 3);
                partida.setresultado();
                partida.terminou();
            }
            else if(partida.getequipa_visitante().getJogadoresLista().size() >= 7 && partida.getequipa_casa().getJogadoresLista().size() < 7){
                System.out.println("A equipa da casa não tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_visitante().setNumeroVitorias(partida.getequipa_visitante().getNumeroVitorias() + 1);
                partida.getequipa_visitante().setNumeroGolos(partida.getequipa_visitante().getNumeroGolos() + 3);
                partida.getequipa_casa().setNumeroDerrotas(partida.getequipa_casa().getNumeroDerrotas() + 1);
                partida.getequipa_casa().setNumeroGolosSofridos(partida.getequipa_casa().getNumeroGolosSofridos() + 3);
                partida.setGolos_sofridos_casa(partida.getGolos_sofridos_casa() + 3);
                partida.setresultado();
                partida.terminou();
            }
            else if(partida.getequipa_visitante().getJogadoresLista().size() < 11 && partida.getequipa_casa().getJogadoresLista().size() < 11){
                System.out.println("Nenhuma das equipas tem jogadores suficientes para iniciar a partida.");
                partida.getequipa_casa().setNumeroEmpates(partida.getequipa_casa().getNumeroEmpates() + 1);
                partida.getequipa_visitante().setNumeroEmpates(partida.getequipa_visitante().getNumeroEmpates() + 1);
                partida.setresultado();
                partida.terminou();
            }
        }
        System.out.println("A informação final da partida foi: ");
        System.out.println(partida.toString());
        }
        else{
            System.out.println("Uma liga tem de ter pelo menos 2 equipas e um número par de equipas para poder decorrer! Tem ainda de ter pelo menos um árbitro");
        }
        
    }
    
    public void escolha(List<Liga> ligas, List<Equipa> equipas,List<TreinadorPrincipal> treinadoresPrincipal,List<Jogador> jogadores,List<Arbitro> arbitros,List<TreinadorAssistente> treinadoresAssistente,SubMenu submenu){
        for(int i=0; i< ligas.size(); i++){
            for(int j = 0; j < ligas.get(i).getequipas().size(); j++){
                ligas.get(i).getequipas().get(j).definir_jogadores_totais(); // atualizar lista de jogadores de todas as equipas
            }
        }
        System.out.println("Escolha uma das opções: ");
        String escolha = leitura.nextLine();
        boolean sair=true;
        while(!escolhavalida(escolha)&& sair){
            System.out.println("Opção inválida! Escolha uma opção entre 0 e 9: ");
            escolha = leitura.nextLine();
        }
        int escolhaint = escolha.charAt(0) - 48;
        switch(escolhaint){
            case 1:
                acederinfojogadores(ligas);
                break;
            case 2:
                acederinfotreinadores(ligas);
                break;
            case 3:
                acederinfoequipa(ligas);
                break;
            case 4:
                criarpartida(ligas);
                break;
            case 5:
                estatisticasEquipa(ligas);
                break;
            case 6:
                mostrartabela(ligas);
                break;
            case 7:
                while(true){
                submenu.opcoes();
                submenu.escolha(ligas, equipas, treinadoresPrincipal, jogadores, arbitros, treinadoresAssistente);
                }
                
            case 8:
                System.exit(0);
                break;
                
             
        }
    }
    
    public boolean nomeEquipaExistente(List <Equipa> equipas,String nomeDaEquipa){
        
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getNome()==nomeDaEquipa){
                return true;
            }
            
        }
        return false;
        
    }
    public int ligaExisteNomeEquipa(List <Liga> ligas,String nome){
       
        for(int i=0;i<ligas.size();i++){
            if(nome.equalsIgnoreCase(ligas.get(i).getNome())){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<String> equipasMesmaLiga(List <Liga> ligas,List <Equipa> equipas,String nome){
  
        ArrayList<String> temp=new ArrayList();
        for(int i=0;i<equipas.size();i++){
            if(equipas.get(i).getLiga().equalsIgnoreCase(nome)){
                temp.add(equipas.get(i).getNome());
            }
            
        }
        return temp;
    }
    public ArrayList<String> equipasDaLiga(List <Liga> ligas,String nome){
        int indiceLiga = ligaExisteNomeEquipa(ligas, nome);
        ArrayList<String> temp=new ArrayList();
        for(int i=0;i<ligas.get(indiceLiga).getequipas().size();i++){
            temp.add(ligas.get(indiceLiga).getequipas().get(i).getNome());
        }
        return temp;  
    }
    //funcao que remove o que está em comum entre duas Listas
    public void unicaEquipaQuePossoAdicionar(ArrayList<String> lista1,ArrayList<String> lista2){
        ArrayList<String> temp=new ArrayList();
        lista2.removeAll(lista1);  
    }
    
    //Equipas que estao na Liga
    public void associarEquipaLiga(List<Liga> ligas, List<Equipa> equipas) {
    System.out.println("Digite a Liga: ");
    String nome = leitura.nextLine();
    int indiceLiga = ligaExisteNomeEquipa(ligas, nome);
    if (indiceLiga == -1) {
        System.out.println("Liga não encontrada. Por favor, insira uma liga válida.");
        return;
    }
    ArrayList<String> listaTodasEquipaLiga = equipasDaLiga(ligas, nome);
    Collections.sort(listaTodasEquipaLiga);

    ArrayList<String> listaEquipasCriadas = equipasMesmaLiga(ligas, equipas, ligas.get(indiceLiga).getNome());
    Collections.sort(listaEquipasCriadas);
    unicaEquipaQuePossoAdicionar(listaTodasEquipaLiga, listaEquipasCriadas);

    System.out.println("Escolha a equipa que quer associar a uma liga:\n");
    String nomeEquipa;
    for (int i = 0; i < listaEquipasCriadas.size(); i++) {
        System.out.print((i + 1) + "-" + listaEquipasCriadas.get(i) + "\n");
    }
    String equipa = leitura.nextLine();
    int indiceEquipa = Integer.parseInt(equipa) - 1;
    nomeEquipa = listaEquipasCriadas.get(indiceEquipa);
    Equipa equipaAAdicionar = null;

    for (int l = 0; l < equipas.size(); l++) {
        if (equipas.get(l).getLiga().equalsIgnoreCase(nome)) {
            if (nomeEquipa.equalsIgnoreCase(equipas.get(l).getNome())) {
                equipaAAdicionar = equipas.get(l);
            }
        }
    }

    ligas.get(indiceLiga).addequipa(equipaAAdicionar);

    for (int k = 0; k < ligas.get(indiceLiga).getequipas().size(); k++) {
        System.out.println("\n"+ligas.get(indiceLiga).getequipas().get(k));
    }
}
public void estatisticasEquipa(List <Liga> ligas){
        System.out.println("Digite o nome da equipa: ");
        String nome = leitura.nextLine();
        boolean existe = false;
        for(int j=0; j<ligas.size(); j++){
            for(int i=0; i< ligas.get(j).getequipas().size(); i++){
                    if(nome.equalsIgnoreCase(ligas.get(j).getequipas().get(i).getNome())){
                        ligas.get(j).getequipas().get(i).DesempenhoMedio();
                        System.out.println(ligas.get(j).getequipas().get(i));
                        existe = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }   
            }
        if(!existe){
            System.out.println("Equipa não existe!");
        }
    }
public void mostrartabela(List <Liga> ligas){
        boolean continuar = false;
        Liga escolhida = new Liga();
        while(!continuar ){
            System.out.println("Digite a liga que quer ver a tabela: ");
            String escolha = leitura.nextLine();
            for(int i = 0; i < ligas.size(); i ++){
                if(ligas.get(i).getNome().equalsIgnoreCase(escolha)){
                    continuar = true;
                    escolhida = ligas.get(i);
                    break;
                }
            }
            if(!continuar){
                System.out.println("Liga não existe");
            }
            else{
                System.out.println("Liga: " + escolhida.getNome());
            }
        }
        System.out.println("Jornada nº" + escolhida.getjornada() + "\n");
        System.out.println("Equipas | NºJogos | NºVitorias | NºDerrotas | NºEmpates | NºGolos marcados | NºGolos sofridos | Pontos");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for(int j = 0; j<escolhida.getequipas().size(); j++){
            Equipa atual = escolhida.getequipas().get(j);
            System.out.println(atual.getNome() +" | " + atual.n_jogos() + " | " + atual.getNumeroVitorias() + " | " + atual.getNumeroDerrotas() + " | " + atual.getNumeroEmpates() + " | " + atual.getNumeroGolos() + " | " + atual.getNumeroGolosSofridos() + " | " + atual.pontos());
        }
}       
   public void menuCaminho(List<Liga> ligas, List<Equipa> equipas,
    List<TreinadorPrincipal> treinadores,List<Jogador> jogadores,
    List<Arbitro> arbitros,List<TreinadorAssistente> treinadores_ass,SubMenu submenu,Menu menu)throws IOException{
        boolean validoOpcao = true;
        System.out.println("1.Inserir manualmente\n2.Inserir através de ficheiros");
        String opcaoLeitura = leitura.nextLine().trim();
        int opcaoLeituraInt=0;
        while(validoOpcao){ 
            if(contemLetras(opcaoLeitura)){
                System.out.println("A opção não pode conter letras. Introduza novamente: ");
                continue;
            }
            else if(opcaoLeitura.trim().isEmpty()){
                 System.out.println("Introduza uma opção válida");
                continue;
            }
            if(opcaoLeitura.trim().length()==1){
                opcaoLeituraInt = Integer.parseInt(opcaoLeitura.trim());
                if(opcaoLeituraInt==1 || opcaoLeituraInt==2){
                    validoOpcao=false;
                    break;
                }
                else{
                    System.out.println("Introduza uma opção válida");
                    continue;
                }      
            }
            else{
                System.out.println("Introduza uma opção válida");
                continue;
            }
   }
        if(opcaoLeituraInt==1){ 
            while(true){
            submenu.opcoes();
            submenu.escolha(ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            }
            
        }
        if(opcaoLeituraInt==2){
            String caminho="";
            Leitura leitura = new Leitura();
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\Porto.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\Benfica.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\Braga.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\CdNacional.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\Sporting.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Liga-Portuguesa\\Estoril.txt";
            leitura.lerFicheiroEquipa(caminho,ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            caminho = "C:\\Users\\Paulo\\Documents\\NetBeansProjects\\poo.projetofase2\\src\\main\\java\\com\\mycompany\\poo\\projetofase2\\Arbitros.txt";
            leitura.lerFicheiroArbitro(caminho, ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass);
            //adicionar todos os arbitros liga portuguesa
            //como so existe 1 liga é adicionado à portuguesa
            if(ligas.size()==1){
                for(int k=0;k<treinadores.size();k++){
                    ligas.get(0).addarbitro(arbitros.get(k));
                }
            }
            
            
            while(true){
                menu.opcoes();
                menu.escolha(ligas, equipas, treinadores, jogadores, arbitros, treinadores_ass, submenu);
            }
        }
        
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
}
