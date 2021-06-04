/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_4;

import java.util.Scanner;
/**
 *
 * @author KAAR_JOSEPH
 */
public class TRABAJO_4 {  
    public static void main(String[] args) {
        //REALIZAR LA VALIDACIÓN DE LA CÉDULA ECUATORIANA
        Scanner lec = new Scanner(System.in);

        System.out.println("INGRESE EL NÚMERO DE CÉDULA QUE DESEA HACER LA VALIDACIÓN");
        String cedula=lec.next();
        int numm, suma=0, maxs, resta=0;
        
        for (int i = 0; i < cedula.length()-1; i++) {
            numm=Integer.parseInt(cedula.charAt(i)+"");
            if(i%2==0){
                numm=numm*2;
                if(numm > 9){
                    numm = numm-9;
                }
            }
            
            suma=suma+numm;
        }
        
        if (suma%10 !=0) {
            maxs=((suma/10)+1)*10;
            resta=maxs-suma;
        }
        
        int numf=Integer.parseInt(cedula.charAt(9)+"");
        
        if (numf==resta) {
            System.out.println("LA CÉDULA INGRESADA ES CORRECTA");
        }else{
            System.out.println("LA CÉDULA INGRESADA ES INCORRECTA");
        }
        
    }
    
}