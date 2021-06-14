/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.ProductoControlador;
import MODELO.Producto;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class ProductoVista {
    private ProductoControlador productoControlador;
    private Scanner teclado;
    public ProductoVista(ProductoControlador productoControlador){
        this.productoControlador=productoControlador;
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do {    
            System.out.println(" Gestion de productos \n 1.Crear \n 2.Buscar \n 3.Actualizar \n 4.Eliminar \n 5.Listar \n 6.Salir");
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
        System.out.println("Ingrese los datos del producto");
        System.out.println("Ingrese la descripcion del producto");
        String descripcion=teclado.next();
        System.out.println("Ingrese el stock");
        int stock=teclado.nextInt();
        System.out.println("Ingrese el precio unitario del producto");
        double precioUnitario=teclado.nextDouble();
        System.out.println("Ingrese el iva del producto si aun no es contabilizado, sino solo ingrese 0");
        double iva=teclado.nextDouble();
        System.out.println("Creado "+productoControlador.crear(descripcion, precioUnitario, stock, iva));
    }
    public Producto buscar(){
        System.out.println("Ingrese la descripcion");
        String descripcion=teclado.next();
        System.out.println(productoControlador.buscar(descripcion));
        return productoControlador.getSeleccionado();
    }
    public void Actualizar(){
        System.out.println("Ingrese la descripcion anterior");
        String descripcion=teclado.next();
        System.out.println("Ingrese la nueva descripcion");
        String descripcionNueva=teclado.next();
        System.out.println("Nuevo Stock");
        int stock=teclado.nextInt();
        System.out.println("Nuevo precio unitario");
        double precioUnitario=teclado.nextDouble();
        System.out.println("Nuevo Iva");
        double iva=teclado.nextDouble();
        System.out.println("Actualizado"+productoControlador.Actualizar(descripcion, descripcionNueva,precioUnitario, stock, iva));
    }
    public void eliminar(){
        System.out.println("Ingrese la descripcion del producto");
        String descripcion=teclado.next();
        boolean resultado=productoControlador.eliminar(descripcion);
        System.out.println("Eliminado "+resultado);
    }
    public void listar(){
        productoControlador.listar();
    }

}
