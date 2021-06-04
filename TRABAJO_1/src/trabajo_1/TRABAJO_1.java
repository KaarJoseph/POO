/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_1;

/**
 *
 * @author KAAR_JOSEPH
 */
public class TRABAJO_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**
        * 1.- GENERAR UNA APLICACIÓN QUE PERMITA DETERMINAR EL GRUPO EN BASE A LA EDAD
        * < 2 Bebés
        * < 12 Niños
        * < 18 Jovenes
        * < 65 Adultos
        * Adultos mayores
        */
        int a = 20;
        if (a < 2){
            System.out.println("La edad ingresada pertenece al grupo de los bebés");
        }else if (a < 12){
            System.out.println("La edad ingresada pertenece al grupo de los niños");
        }else if (a < 18){
            System.out.println("La edad ingresada pertenece al grupo de los jovenes");
        }else if (a < 65){
            System.out.println("La edad ingresada pertenece al grupo de los adultos"); 
        }else {
            System.out.println("La edad ingresada pertenece al grupo de los adultos mayores");
        }
    }
}
