/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GameModel;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Presidente extends Elemento implements Serializable{
    public Presidente(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }
    public void autoDesenho(Graphics g, ArrayList<Elemento> e){
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }


    public void destroy(ArrayList<Elemento> faseAtual) {
       // System.out.println("Estou olhando para: "+ this.olhandopara);
        Posicao posOlhando;
        if (this.olhandopara == 0){
            posOlhando = new Posicao(this.getPosicao().getLinha()-1, this.getPosicao().getColuna());            
        }else if (this.olhandopara == 1){
            posOlhando = new Posicao (this.getPosicao().getLinha(), this.getPosicao().getColuna()+1);
        }else if (this.olhandopara == 2){
            posOlhando = new Posicao (this.getPosicao().getLinha()+1, this.getPosicao().getColuna());         
        }else posOlhando = new Posicao (this.getPosicao().getLinha(), this.getPosicao().getColuna()-1);
        
        for (Elemento e : faseAtual) {
            if (e.getPosicao().igual(posOlhando) && e.isbDestrutivel()==true) {
                faseAtual.remove(e);
                break;
            }
        }
    }
}
