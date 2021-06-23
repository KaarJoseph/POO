/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficas;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

/**
 *
 * @author KAAR_JOSEPH
 */

public class Ventana extends JFrame implements ActionListener{
    private Panel panelP;
    private JButton boton1,boton2,boton3,boton4;
    public figuras fig;

    public Ventana(){
        setTitle("FIGURAS");
        setBounds (0,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
             fig=new figuras(200, 200, 100, 100);
             boolean panel=panelP.creo1(fig);
             repaint ();
        }
        if (e.getSource()==boton2) {
            fig=new figuras(200, 200, 100, 100);
             //setFig(fig);
             boolean panel=panelP.creo2(fig);
             repaint ();
        }
        if (e.getSource()==boton3) {
            fig=new figuras(200, 200, 250, 100);
             //setFig(fig);
             boolean panel=panelP.creo3(fig);
             repaint ();
        }
        if (e.getSource()==boton4) {
            fig=new figuras(200, 75, 350, 100);
             //setFig(fig);           
             boolean panel=panelP.creo4(fig);
             repaint ();
        }
        
              
    }
    public Panel getPanelP() {
        return panelP;
    }

    public void setPanelP(Panel panelP) {
        this.panelP = panelP;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JButton getBoton3() {
        return boton3;
    }

    public void setBoton3(JButton boton3) {
        this.boton3 = boton3;
    }

    public JButton getBoton4() {
        return boton4;
    }

    public void setBoton4(JButton boton4) {
        this.boton4 = boton4;
    }

    public figuras getFig() {
        return fig;
    }

    public void setFig(figuras fig) {
        this.fig = fig;
    }
    
    public void initComponentes(){
        boton1=new JButton("CUADRADO");
        boton2=new JButton("CIRCULO");
        boton3=new JButton("LINEA");
        boton4=new JButton("RECTANGULO"); 
        panelP=new Panel();
        setContentPane(panelP);
        panelP.repaint();
         boton2.setBounds(100, 250, 100, 30);
        add(boton2);
        boton1.setBounds(200, 250, 100, 30);
        add(boton1);
         boton1.addActionListener(this);
         boton3.setBounds(300, 250, 100, 30);
        add(boton3);
         boton4.setBounds(400, 250, 100, 30);
        add(boton4);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
        boton4.addActionListener(this);
        boton4.setVisible(true);
        fig = new figuras(100, 100, 100, 100);
    }
   

    @Override
    public String toString() {
        return "Ventana{" + "panelP=" + panelP + ", boton1=" + boton1 + ", boton2=" + boton2 + ", boton3=" + boton3 + ", boton4=" + boton4 + ", fig=" + fig + '}';
    }
    
}
