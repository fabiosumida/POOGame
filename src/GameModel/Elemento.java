/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import Auxiliar.Consts;
import Controler.Tela;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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
public abstract class Elemento implements Serializable{

    protected ImageIcon iImage;
    public Posicao pPosicao;
    public boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bVuneravel; 
    protected boolean bDestrutivel; //posso destruir?
    protected boolean bMortal;       /*Se encostar, o Lollo morre?*/
    protected boolean bArrastavel;  /*Pode ser arrastado?*/
    protected boolean bPegavel;
    protected boolean bBloqueante;
    public boolean isMovingUp;
    public boolean isMovingDown;
    public boolean isMovingRight;
    public boolean isMovingLeft;
    public boolean Esquerda;
    public boolean Direita;
    public boolean Cima;
    public boolean Baixo;
    public int olhandopara; //cima = 0, direita = 1, baixo = 2, esquerda = 3
    public int move;
    protected boolean bSeta;

    public boolean isbMortal() {
        return bMortal;
    }

    public boolean isbBloqueante() {
        return bBloqueante;
    }

    public void setbBloqueante(boolean bBloqueante) {
        this.bBloqueante = bBloqueante;
    }


    protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bDestrutivel = true;
        this.bTransponivel = true;
        this.bMortal = false;
        this.bVuneravel = true;
        this.bArrastavel = false;
        this.bPegavel = false;
        this.bBloqueante = true;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.Esquerda = false;
        this.Direita = false;
        this.Cima = false;
        this.Baixo= false;
        this.move = 0;
        try {
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public boolean isbPegavel(){
        return bPegavel;
    } 
    
    public boolean isbDestrutivel() {
        return bDestrutivel;
    }

    public boolean isbVuneravel() {
        return bVuneravel;
    }

    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Elemento*/
        return pPosicao;
    }
    
    public boolean isbArrastavel() {
        return bArrastavel;
    }
    
    public void setbArrastavel() {
        this.bArrastavel = bArrastavel;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }
    abstract public void autoDesenho(Graphics g, ArrayList<Elemento> e);

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        move=1;
        isMovingUp=true;
        isMovingDown=false;
        isMovingLeft=false;
        isMovingRight=false;
        this.olhandopara=0;
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        move=2;
        isMovingUp=false;
        isMovingDown=true;
        isMovingLeft=false;
        isMovingRight=false;
        this.olhandopara=2;
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        move=3;
        isMovingUp=false;
        isMovingDown=false;
        isMovingLeft=false;
        isMovingRight=true;
        this.olhandopara=1;
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        move=4;
        isMovingUp=false;
        isMovingDown=false;
        isMovingLeft=true;
        isMovingRight=false;
        this.olhandopara=3;
        return this.pPosicao.moveLeft();
    }
}
