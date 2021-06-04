/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author KAAR_JOSEPH
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //* While - Tabla de Multiplicar
        int contador=1;
        int numero=8;
        while (contador <= 12){
            int resultado = numero * contador;
            System.out.println(numero+ " * "+ contador + " = " + resultado);
            contador++; //contador = contador + 1 || contador += 1
        }
        // Do-While-Tabla de Multiplicar
        System.out.println("Do-While");
        int contador2 = 1;
        do{
            int resultado = numero * contador2;
            System.out.println(numero + " * " + contador2 + " = " + resultado);
            contador2 += 1;
            }while(contador2 <= 12);
        //For - Tabla de Multiplicar
        System.out.println("For");
        for(int contador3 = 1 ; contador3 <= 12; contador3++){
            int resultado = numero * contador3;
            System.out.println(numero + " * " + contador3 + " = " + resultado);
        }    
    }
}

