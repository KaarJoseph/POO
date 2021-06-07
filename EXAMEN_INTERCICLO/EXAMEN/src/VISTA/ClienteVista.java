/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ClienteControlador;
import MODELO.Cliente;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class ClienteVista {
    private ClienteControlador clienteControlador;
    private Scanner teclado;
    public ClienteVista(ClienteControlador clienteControlador){
        this.clienteControlador=clienteControlador;
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do {    
            System.out.println(" Gestion de clientes \n 1.Crear \n 2.Buscar \n 3.Actualizar \n 4.Eliminar \n 5.Listar \n 6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break;
                case 2: this.buscar();break;
                case 3: this.Actualizar();break;
                case 4: this.eliminar();break;
                case 5: this.listar();break;
                case 6: break;
            }
            
        } while (opcion<6);
    }
    public void crear(){
        System.out.println("Ingrese los datos del cliente");
        System.out.println("Nombre del cliente");
        String nombre=teclado.next();
        System.out.println("Entero de fiabilidad de pago");
        int fiabilidadPago=teclado.nextInt();
        System.out.println("Cedula");
        String cedula=teclado.next();
        System.out.println("Creado= "+clienteControlador.crear(nombre, cedula, fiabilidadPago));
    }
    public Cliente buscar(){
        System.out.println("ingrese el nombre a buscar");
        String nombre=teclado.next();
        return clienteControlador.buscar(nombre);
    }
    public void Actualizar(){
        System.out.println("Ingrese los datos");
        System.out.println("Nombre a actualizar");
        String nombre=teclado.next();
        System.out.println("Nombre nuevo del cliente");
        String nombreNuevo=teclado.next();
        System.out.println("Entero de fiabilidad de pago");
        int fiabilidadPago=teclado.nextInt();
        System.out.println("Cedula");
        String cedula=teclado.next();
        System.out.println("Actualizado"+clienteControlador.Actualizar(nombre,nombreNuevo, cedula, fiabilidadPago));
        
    }
    public void eliminar(){
        System.out.println("Ingrese la descripcion del producto a elminar");
        String nombre=teclado.next();
        boolean resultado=clienteControlador.eliminar(nombre);
        System.out.println("Eliminado "+resultado);
        }
    public void listar(){
        for (Cliente cliente : clienteControlador.getListaclientes()) {
            System.out.println(cliente);
        }
    }
}
