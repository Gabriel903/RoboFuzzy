
import java.util.Random;

public class Robo {
    
   private PosicaoXY posicao;
   private int       linhaSaida  = 14;
   private int       colunaSaida = 14;
   private boolean   isAndando   = true;
    
   public Robo(){
      this.posicao = new PosicaoXY(0,0);
   }
   
   public void andarRobo2(Tabuleiro tab) {
       
       int x = posicao.getPosX();
       int y = posicao.getPosY();
        
       while (isAndando) {
           if (posicao.getPosX() < linhaSaida) {
               posicao.setPosX(x++);
           }
           if (posicao.getPosY() < colunaSaida) {
               posicao.setPosY(y++);
           }
           tab.gravarPasso(posicao.getPosX(), posicao.getPosY());
           
           if ((posicao.getPosX() == 14) && (posicao.getPosY() == 14)) {
               isAndando = false;
           }
       } 
    }
   
   public void andarRobo(Tabuleiro tab) {
        
       while (isAndando) {
           
           posicao = testarPasso(tab, posicao);
           
           tab.gravarPasso(posicao.getPosX(), posicao.getPosY());
           tab.desenharTabuleiro();
           
           if ((posicao.getPosX() == 14) && (posicao.getPosY() == 14)) {
               isAndando = false;
           }
       } 
   }
    
   public PosicaoXY testarPasso(Tabuleiro tab, PosicaoXY pPosicao) {
       
       boolean proximoPasso  = false;
       
       while(!proximoPasso) {
           
            boolean andarCima     = false;
            boolean andarDireita  = false;
            boolean andarBaixo    = false;
            boolean andarEsquerda = false;
           
            //Testando passos verticais
            if ((pPosicao.getPosX() >0) && (pPosicao.getPosX() <=14)) {
                 if (tab.getValorEspaco(pPosicao.getPosX()-1, pPosicao.getPosY()) != 1) {
                     andarCima = true;
                 }
            }
            if ((pPosicao.getPosX() >=0) && (pPosicao.getPosX() <14)) {
                 if (tab.getValorEspaco(pPosicao.getPosX()+1, pPosicao.getPosY()) != 1) {
                     andarBaixo = true;
                 }
            }
            //Testando passos horizontais
            if ((pPosicao.getPosY() >=0) && (pPosicao.getPosY() <14)) {
                 if (tab.getValorEspaco(pPosicao.getPosX(), pPosicao.getPosY()+1) != 1) {
                     andarDireita = true;
                 }
             }
             if ((pPosicao.getPosY() >0) && (pPosicao.getPosY()<=14))  {
                 if (tab.getValorEspaco(pPosicao.getPosX(), pPosicao.getPosY()-1) != 1) {
                     andarEsquerda = true;
                 }
             }   
        
        
            Random rand = new Random();
            int proxPasso = rand.nextInt(5);

            switch(proxPasso) {
                case 1: 
                    if (andarCima) {
                        pPosicao.setPosX(pPosicao.getPosX()-1);
                        proximoPasso = true;
                    }
                break;
                case 2: 
                    if (andarBaixo) {
                        pPosicao.setPosX(pPosicao.getPosX()+1);
                        proximoPasso = true;
                    }
                break;
                case 3: 
                    if (andarEsquerda) {
                        pPosicao.setPosY(pPosicao.getPosY()-1);
                        proximoPasso = true;
                    }
                break;
                case 4: 
                    if (andarDireita) {
                        pPosicao.setPosY(pPosicao.getPosY()+1);
                        proximoPasso = true;
                    }
                break;
                default: proximoPasso = false;
                break;
            }
        }
        return new PosicaoXY(pPosicao.getPosX(), pPosicao.getPosY());
   }
   
}
   
  
   
