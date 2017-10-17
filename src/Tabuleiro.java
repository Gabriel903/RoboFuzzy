/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucasamiune
 */
public class Tabuleiro {
     
    private int tamTabuleiro   = 15; 
    private int tabuleiro[][]  = new int[tamTabuleiro][tamTabuleiro];
    private int obstaculos[][] = new int[1][3];
    private int qtdObstaculos  = 1;

    public Tabuleiro() {
    }
    
    public void setQtdObstaculos(int valor){
        this.qtdObstaculos = valor;
    }
    
    public int getQtdObstaculos() {
        return this.qtdObstaculos;
    }
     
    public void criarTabuleiro(){
        for (int linha = 0; linha < 15; linha++) {
            for (int coluna = 0; coluna < 15; coluna++) {
                this.tabuleiro[linha][coluna] = 0;
            }
        }
        //      tabuleiro[tamTabuleiro][tamTabuleiro] = 2;
    }
    
    public void adicionarObstaculo(int linha, int coluna){
        this.tabuleiro[linha][coluna]   = 1;
        this.tabuleiro[linha+1][coluna] = 1;
        this.tabuleiro[linha+2][coluna] = 1;
    }
    
    public void gravarPasso(int linha, int coluna){
        this.tabuleiro[linha][coluna] = 2;
    }
    
    public int getValorEspaco(int linha, int coluna) {
        return this.tabuleiro[linha][coluna];
    }
    
    public void desenharTabuleiro() {
    System.out.println("\t1 \t2 \t3 \t4 \t5\t6 \t7 \t8 \t9 \t10\t11 \t12 \t13 \t14 \t15");
        System.out.println();
        try { 
            for (int linha = 0; linha < tabuleiro.length; linha++) {
                System.out.print((linha + 1) + "");
                for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
                    if (tabuleiro[linha][coluna] == -1) {
                        System.out.print("\t" + "R");
                    } else if (tabuleiro[linha][coluna] == 0) {
                        System.out.print("\t" + "*");
                    } else if (tabuleiro[linha][coluna] == 1) {
                        System.out.print("\t" + "X");
                    }  else if (tabuleiro[linha][coluna] == 2) {
                        System.out.print("\t" + "R");
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    
}
