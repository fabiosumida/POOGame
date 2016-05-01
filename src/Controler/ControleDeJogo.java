/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import GameModel.BichinhoVaiVemHorizontal;
import GameModel.GameOver;
import GameModel.Elemento;
import GameModel.Presidente;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {

    public int a=4;
    public void desenhaTudo(ArrayList<Elemento> e, Graphics g){
        for(int i = 1; i < e.size(); i++){
            e.get(i).autoDesenho(g, e);
        }
        e.get(0).autoDesenho(g, e);
    }
    public void processaTudo(ArrayList<Elemento> e){
        
        //se nao nao for nada retornar sem fazer nada
        if(e.isEmpty())
            return;
        //define como principa
        Presidente onom = (Presidente)e.get(0);
        //objeto que esta em cima no momento
        Elemento eTemp;
        //ArrayList<Elemento> bichin = new ArrayList<Elemento>(4);
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            
            if(eTemp.Cima){
                for (i = 1 ; i < e.size() ; i++){
                    Elemento aux = e.get(i);
                    if (aux == eTemp)
                        break;                        
                    if (aux.getPosicao().getLinha()==eTemp.getPosicao().getLinha() && aux.getPosicao().getColuna()==eTemp.getPosicao().getColuna())
                        aux.moveUp();
                }    
            }      
            
            else if(eTemp.Baixo){
                for (i = 1 ; i < e.size() ; i++){
                    Elemento aux = e.get(i);
                    if (aux == eTemp)
                        break;                        
                    if (aux.getPosicao().getLinha()==eTemp.getPosicao().getLinha() && aux.getPosicao().getColuna()==eTemp.getPosicao().getColuna())
                        
                        aux.moveDown();
                }    
            }              
            
            else if(eTemp.Direita){
                for (i = 1 ; i < e.size() ; i++){
                    Elemento aux = e.get(i);
                    if (aux == eTemp)
                        break;                        
                    if (aux.getPosicao().getLinha()==eTemp.getPosicao().getLinha() && aux.getPosicao().getColuna()==eTemp.getPosicao().getColuna())
                        aux.moveRight();
                }    
            }     
            
            else if(eTemp.Esquerda){
                for (i = 1 ; i < e.size() ; i++){
                    Elemento aux = e.get(i);
                    if (aux == eTemp)
                        break;                        
                    if (aux.getPosicao().getLinha()==eTemp.getPosicao().getLinha() && aux.getPosicao().getColuna()==eTemp.getPosicao().getColuna())
                        aux.moveLeft();
                }    
            }
                    
            if(onom.getPosicao().igual(eTemp.getPosicao()))
                //if(eTemp.isbVuneravel())
                    //e.remove(eTemp);
                if(eTemp.isbMortal()){
                    //bichin.add(eTemp);
                    e.add(new GameOver("gameover.png"));
                    //acabar o jogo
                }
            
                else if(eTemp.isbArrastavel()){
                        onom.getPosicao().volta();
                        if(onom.isMovingUp){
                            if (ehPosicaoValidax(e, eTemp.pPosicao)){
                                eTemp.moveUp();                  
                            }
                        }
                        if(onom.isMovingLeft){
                            if (ehPosicaoValidax(e, eTemp.pPosicao)){
                                eTemp.moveLeft();          
                            }
                        }    
                        if(onom.isMovingRight){
                             if (ehPosicaoValidax(e, eTemp.pPosicao)){
                                eTemp.moveRight(); 
                             }
                        }
                                                            
                        if(onom.isMovingDown){
                            if (ehPosicaoValidax(e, eTemp.pPosicao)){
                                eTemp.moveDown();     
                            }
                        }    
                }
                else if(eTemp.Cima){
                    int k=0;
                    for (i=0 ; i < e.size() ; i++){
                        Elemento aux = e.get(i);
                        if (aux.getPosicao().getColuna()==onom.getPosicao().getColuna() && aux.getPosicao().getLinha() == onom.getPosicao().getLinha()-1 && aux.isbBloqueante())
                            k=1;
                    }
                    if (k==0)
                        onom.moveUp();
                }
                else if(eTemp.Baixo){
                    int k=0;
                    for (i=0 ; i < e.size() ; i++){
                        Elemento aux = e.get(i);
                        if (aux.getPosicao().getColuna()==onom.getPosicao().getColuna() && aux.getPosicao().getLinha() == onom.getPosicao().getLinha()+1 && aux.isbBloqueante())
                            k=1;
                    }          
                    if (k==0)
                        onom.moveDown();
                }
                else if(eTemp.Esquerda){ 
                    int k=0;
                    for (i=0 ; i < e.size() ; i++){
                        Elemento aux = e.get(i);
                        if (aux.getPosicao().getColuna()==onom.getPosicao().getColuna()-1 && aux.getPosicao().getLinha() == onom.getPosicao().getLinha() && aux.isbBloqueante())
                            k=1;
                    }          
                    if(k==0)
                        onom.moveLeft();
                }
                else if(eTemp.Direita){    
                    int k=0;
                    for (i=0 ; i < e.size() ; i++){
                        Elemento aux = e.get(i);
                        if (aux.getPosicao().getColuna()==onom.getPosicao().getColuna()+1 && aux.getPosicao().getLinha() == onom.getPosicao().getLinha() && aux.isbBloqueante())
                            k=1;
                    }                
                    if (k==0)
                        onom.moveRight();
                }
                else if(eTemp.isbPegavel()){
                    e.remove(eTemp);
                    a--;
                    if(a<1){
                        System.out.println("ganhooooooooou");
                    }
                }
        } 
    }
       
    public static boolean ehPosicaoValidax(ArrayList<Elemento> e, Posicao p){
        Presidente onom = (Presidente) e.get(0);
        Posicao aFrente;
        if (onom.olhandopara == 0){
            aFrente = new Posicao (onom.getPosicao().getLinha()-2, onom.getPosicao().getColuna());
        } else if (onom.olhandopara == 1){
            aFrente = new Posicao(onom.getPosicao().getLinha(), onom.getPosicao().getColuna()+2);
        } else if (onom.olhandopara == 2){
            aFrente = new Posicao (onom.getPosicao().getLinha()+2, onom.getPosicao().getColuna());
        } else {
            aFrente = new Posicao(onom.getPosicao().getLinha(), onom.getPosicao().getColuna()-2);
        }
        for (Elemento x : e){
            if (x.getPosicao().getLinha()==aFrente.getLinha() && x.getPosicao().getColuna()==aFrente.getColuna()){
                if (x.Cima == true || x.Baixo == true || x.Direita == true || x.Esquerda == true)
                    return true;
                //System.out.println("falso"+aFrente.getLinha()+" "+x.getPosicao().getLinha()+"\n"+aFrente.getColuna()+" "+x.getPosicao().getColuna());
                return false;
            }
        }
        return true;
    }
    
        public static boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        for (Elemento eTemp : e) {
            if((!eTemp.isbTransponivel())){     
            // System.out.println("valida");
             if(eTemp.getPosicao().igual(p))
                 return false;
            }
        }      
        return true;
    }
}
