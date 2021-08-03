package Modelo;

import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Juego {

    private JTextField jTextField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private boolean play = false;

    private final String[] DICCIONARIO = {"Helado","Casa","Radio","Borrador","Tijera","Mochila","Lentes","Camisa","Comida","Calculadora"};
    
    private char[] palabra_secreta;
    private char[] palabra;

    private int intentos = 0;
    
    private boolean cambios = false;

    public Juego(JTextField jTextField, JLabel jLabel1, JLabel jLabel2) {        
        this.jTextField = jTextField;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        
        palabra_secreta = DICCIONARIO[(int) (Math.random() * (DICCIONARIO.length))].toCharArray();
        
        System.out.println(Arrays.toString(palabra_secreta));
        
        String s = " ";
        for (int i = 0; i <= palabra_secreta.length - 1; i++) {
            s = s + " X ";            
        }
        this.palabra = s.toCharArray();

        jTextField.setText(s);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\USUARIO\\Documents\\PROJECTS\\ExamenFinal\\src\\Archivos\\1.jpeg")));
        
        jLabel2.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\USUARIO\\Documents\\PROJECTS\\ExamenFinal\\src\\Archivos\\1.jpeg")));
        this.play = true;
    }
    
    public void evaluar(char letra) {
        if (play) {
            String p = " ";
            if (intentos == 4) {
                JOptionPane.showMessageDialog(null, "GAME OVER");
            } else {
                //evalua caracter por caracter                
                for (int j = 0; j <= this.palabra_secreta.length - 1; j++) {        
                    if (this.palabra_secreta[j] == letra) {
                        this.palabra[j] = letra;
                        cambios = true;
                    }
                    p = p + this.palabra[j];
                }
                
                if (cambios == false) {
                    
                    intentos += 1;
                    
                    jLabel1.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\USUARIO\\Documents\\PROJECTS\\ExamenFinal\\src\\Archivos\\1.jpeg" + this.intentos + ".jpg")));
                    
                    jLabel2.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\USUARIO\\Documents\\PROJECTS\\ExamenFinal\\src\\Archivos\\1.jpeg" + this.intentos + ".jpg")));
                    
                    if (this.intentos < 4) {
                        
                        JOptionPane.showMessageDialog(null, "Incorrecto, te quedan " + (4 - intentos) + " intentos más");
                    }
                } else {
                    this.cambios = false;
                }
                this.jTextField.setText(p);
                Ganador();
            }
        }
    }

    private void Ganador() {
        boolean win = false;
        for (int i = 0; i <= this.palabra_secreta.length - 1; i++) {
            if (this.palabra[i] == this.palabra_secreta[i]) {
                win = true;
            } else {
                win = false;
                break;
            }
        }
        if (win) {
            
            JOptionPane.showMessageDialog(null, "FELICIDADES, GANASTE! \n");
            
            jLabel2.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\USUARIO\\Documents\\PROJECTS\\ExamenFinal\\src\\Archivos\\Winner.jpg")));
        }
    }
}
