/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Auxiliar.Desenho;
import GameModel.Elemento;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class BlocoSeta extends Elemento {

    public BlocoSeta(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bVuneravel = false;
        this.bArrastavel = true;
        this.bTransponivel = true;
        this.bDestrutivel = true;
        this.bSeta = true;
    }

    public void autoDesenho(Graphics g, ArrayList<Elemento> e) {
        
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
}
