/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameModel;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import GameModel.Presidente;
import auxiliar.Posicao;
import GameModel.Elemento;
import java.util.ArrayList;

/**
 *
 * @author Junio
 */
public class BichinhoVaiVemHorizontal extends Elemento implements Serializable{
    private int iContaIntervalos;

    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bVuneravel = false;
        this.bMortal = true;
        this.bTransponivel = true;
        this.bDestrutivel = false;
        this.iContaIntervalos = 0;
    }
    
    public void autoDesenho(Graphics g, ArrayList<Elemento> faseAtual){          
        float f = (float) Math.random();
        int i=0;
        if(f < 0.25){
            for (Elemento e : faseAtual){
                Posicao ondeVai = new Posicao(this.getPosicao().getLinha()+1, this.getPosicao().getColuna());
                if (e.getPosicao().igual(ondeVai) && this!=e)
                    i = 1;
            }
            if (i==0)
             this.getPosicao().moveDown();
        }else if(f > 0.25 && f < 0.5){
            for (Elemento e : faseAtual){
                Posicao ondeVai = new Posicao(this.getPosicao().getLinha()-1, this.getPosicao().getColuna());
                if (e.getPosicao().igual(ondeVai)&& this!=e)
                    i = 1;
            }                
            if (i==0)
                this.getPosicao().moveUp();
        }else if(f > 0.5 && f < 0.75){
            for (Elemento e : faseAtual){
                Posicao ondeVai = new Posicao(this.getPosicao().getLinha(), this.getPosicao().getColuna()-1);
                if (e.getPosicao().igual(ondeVai)&& this!=e)
                    i=1;
            }      
            if (i==0)
                this.getPosicao().moveLeft();
        }else{
            for (Elemento e : faseAtual){
                Posicao ondeVai = new Posicao(this.getPosicao().getLinha(), this.getPosicao().getColuna()+1);
                if (e.getPosicao().igual(ondeVai)&& this!=e)
                    i=1;
            }            
            if (i==0)
                this.getPosicao().moveRight();
        }
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
    
}
