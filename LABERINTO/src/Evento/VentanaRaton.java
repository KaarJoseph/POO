/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evento;

import javax.swing.JFrame;

/**
 *
 * @author KAAR_JOSEPH
 */

public class VentanaRaton  extends JFrame{
    public Mouse panelRaton;
    public VentanaRaton(){
        setTitle("LABERINTO");
        setBounds(0,0,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initcomponents();
        
    }
    public void initcomponents(){
        panelRaton=new Mouse();
        setContentPane(panelRaton);
        panelRaton.repaint();
        addMouseMotionListener(panelRaton);
    }
}
