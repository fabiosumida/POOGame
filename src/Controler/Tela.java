/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tela.java
 *
 * Created on 03/03/2011, 18:28:20
 */
package Controler;

import GameModel.GreenBloco;
import GameModel.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import auxiliar.Posicao;

/**
 *
 * @author junio
 */
public final class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    
    private Presidente onom;
    private GreenBloco gB;
    private RedBloco RB;
    public ArrayList<Elemento> faseAtual;
    public int fase=2;
    private ControleDeJogo cj = new ControleDeJogo();
    
    

    /**
     * Creates new form tabuleiro
     */
    public Tela() {
        Desenho.setjCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/
        
        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);
        
        
        
        
        if(fase==1){
            faseAtual = new ArrayList<Elemento>(100);

            /*Cria e adiciona elementos*/
            onom = new Presidente("onom.png");
            onom.setPosicao(7, 4);
            this.addElemento(onom);  

            //desenha o campo de jogo
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==3 && j==0) || (i==9 && j==0) || (i==0 && j==1) || (i==2 && j==1) || (i==4 && j==1) || (i==1 && j==2) || (i==5 && j==2)
                            || (i==9 && j==2) || (i==8 && j==3) || (i==0 && j==5) || (i==2 && j==5) || (i==6 && j==5)
                            || (i==5 && j==6) || (i==9 && j==6) || (i==6 && j==7) || (i==10 && j==7) || (i==1 && j==8)
                            || (i==3 && j==8) || (i==7 && j==8) || (i==9 && j==8) || (i==4 && j==9) || (i==8 && j==9)
                            || (i==1 && j==10) || (i==7 && j==10)){
                        GreenBloco gB = new GreenBloco("gb.png");
                        gB.setPosicao(i,j);
                        this.addElemento(gB);
                    }
                }
            }              

            //coloca os blocos vermelhos nas linha e colunas impares
            for(int i=1;i<11;i=i+2){
                for(int j=1;j<11;j=j+2){

                    RedBloco RB = new RedBloco("blocored.png");
                    RB.setPosicao(i,j);
                    this.addElemento(RB);
                }
            }
            Fruta uva = new Fruta("uva.png");
            uva.setPosicao(0,0);
            this.addElemento(uva);

            Fruta mamao = new Fruta("mamao.png");
            mamao.setPosicao(0,10);
            this.addElemento(mamao);

            Fruta maça = new Fruta("maça.png");
            maça.setPosicao(10,0);
            this.addElemento(maça);

            Fruta cereja = new Fruta("cereja.png");
            cereja.setPosicao(10,10);
            this.addElemento(cereja);
            
            BichinhoVaiVemHorizontal BX1 = new BichinhoVaiVemHorizontal("amarelo.png");
            BX1.setPosicao(1,0);
            this.addElemento(BX1);

            BichinhoVaiVemHorizontal BX2 = new BichinhoVaiVemHorizontal("roxo.png");
            BX2.setPosicao(1,10);
            this.addElemento(BX2);

            BichinhoVaiVemHorizontal BX3 = new BichinhoVaiVemHorizontal("verde.png");
            BX3.setPosicao(10,1);
            this.addElemento(BX3);

            BichinhoVaiVemHorizontal BX4 = new BichinhoVaiVemHorizontal("azul.png");
            BX4.setPosicao(9,10);
            this.addElemento(BX4);
        }
        
        
        
        
        
        if(fase==2){
            faseAtual = new ArrayList<Elemento>(100);
            onom = new Presidente("onom.png");
            onom.setPosicao(5, 5);
            this.addElemento(onom); 
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==1 && j==3) || (i==1 && j==7) || (i==3 && j==1) || (i==3 && j==3) || (i==3 && j==5) || (i==3 && j==7)
                            || (i==3 && j==9) || (i==5 && j==3) || (i==5 && j==7) || (i==7 && j==1) || (i==7 && j==3)
                            || (i==7 && j==5) || (i==7 && j==7) || (i==7 && j==9) || (i==9 && j==3) || (i==9 && j==7)){
                        RedBloco RB = new RedBloco("blocored.png");
                        RB.setPosicao(i,j);
                        this.addElemento(RB);
                    }
                }
            }
            Fruta uva = new Fruta("uva.png");
            uva.setPosicao(1,5);
            this.addElemento(uva);

            Fruta mamao = new Fruta("mamao.png");
            mamao.setPosicao(5,1);
            this.addElemento(mamao);

            Fruta maça = new Fruta("maça.png");
            maça.setPosicao(5,9);
            this.addElemento(maça);

            Fruta cereja = new Fruta("cereja.png");
            cereja.setPosicao(9,5);
            this.addElemento(cereja);
            
            RedBlackBloco RBB = new RedBlackBloco("redblack.png");
            RBB.setPosicao(6,5);
            this.addElemento(RBB);
            
            BichinhoVaiVemHorizontal BX1 = new BichinhoVaiVemHorizontal("amarelo.png");
            BX1.setPosicao(1,1);
            this.addElemento(BX1);

            BichinhoVaiVemHorizontal BX2 = new BichinhoVaiVemHorizontal("roxo.png");
            BX2.setPosicao(9,1);
            this.addElemento(BX2);

            BichinhoVaiVemHorizontal BX3 = new BichinhoVaiVemHorizontal("verde.png");
            BX3.setPosicao(1,9);
            this.addElemento(BX3);

            BichinhoVaiVemHorizontal BX4 = new BichinhoVaiVemHorizontal("azul.png");
            BX4.setPosicao(9,9);
            this.addElemento(BX4);
            
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==3 && j==0) || (i==3 && j==6) || (i==3 && j==8) || (i==4 && j==0) || (i==4 && j==8) || (i==5 && j==0)
                            || (i==6 && j==0) || (i==7 && j==0) || (i==7 && j==6) || (i==7 && j==8) || (i==7 && j==10)){
                        SetaCima SC = new SetaCima("cima.png");
                        SC.setPosicao(i,j);
                        this.addElemento(SC);
                    }
                }
            }
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==2 && j==4) || (i==3 && j==2) || (i==3 && j==4) || (i==3 && j==10) || (i==7 && j==2) || (i==7 && j==4)){
                        SetaBaixo SB = new SetaBaixo("baixo.png");
                        SB.setPosicao(i,j);
                        this.addElemento(SB);
                    }
                }
            }
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==2 && j==5) || (i==2 && j==6) || (i==2 && j==7) || (i==4 && j==9) || (i==4 && j==10) || (i==6 && j==7)
                            || (i==10 && j==3)){
                        SetaEsquerda SE = new SetaEsquerda("esquerda.png");
                        SE.setPosicao(i,j);
                        this.addElemento(SE);
                    }
                }
            }
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==0 && j==3) || (i==0 && j==7) || (i==2 && j==3) || (i==4 && j==3) || (i==4 && j==7) || (i==6 && j==3)
                            || (i==8 && j==3) || (i==8 && j==7) || (i==10 && j==7)){
                        SetaDireita SD = new SetaDireita("direita.png");
                        SD.setPosicao(i,j);
                        this.addElemento(SD);
                    }
                }
            }
        }
        
        
        
        if(fase==3){
            faseAtual = new ArrayList<Elemento>(100);
            
            onom = new Presidente("onom.png");
            onom.setPosicao(5, 5);
            this.addElemento(onom); 
            
            for(int i=1;i<10;i++){
                for(int j=1;j<10;j++){
                    if(i==1 || i==9 || j==1 || j==9){
                        RedBlackBloco RBB = new RedBlackBloco("redblack.png");
                        RBB.setPosicao(i,j);
                        this.addElemento(RBB);
                    }
                }
            }
            for(int i=3;i<8;i++){
                for(int j=3;j<8;j++){
                    if(i==3 || i==7 || j==3 || j==7){
                        RedBlackBloco RBB = new RedBlackBloco("redblack.png");
                        RBB.setPosicao(i,j);
                        this.addElemento(RBB);
                    }
                }
            }
            
            
            Fruta uva = new Fruta("sol.png");
            uva.setPosicao(5,0);
            this.addElemento(uva);

            Fruta mamao = new Fruta("vela.png");
            mamao.setPosicao(5,2);
            this.addElemento(mamao);

            Fruta maça = new Fruta("lampada.png");
            maça.setPosicao(5,8);
            this.addElemento(maça);

            Fruta cereja = new Fruta("parafuso.png");
            cereja.setPosicao(5,10);
            this.addElemento(cereja);
            
            BichinhoVaiVemHorizontal BX1 = new BichinhoVaiVemHorizontal("amarelo.png");
            BX1.setPosicao(0,5);
            this.addElemento(BX1);

            BichinhoVaiVemHorizontal BX2 = new BichinhoVaiVemHorizontal("roxo.png");
            BX2.setPosicao(2,5);
            this.addElemento(BX2);

            BichinhoVaiVemHorizontal BX3 = new BichinhoVaiVemHorizontal("verde.png");
            BX3.setPosicao(10,5);
            this.addElemento(BX3);

            BichinhoVaiVemHorizontal BX4 = new BichinhoVaiVemHorizontal("azul.png");
            BX4.setPosicao(8,5);
            this.addElemento(BX4);
        }
        
        
        if(fase==4){
            faseAtual = new ArrayList<Elemento>(100);
            
            onom = new Presidente("onom.png");
            onom.setPosicao(4, 5);
            this.addElemento(onom); 
            
            for(int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    if((i==0 && j==3) || (i==0 && j==7) || (i==1 && j==0) || (i==1 && j==8) || (i==0 && j==5) || (i==3 && j==2)
                            || (i==3 && j==10) || (i==5 && j==2) || (i==5 && j==8) || (i==6 && j==3) || (i==7 && j==0)
                            || (i==8 && j==1) || (i==8 && j==7) || (i==8 && j==10) || (i==10 && j==1)){
                        RedBloco RB = new RedBloco("blocored.png");
                        RB.setPosicao(i,j);
                        this.addElemento(RB);
                    }
                }
            }
            
            for(int i=1;i<11;i=i+2){
                for(int j=1;j<11;j=j+2){
                    GreenBloco2 GB = new GreenBloco2("blocoverde.png");
                    GB.setPosicao(i,j);
                    this.addElemento(GB);
                }
            }
            
            for(int i=2;i<10;i=i+2){
                for(int j=2;j<10;j=j+2){
                    GreenBloco2 GB = new GreenBloco2("blocoverde.png");
                    GB.setPosicao(i,j);
                    this.addElemento(GB);
                }
            }
            
            
            Fruta uva = new Fruta("sol.png");
            uva.setPosicao(0,0);
            this.addElemento(uva);

            Fruta mamao = new Fruta("vela.png");
            mamao.setPosicao(10,0);
            this.addElemento(mamao);

            Fruta maça = new Fruta("lampada.png");
            maça.setPosicao(0,10);
            this.addElemento(maça);

            Fruta cereja = new Fruta("parafuso.png");
            cereja.setPosicao(10,10);
            this.addElemento(cereja);
            
            BichinhoVaiVemHorizontal BX1 = new BichinhoVaiVemHorizontal("amarelo.png");
            BX1.setPosicao(0,5);
            this.addElemento(BX1);

            BichinhoVaiVemHorizontal BX2 = new BichinhoVaiVemHorizontal("roxo.png");
            BX2.setPosicao(10,5);
            this.addElemento(BX2);

            BichinhoVaiVemHorizontal BX3 = new BichinhoVaiVemHorizontal("verde.png");
            BX3.setPosicao(5,0);
            this.addElemento(BX3);

            BichinhoVaiVemHorizontal BX4 = new BichinhoVaiVemHorizontal("azul.png");
            BX4.setPosicao(10,5);
            this.addElemento(BX4);
        }
    }
    
    public void addElemento(Elemento umElemento) {
        faseAtual.add(umElemento);
    }
    
    public void removeElemento(Elemento umElemento) {
        faseAtual.remove(umElemento);
    }
    public void removeLeft(Posicao p){
        
    }
    
    public void paint(Graphics gOld) {
        Graphics g = getBufferStrategy().getDrawGraphics();
        //Criamos um contexto gráfico
        Graphics g2 = g.create(getInsets().right, getInsets().top, getWidth() - getInsets().left, getHeight() - getInsets().bottom);
        //Desenha cenário
        if(fase==1){
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "scooterbackground.png");
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        if(fase==2){
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background2.png");
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
            
        if(fase==3){
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background3.png");
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        if(fase==4){
            for (int i = 0; i < Consts.RES; i++) {
                for (int j = 0; j < Consts.RES; j++) {
                    try {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "background4.png");
                        g2.drawImage(newImage,
                                j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                    } catch (IOException ex) {
                        Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        
        this.cj.desenhaTudo(faseAtual, g2);
        this.cj.processaTudo(faseAtual);
        
        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }
    
    public void go() {
        TimerTask task = new TimerTask() {
            
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.DELAY);
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
           onom.destroy(faseAtual);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            onom.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            onom.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            onom.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            onom.moveRight();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!cj.ehPosicaoValida(this.faseAtual, onom.getPosicao())) {
            onom.voltaAUltimaPosicao();
        }
        
        this.setTitle("-> Cell: " + (onom.getPosicao().getColuna()) + ", "
                + (onom.getPosicao().getLinha()));

        repaint();
    }
    
    public void mousePressed(MouseEvent e) {
        /*Clique do mouse desligado
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.persona.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         */
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2015-1 - Adventures of lolo");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    
    public void mouseReleased(MouseEvent e) {
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mouseDragged(MouseEvent e) {
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyReleased(KeyEvent e) {
    }

}
