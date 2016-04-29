package GameModel;

import Auxiliar.Desenho;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class SetaDireita extends Elemento{
    public SetaDireita(String sNomeImagePNG){
        super(sNomeImagePNG);
        this.bVuneravel = false;
        this.bTransponivel = true;
        this.bDestrutivel = false;
        this.Cima = false;
        this.Baixo = false;
        this.Esquerda = false;
        this.Direita = true;
        this.setbBloqueante(false);
    }
    public void autoDesenho(Graphics g, ArrayList<Elemento> e) {
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
}