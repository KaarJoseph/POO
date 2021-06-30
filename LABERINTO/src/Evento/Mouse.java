/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evento;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Mouse extends JPanel 
        implements  MouseListener, MouseMotionListener{
    public FiguraRaton figuraRaton;
    public Random rnd =new Random();
    public Mouse(){
        setBounds(0, 0, 500, 500);
        figuraRaton=new FiguraRaton(0, 0, 6, 6);
    }
    @Override
    public void paint(Graphics lienzo){
        
        lienzo.clearRect(0, 0, 500, 500);
        lienzo.setColor(Color.black);
        lienzo.drawLine(100, 100, 300, 100); 
        lienzo.drawLine(150, 100, 150, 120); 
        lienzo.drawLine(150, 120, 270, 120);
        lienzo.drawLine(180, 120, 180, 175);
        lienzo.drawLine(180, 150, 230, 150);
        lienzo.drawLine(150, 140, 150, 200);
        lienzo.drawLine(110, 140, 150, 140);
        lienzo.drawLine(100, 200, 300, 200);
        lienzo.drawLine(250, 140, 250, 200); 
        lienzo.drawLine(250, 170, 290,170 ); 
        lienzo.drawLine(270, 120, 270, 150); 
        lienzo.drawString("AYUDA AL ASNO A LLEGAR A LA MEDALLA", 90, 60);
        lienzo.drawString("BURRO", 50, 150);
        lienzo.drawString("MEDALLA", 310, 150);
        lienzo.fillOval(figuraRaton.getX(), figuraRaton.getY(), figuraRaton.getAncho(), figuraRaton.getAlto());
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        figuraRaton.setX(me.getX());
        figuraRaton.setY(me.getY());
        this.repaint();
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override 
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        figuraRaton.setX(me.getX());
        figuraRaton.setY(me.getY());
        if(me.getY()==100 && (me.getX()<=300 && me.getX()>=100)){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getX()==150 && me.getY()>=100 && me.getY()<=120){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getY()==120 && me.getX()>=150 && me.getX()<=270){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getX()==180 && me.getY()>=120 && me.getY()<=175){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getX()==150 && me.getY()>=140 && me.getY()<=200){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getY()==140 && me.getX()>=110 && me.getX()<=150){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getY()==200 && me.getX()>=100 && me.getX()<=300){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getX()==250 && me.getY()>=140 && me.getY()<=200){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getY()==170 && me.getX()>=250 && me.getX()<=290){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getX()==270 && me.getY()>=120 && me.getY()<=150){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if(me.getY()==150 && me.getX()>=180 && me.getX()<=230){
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }else if (me.getX()==300){
            JOptionPane.showMessageDialog(this, "FELICIDADES GANASTE");
        }
        this.repaint();
    }
}
