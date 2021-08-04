/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrada;
import Modelo.Salida;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author KAAR_JOSEPH
 */
public class SalidaControlador {
    private List<Salida> datos;
    private Salida seleccionado;
    public static double COSTO_HORA = 1; // Variable estatica, no se puede cambiar el valor
    
    public SalidaControlador(){
        datos = new ArrayList();
        seleccionado = null;
    }
    public long generarId(){
        if(datos.size() > 0)
            return datos.get(datos.size() -1).getId() + 1;
        return 1;
    }
    public boolean crear(Date horaEntrada, Date horaSalida, double valor, Entrada Entrada){
        Salida Salida = new Salida(this.generarId(), horaEntrada, horaSalida, valor,  Entrada);
        //vehiculo.getListaServicios().add(servicio);
        return datos.add(Salida);
    }
    public Salida buscar(Date horaEntrada) {
        for (Salida dato : datos) {
            if(dato.getHoraEntrada().equals(horaEntrada))
                return dato;
        }
        return null;
    }
    public boolean actualizar(Date horaEntrada, Date horaSalida){
        Salida Salida = this.buscar(horaEntrada);
        if(Salida!= null) {
            int posicion = datos.indexOf(Salida);
            Salida.setHoraSalida(horaSalida);
            long diferenciaSegundos = Math.abs(Salida.getHoraSalida().getTime() - Salida.getHoraEntrada().getTime());
            long minutos = TimeUnit.MINUTES.convert(diferenciaSegundos, TimeUnit.MILLISECONDS);
            double valor = minutos * (this.COSTO_HORA / 60);
            String str = String.format("%1.2f", valor);
            valor = Double.valueOf(str);
            Salida.setValor(valor);
            datos.set(posicion, Salida);
            return true;
        }
        return false;
    }
    public boolean eliminar(Date horaEntrada) {
        Salida Salida = this.buscar(horaEntrada);
        if(Salida != null){
            Salida.getEntrada().getListaSalida().remove(Salida);
            return datos.remove(Salida);
        }
        return false;
    }

    public List<Salida> getDatos() {
        return datos;
    }

    public void setDatos(List<Salida> datos) {
        this.datos = datos;
    }

    public Salida getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Salida seleccionado) {
        this.seleccionado = seleccionado;
    } 
}
