/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ClienteControlador;
import CONTROLADOR.FacturaControlador;
import CONTROLADOR.ProductoControlador;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class VistaGeneral {
    private Scanner teclado;
    
    private FacturaVista facturaVista;
    private FacturaControlador facturaControlador;
    private ClienteVista clienteVista;
    private ClienteControlador clienteControlador;
    private ProductoVista productoVista;
    private ProductoControlador productoControlador;
    public VistaGeneral(){
        teclado=new Scanner(System.in);
        //facturaControlador=new FacturaControlador();
        clienteControlador=new ClienteControlador();
        productoControlador= new ProductoControlador();
        productoVista=new ProductoVista(productoControlador);
        clienteVista=new ClienteVista(clienteControlador);
        facturaVista=new FacturaVista(clienteControlador, productoControlador);
    }
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("GESTIÓN DE REGISTROS");
            System.out.println(" 1.FACTURA \n 2.DATOS DEL PRODUCTO \n 3.DATOS DEL CLIENTE \n 4.SALIR");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: facturaVista.menu(); break;
                case 2: productoVista.menu(); break;
                case 3: clienteVista.menu();break;
            }
        } while (opcion < 4);
    }
}
