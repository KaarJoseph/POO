/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_3;

/**
 *
 * @author KAAR_JOSEPH
 */
public class TRABAJO_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //GENERAR LA SERIE DE FIBONACCI UTILIZANDO LAS TRES ESTRUCTURAS DE REPETICIÓN E IMPRIMIR LA CANTIDAD DE NÚMEROS GENERADOS
        //0, 1 ,1 , 2 , 3 , 5 ,8......
        System.out.println("SERIE FIBONACCI");
        int Cant= 12;
        int a = 0;
        int b = 1;
        int c = 1;
        System.out.println(a);
        for(int i = 1; i < Cant; i++){
        System.out.println(b);
        c = a + b;
        a = b;
        b = c;
       }    
       System.out.println("La cantidad de números de la serie Fibonacci es " + Cant);
    }   
}
