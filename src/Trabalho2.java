
import java.util.Scanner;
/**
 *
 * @author Lucas Amiune
 * data:   16/10/2017
 */
public class Trabalho2 {
    
    public static void main(String[] args) {

        int linha, coluna;
        Scanner teclado = new Scanner(System.in);
        Tabuleiro tabLabirinto = new Tabuleiro();
        Robo johnnyWalker = new Robo();
        
        //Perguntando ao usuários onde ficarão os obstáculos.
        while (tabLabirinto.getQtdObstaculos() <= 7) {
            
            System.out.println("Por favor insira o obstaculo numero "+ tabLabirinto.getQtdObstaculos());
            System.out.print("Insira um valor para a linha: ");
            linha = teclado.nextInt();
            System.out.print("Insira um valor para a coluna: ");
            coluna = teclado.nextInt();
            
            if (linha >= 13) {
                System.out.println("Desculpe, impossivel adicionar obstaculo aqui, obstaculo vai passar o tabuleiro");
            } else {
                tabLabirinto.adicionarObstaculo(linha, coluna);
                tabLabirinto.setQtdObstaculos(tabLabirinto.getQtdObstaculos()+1);
            }
        }
        //Fim de adiciocar os obstáculos
        
        tabLabirinto.desenharTabuleiro();
        johnnyWalker.andarRobo(tabLabirinto);
        //tabLabirinto.desenharTabuleiro();
    }
}
