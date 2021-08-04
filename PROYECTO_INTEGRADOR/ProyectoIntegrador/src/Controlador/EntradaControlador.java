/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrada;
import Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class EntradaControlador {
    private List<Entrada> datos;
    private Entrada seleccionado;
    
    public EntradaControlador(){
        datos = new ArrayList();
        seleccionado = null;
    }
    public long generarId(){
        if(datos.size() > 0)
            return datos.get(datos.size() -1).getId() + 1;
        return 1;
    }
    public boolean crear(Date horaEntrada, Vehiculo vehiculo){
        Entrada Entrada = new Entrada(this.generarId(), horaEntrada, vehiculo);
        //vehiculo.getListaServicios().add(servicio);
        return datos.add(Entrada);
    }
    public Entrada buscar(Date horaEntrada) {
        for (Entrada dato : datos) {
            if(dato.getHoraEntrada().equals(horaEntrada))
                return dato;
        }
        return null;
    }
    
    public boolean actualizar(Date horaEntrada){
        Entrada Entrada = this.buscar(horaEntrada);
        if(Entrada != null) {
            int posicion=datos.indexOf(Entrada);
            Entrada.setHoraEntrada(horaEntrada);
            datos.set(posicion, Entrada);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(Date horaEntrada) {
        Entrada Entrada = this.buscar(horaEntrada);
        if(Entrada != null){
            Entrada.getVehiculo().getListaServicios().remove(Entrada);
            return datos.remove(Entrada);
        }
        return false;
    }

    public List<Entrada> getDatos() {
        return datos;
    }

    public void setDatos(List<Entrada> datos) {
        this.datos = datos;
    }

    public Entrada getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Entrada Entrada) {
        this.seleccionado = seleccionado;
    } 

    
}

