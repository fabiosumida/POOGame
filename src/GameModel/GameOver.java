/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Auxiliar.Desenho;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author aula
 */
public class GameOver extends Elemento{

    public GameOver(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    @Override
    public void autoDesenho(Graphics g, ArrayList<Elemento> e) {
        Desenho.desenhar(g, this.iImage, 5, 4);
    }
    
}
