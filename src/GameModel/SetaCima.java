package GameModel;

import Auxiliar.Desenho;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class SetaCima extends Elemento{
    public SetaCima(String sNomeImagePNG){
        super(sNomeImagePNG);
        this.bVuneravel = false;
        this.bTransponivel = true;
        this.bDestrutivel = false;
        this.Cima = true;
        this.Baixo = false;
        this.Esquerda = false;
        this.Direita = false;
        this.setbBloqueante(false);
    }
    public void autoDesenho(Graphics g, ArrayList<Elemento> e) {
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
}