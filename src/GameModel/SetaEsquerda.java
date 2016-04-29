package GameModel;

import Auxiliar.Desenho;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class SetaEsquerda extends Elemento{
    public SetaEsquerda(String sNomeImagePNG){
        super(sNomeImagePNG);
        this.bVuneravel = false;
        this.bTransponivel = true;
        this.bDestrutivel = false;
        this.Cima = false;
        this.Baixo = false;
        this.Esquerda = true;
        this.Direita = false;
        this.setbBloqueante(false);
    }
    public void autoDesenho(Graphics g, ArrayList<Elemento> e) {
        Desenho.desenhar(g, this.iImage, pPosicao.getColuna(), pPosicao.getLinha());
    }
}