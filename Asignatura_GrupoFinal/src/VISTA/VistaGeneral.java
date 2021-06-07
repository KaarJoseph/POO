/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ControladorAula;
import java.util.Scanner;
import MODELO.Aula;
import MODELO.Grupo;

/**
 *
 * @author KAAR_JOSEPH
 */
public class VistaGeneral {
    private VistaAsignatura vistaAsignatura;
    private VistaAula vistaAula;
    private VistaGrupo vistaGrupo;
    private Scanner teclado; 
    public VistaGeneral(){
        vistaAula= new VistaAula();
        vistaGrupo= new VistaGrupo(vistaAula.getControladorAula());
        vistaAsignatura=new VistaAsignatura(vistaGrupo.getControladorGrupo());
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int op=0;
        do{
            System.out.println("SELECCIONE UNA OPCION");
            System.out.println("1.Aula");
            System.out.println("2.Grupo");
            System.out.println("3.Asignatura");
            System.out.println("4.Salir");
            op=teclado.nextInt();
            switch(op){
                case 1:vistaAula.menu();break;
                case 2:this.Grupo();break;
                case 3:this.Asignatura();break;
            }
        }while(op<4);//para los demas modelos
    }
    public void Grupo(){
        System.out.println("Seleccione una aula  para gestionar los grupos");
        Aula aula=vistaAula.buscar();
        if(aula!=null){
            //vistaAula.getControladorAula().getSeleccionado();
            vistaGrupo.menu();
        }else{
            System.out.println("No existe");
            this.Grupo();
        }
    }
    public void Asignatura(){
        System.out.println("Seleccione una grupo  para gestionar las asignaturas");
        Grupo grupo=vistaGrupo.buscar();
        if(grupo!=null){
            //vistaGrupo.asignarSeleccionado(grupo);
            vistaAsignatura.menu();
        }else{
            System.out.println("No existe");
            this.Asignatura();
        }
    }
    
    
}
