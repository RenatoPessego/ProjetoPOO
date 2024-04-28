/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.projetofase2;
import java.util.*;

/**
 *
 * @author Paulo
 */
public class Jogador extends Pessoa {
    private String posicao="";
    private String equipa="";
    private List<Lesoes> historico_lesoes=new ArrayList<>();
    private Ataque info_ataque = new Ataque();
    private Defesa info_defesa = new Defesa();
    private int nivel_agressividade=0;
    private int dias_indisponiveis = 0;
    
    public int getdias_indisponiveis(){
        return dias_indisponiveis;
    }
    public void setdias_indisponiveis(int dias){
        this.dias_indisponiveis = dias;
    }
    
    public Jogador(String nome,int idade,String posicao,int nivel_agressividade){
        this.nome = nome;
        this.idade = idade;
        this.posicao=posicao;
        this.nivel_agressividade=nivel_agressividade;
    }
    public Jogador(String nome,int idade,String posicao,int nivel_agressividade, int overall){
        this.nome = nome;
        this.idade = idade;
        this.posicao=posicao;
        this.nivel_agressividade=nivel_agressividade;
        this.overall = overall;
    }
    public Jogador(){
        
    }
    public Jogador(String nome,int idade){
        this.nome=nome;
        this.idade=idade;
    }
    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }
    public void setNivel_agressividade(int nivel_agressividade){
        this.nivel_agressividade=nivel_agressividade;
    }

    
    public String getPosJogador(){
        return posicao;
    }
    
    public void setPosJogador(String posicao){
        this.posicao=posicao;
    }
    
    public List<Lesoes> getHistoricoLesao(){
        return historico_lesoes;
    }
    
    /*Adiciona uma nova lesao e retorna todas as lesoes do jogador*/
    public List<Lesoes> adicionarHistoricoLesao(List<Lesoes> historico_lesoes,String TipoLesao,String DataLesao){
        historico_lesoes.add(novaLesao(TipoLesao,DataLesao));
        return historico_lesoes;
    }
    public void novaLesaoaleatoria(String DataLesao){
        Random aleatorio = new Random();
        List <String> tipos_lesoes = new ArrayList();
        tipos_lesoes.add("Lesão no joelho");
        tipos_lesoes.add("Lesão no tornozelo");
        tipos_lesoes.add("Lesão na coxa");
        tipos_lesoes.add("Fratura");
        tipos_lesoes.add("Lesão no braço");
        tipos_lesoes.add("Lesão na cabeça");
        tipos_lesoes.add("Lesão no pescoço");
        tipos_lesoes.add("Lesão no tronco");
        int lesao_aleatoria = aleatorio.nextInt(tipos_lesoes.size() - 0) + 0;
        this.historico_lesoes.add(novaLesao(DataLesao, tipos_lesoes.get(lesao_aleatoria)));
    }
    public Lesoes novaLesao(String TipoLesao,String DataLesao){
        Lesoes temp_lesao= new Lesoes(TipoLesao,DataLesao);
        return temp_lesao;
    }
    
    public int numeroLesoes(List<Lesoes> historico_lesoes){
        return historico_lesoes.size();
    }
    
    public Ataque getInfo_ataque() {
        return info_ataque;
    }

    public void setInfo_ataque(Ataque info_ataque) {
        this.info_ataque = info_ataque;
    }

    public Defesa getInfo_defesa() {
        return info_defesa;
    }

    public void setInfo_defesa(Defesa info_defesa) {
        this.info_defesa = info_defesa;
    }
    
    public void listarLesoes(){
        String temp = new String();
        for(int i=0;i<historico_lesoes.size();i++){
            System.out.println(historico_lesoes.toString());
        }
    }
    public String toString(){
        return "Nome Jogador: " + nome + "\nIdade: " + idade +"\nPosicao: " + posicao +
                "\nHistorico de Lesoes: " + historico_lesoes +
                "\nNivel Agressividade: " + this.nivel_agressividade;
        
    }
    
    public int getagressividade(){
        return this.nivel_agressividade;
    }
    
//    // Método para determinar a probabilidade de receber um cartão amarelo
//   private double calcularProbabilidadeCartaoAmarelo() {
//        double baseProbabilidadeCartaoAmarelo = 0.15; // Probabilidade base
//        double incrementoPorAgressividade = 0.05; // Incremento por unidade de agressividade
//
//        return baseProbabilidadeCartaoAmarelo + (nivel_agressividade * incrementoPorAgressividade);
//    }
//       // Método para determinar a probabilidade de receber um cartão vermelho
//    private double calcularProbabilidadeCartaoVermelho() {
//        double baseProbabilidadeCartaoVermelho = 0.01; // Probabilidade base
//        double incrementoPorAgressividade = 0.04; // Incremento por unidade de agressividade
//
//        return baseProbabilidadeCartaoVermelho + (nivel_agressividade * incrementoPorAgressividade);
//    }
//     // Método para verificar se o jogador recebe um cartão amarelo
//    public boolean receberCartaoAmarelo() {
//        Random random = new Random();
//        double probabilidade = calcularProbabilidadeCartaoAmarelo();
//
//        // Gera um número aleatório entre 0 e 1
//        double aleatorio = random.nextDouble();
//
//        // Verifica se o jogador recebe um cartão amarelo com base na probabilidade
//        return aleatorio < probabilidade;//Se o valor gerado for menor do que a probabilidade retorna true
//        // indicando que o jogador deve de receber cartão amarelo,caso contrário false indicando que não deve de receberer cartão amarelo
//    }
//
//    // Método para verificar se o jogador recebe um cartão vermelho
//    public boolean receberCartaoVermelho() {
//        Random random = new Random();
//        double probabilidade = calcularProbabilidadeCartaoVermelho();
//
//        // Gera um número aleatório entre 0 e 1
//        double aleatorio = random.nextDouble();
//
//        // Verifica se o jogador recebe um cartão vermelho com base na probabilidade
//        return aleatorio < probabilidade;//Se o valor gerado for menor do que a probabilidade retorna true
//        // indicando que o jogador deve de receber cartão vermelho,caso contrário false indicando que não deve de receberer cartão vermelho
//    }
    
    public void mostrarinfojogador(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("posição: " + this.posicao);
        System.out.println("nivel de agressividade: " + this.nivel_agressividade);
        System.out.println("Dias indisponível: " + this.dias_indisponiveis);
        System.out.println("Historico de lesoes\n");
        for(int i = 0; i< this.historico_lesoes.size(); i++){
            System.out.println("Data de lesão: "+this.historico_lesoes.get(i).getDataLesao()+"\nTipo de Lesão: "
            + this.historico_lesoes.get(i).getTipoLesao()+ ".\n\n");
        }
        System.out.println("\nEstatísticas de ataque");
        this.info_ataque.mostrarInfoAtaque();
        System.out.println("\nEstatísticas de defesa");
        this.info_defesa.mostrarInfoDefesa();
        System.out.println();
    }
}
