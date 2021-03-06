package VISTA;


import CONTROLADOR.ControladorAula;
import java.util.Scanner;
import MODELO.Aula;
import MODELO.Grupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KAAR_JOSEPH
 */
public class VistaAula {
    private ControladorAula controladorAula;
    private Scanner teclado;
    public VistaAula(){
        controladorAula=new ControladorAula();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("\ngestion de aulas");
            System.out.println("1.Crear");
            System.out.println("2.Buscar");
            System.out.println("3.Actualizar");
            System.out.println("4.Eliminar");
            System.out.println("5.Listar");
            System.out.println("6.Salir");
            opcion= teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break; 
                case 2: this.buscar();break;
                case 3: this.actualizar();break;
                case 4: this.eliminar();break;
                case 5: this.imprimir();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingrese los datos de la aula");
        System.out.println("id ");
        long id=teclado.nextLong();
        System.out.println("descripcion ");
        String descripcion=teclado.next();
        System.out.println("creado "+controladorAula.crear(id, descripcion));
        
    }
    public Aula buscar(){
        System.out.println("Descripcion de la aula a buscar");
        String descripcion=teclado.next();
        Aula aula=controladorAula.buscar(descripcion);
        System.out.println(aula);
        controladorAula.setSeleccionado(aula);
        return aula;
    }
    public void actualizar(){
        System.out.println("ingrese la descripcion Anterior");
        String descripcionAnterior= teclado.next();
        System.out.println("ingrese la descripcion Nueva ");
        String descripcionNueva=teclado.next();
        boolean resultado=controladorAula.actualizar(descripcionAnterior, descripcionNueva);
        System.out.println("Actualizado "+resultado);
    }
    public void eliminar(){
        System.out.println("ingrese la id del aula a eliminar");
        String descripcion=teclado.next();
        boolean resultado= controladorAula.eliminar(descripcion);
        System.out.println("Eliminado "+resultado);
    }
    public void imprimir(){
        for (Aula aula : controladorAula.getListaAula()) {
            System.out.println(aula);
            this.imprimirgrupos(aula);
        }
    }
    public void imprimirgrupos(Aula aula){
        for (Grupo grupo : aula.getListagrupo()) {
            System.out.println(grupo);
        }
    }
    
    public ControladorAula getControladorAula() {
        return controladorAula;
    }

    public void setControladorAula(ControladorAula controladorAula) {
        this.controladorAula = controladorAula;
    }
    
}
