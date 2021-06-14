/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;
//KJ
import CONTROLADOR.ClienteControlador;
import CONTROLADOR.FacturaControlador;
import CONTROLADOR.ProductoControlador;
import MODELO.Factura;
import MODELO.Producto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author KAAR_JOSEPH
 */
public class FacturaVista {
    private FacturaControlador facturaControlador;
    private Scanner teclado;
    private ClienteControlador clienteControlador;
    private ProductoControlador productoControlador;
    public DateFormat formatoFecha;
    public FacturaVista(ClienteControlador clienteControlador,ProductoControlador productoControlador){
        teclado=new Scanner(System.in);
        this.facturaControlador= new FacturaControlador();
        this.clienteControlador=clienteControlador;
        this.productoControlador=productoControlador;
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
    }
    public void menu(){
        int opcion=0;
        do {    
            System.out.println("\nGestion de facturas \n 1.Crear \n 2.Buscar \n 3.Actualizar \n 4.Eliminar \n 5.Listar \n 6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: this.crear();break;
                case 2: this.buscar();break;
                case 3: this.actualizar();break;
                case 4: this.eliminar();break;
                case 5: this.listar();break;
                case 6:break;
            }
        } while (opcion<6);
    }
    public void crear(){
        System.out.println("Ingrese el nombre cliente que desea gestionar");
        String cliente=teclado.next();
        System.out.println("\nCliente"+clienteControlador.buscar(cliente));
        System.out.println("Ingrese la cantidad de facturas a trabajar");
        int cantidad=teclado.nextInt();
        System.out.println("Ingrese el valor de la factura en enteros");
        int valor=teclado.nextInt();
        System.out.println("Ingrese la fecha(dd/mm/yyyy):");
        String fecha=teclado.next();
        double total=this.total();
        try {
            System.out.println("Resultado: "+facturaControlador.crear(formatoFecha.parse(fecha), valor, total, cantidad,clienteControlador.buscar(cliente)));//le anaido clietne
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void actualizar(){
        System.out.println("Ingrese la cantidad de facturas a trabajar");
        int cantidad=teclado.nextInt();
        System.out.println("Ingrese el valor de la factura en enteros");
        int valor=teclado.nextInt();
        System.out.println("Igrese la fecha(dd/mm/yyyy):");
        String fecha=teclado.next();
        try {
            System.out.println("Resultado: "+facturaControlador.Actualizar(formatoFecha.parse(fecha), cantidad,valor));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Factura buscar(){
        System.out.println("Ingrese la fecha (DD/MM/AA) de la factura a buscar: ");
        String fecha=teclado.next();
        try {
            return facturaControlador.buscar(formatoFecha.parse(fecha));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public void eliminar(){
        this.buscar();
        System.out.println("Eliminado: "+facturaControlador.eliminar(facturaControlador.getSeleccionado().getFecha()));
    }
    public void listar(){
        for (Factura factura : facturaControlador.getListafacturas()) {
            System.out.println(factura);
            System.out.println("Listado de productos: ");
            productoControlador.listar();
            
        }
    }
    public double total(){
        double total=0;
        double total1=0;
        for (Producto producto : productoControlador.getListaproductos()) {
            total=total1+total;
            double val1=producto.getPrecioUnitario();
            double iva=producto.getIva();
            total=val1+(val1*iva);
            total=total*producto.getStock();
        }
        return total1;
    }

    public FacturaControlador getFacturaControlador() {
        return facturaControlador;
    }

    public void setFacturaControlador(FacturaControlador facturaControlador) {
        this.facturaControlador = facturaControlador;
    }
   
}
