/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_2;

/**
 *
 * @author KAAR_JOSEPH
 */
public class TRABAJO_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /** GENERAR UNA APLICACIÓN QUE EN BASE AL NÚMERO DEL MES CONVERTIR EN TEXTO
        * 1.- ENERO
        * 2.- FEBRERO
        * .............
        */
        int a = 12;
        switch(a){
            case 1: System.out.println("Enero");
            break;
            case 2: System.out.println("Febreo");
            break;
            case 3: System.out.println("Marzo");
            break;
            case 4: System.out.println("Abril");
            break;
            case 5: System.out.println("Mayo");
            break;
            case 6: System.out.println("Junio");
            break;
            case 7: System.out.println("Julio");
            break;
            case 8: System.out.println("Agosto");
            break;
            case 9: System.out.println("Septiembre");
            break;
            case 10: System.out.println("Octubre");
            break;
            case 11: System.out.println("Noviembre");
            break;
            default: System.out.println("Diciembre");
            break;
        }
    }
    
}
