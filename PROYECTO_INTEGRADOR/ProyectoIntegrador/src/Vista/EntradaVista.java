/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ClienteControlador;
import Controlador.EntradaControlador;
import Controlador.VehiculoControlador;
import Modelo.Entrada;
import Modelo.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class EntradaVista {
    private EntradaControlador entradaControlador;
    private VehiculoControlador vehiculoControlador;
    private Scanner teclado;
    private SimpleDateFormat formatoFecha;
    public static String formato = "dd-MM-yyyy HH:mm";
    
    public EntradaVista(VehiculoControlador vehiculoControlador){
        this.vehiculoControlador = vehiculoControlador;
        entradaControlador = new EntradaControlador();
        teclado = new Scanner(System.in);
        formatoFecha = new SimpleDateFormat(formato);
    }
    public void menu(){
        int opcion = 0;
        do {            
            System.out.println("Gestión del Servicio");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                    case 1: this.crear(); break;
                    case 2: this.actualizar();break;
                    case 3: this.buscar(); break;
                    case 4: this.eliminar(); break;
                    case 5: this.listar(); break;
            }
        } while (opcion < 6);
    }
    public void crear(){
        System.out.println("Ingresar hora entrada: " + formato);
        teclado.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(teclado.nextLine());
            boolean resultado = entradaControlador.crear(horaEntrada,vehiculoControlador.getSeleccionado());//REVISAR NULL,0,
            System.out.println("Creado " + resultado);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.crear();
        }
    }
    public Entrada buscar(){
        System.out.println("Ingrese hora entrada: " + formato);
        teclado.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(teclado.nextLine());
            Entrada Entrada = entradaControlador.buscar(horaEntrada);
            System.out.println(Entrada);
            return Entrada;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
        return null;
    }
    public void actualizar(){
        Entrada Entrada = this.buscar();
        System.out.println("Ingrese hora salida: " + formato);
        try {
            Date horaSalida = formatoFecha.parse(teclado.nextLine());
            boolean resultado = entradaControlador.actualizar(Entrada.getHoraEntrada());
            System.out.println("Resultado: " + resultado);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.actualizar();
        }
    }
    public void eliminar(){
        Entrada Entrada = this.buscar();
        if (Entrada != null) {
            boolean resultado = entradaControlador.eliminar(Entrada.getHoraEntrada());
            System.out.println("Elminado : " + resultado);
        }
    }
    public void listar(){
        for (Entrada dato : entradaControlador.getDatos()) 
            System.out.println(dato);
    }

    public void asignarSeleccionado(Entrada Entrada){
        entradaControlador.setSeleccionado(Entrada);
    }

    public EntradaControlador getEntradaControlador() {
        return entradaControlador;
    }

    public void setEntradaControlador(EntradaControlador entradaControlador) {
        this.entradaControlador = entradaControlador;
    }

    public VehiculoControlador getVehiculoControlador() {
        return vehiculoControlador;
    }

    public void setVehiculoControlador(VehiculoControlador vehiculoControlador) {
        this.vehiculoControlador = vehiculoControlador;
    }


}
