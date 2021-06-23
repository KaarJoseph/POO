/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PlanoControlador;
import Controlador.ProyectoControlador;
import Modelo.Plano;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class PlanoVista {
    
    private PlanoControlador planoControlador;
    private ProyectoControlador proyectoControlador;
    private Scanner teclado;
    private SimpleDateFormat formatofecha;
    public PlanoVista(ProyectoControlador proyectoControlador){
        this.proyectoControlador = proyectoControlador;
        planoControlador = new  PlanoControlador();
        formatofecha = new SimpleDateFormat("dd/mm/yyyy");
        teclado = new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n***PLANOS***\n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Imprimir\n6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    this.Crear();break;
                case 2:
                    this.Buscar();break;
                case 3:
                    this.Actualizar();break;
                case 4:
                    this.Eliminar();break;
                case 5:
                    this.Imprimir();break;
            }
        } while (opcion<6);
    }
    public void Crear(){
        System.out.println("Ingrese la fecha de entrega del plano: ");
        String fecha=teclado.next();
        System.out.println("Ingrese la identificacion del plano en enteros: ");
        int identificacion=teclado.nextInt();
        System.out.println("Ingrese el numero de arquitectos relacionados");
        int numArquitectos=teclado.nextInt();
        try {
            System.out.println("resultado: "+planoControlador.Crear(identificacion, formatofecha.parse(fecha), numArquitectos,proyectoControlador.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public Plano Buscar(){
        System.out.println("Ingrese el identificacion del plano que desea buscar: ");
        int identificacion=teclado.nextInt();
        Plano plano=planoControlador.Buscar(identificacion);
        System.out.println(plano);
        return plano;
    }
    public void Actualizar(){
        System.out.println("Ingrese la identificacion del plano que desea actualizar: ");
        int identificacion=teclado.nextInt();
        System.out.println("Ingrese la fecha de entrega del plano: ");
        String fecha=teclado.next();
        System.out.println("Ingrese el numero de arquitectos: ");
        int Arquitectos=teclado.nextInt();
        try {
            System.out.println("Resultado: "+planoControlador.Actualizar(identificacion, formatofecha.parse(fecha), Arquitectos));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void Eliminar(){
        System.out.println("Ingrese la identificacion del plano que desea eliminar: ");
        int identificador=teclado.nextInt();
        boolean resultado=planoControlador.Eliminar(identificador);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (Plano plano : planoControlador.getListaPlanos()) {
            System.out.println(plano);
        }
    }
    public void asignarSeleccionado(Plano planos){
        planoControlador.setSeleccionado(planos);
    }

    public PlanoControlador getPlanoControlador() {
        return planoControlador;
    }

    public void setPlanoControlador(PlanoControlador planoControlador) {
        this.planoControlador = planoControlador;
    }

    public ProyectoControlador getProyectoControlador() {
        return proyectoControlador;
    }

    public void setProyectoControlador(ProyectoControlador proyectoControlador) {
        this.proyectoControlador = proyectoControlador;
    }
}
