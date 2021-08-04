/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.EntradaControlador;
import Controlador.SalidaControlador;
import Modelo.Salida;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author KAAR_JOSEPH
 */
public class SalidaVista {
    private SalidaControlador salidaControlador;
    private EntradaControlador entradaControlador;
    private Scanner teclado;
    private SimpleDateFormat formatoFecha;
    public static String formato = "dd-MM-yyyy HH:mm";
    
    public SalidaVista(EntradaControlador entradaControlador){
        this.entradaControlador = entradaControlador;
        salidaControlador = new SalidaControlador();
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
        System.out.println("Ingresar hora de entrada: " + formato);
        teclado.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(teclado.nextLine());
            boolean resultado = salidaControlador.crear(horaEntrada, null, 0, entradaControlador.getSeleccionado());
            System.out.println("Creado " + resultado);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.crear();
        }
    }
    public Salida buscar(){
        System.out.println("Ingresar hora entrada: " + formato);
        teclado.nextLine();
        try {
            Date horaEntrada = formatoFecha.parse(teclado.nextLine());
            Salida Salida = salidaControlador.buscar(horaEntrada);
            System.out.println(Salida);
            return Salida;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.menu();
        }
        return null;
    }
    public void actualizar(){
        Salida Salida = this.buscar();
        System.out.println("Ingresar hora salida: " + formato);
        try {
            Date horaSalida = formatoFecha.parse(teclado.nextLine());
            boolean resultado = salidaControlador.actualizar(Salida.getHoraEntrada(), horaSalida);
            System.out.println("Resultado: " + resultado);
            System.out.println("Valor = " + Salida.getValor());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            this.actualizar();
        }
    }
    public void eliminar(){
        Salida Salida = this.buscar();
        if (Salida != null) {
            boolean resultado = salidaControlador.eliminar(Salida.getHoraEntrada());
            System.out.println("Elminado : " + resultado);
        }
    }
    public void listar(){
        for (Salida dato : salidaControlador.getDatos()) 
            System.out.println(dato);
    }
}
