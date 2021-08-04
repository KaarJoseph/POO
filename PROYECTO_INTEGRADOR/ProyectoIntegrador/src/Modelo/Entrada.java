/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Entrada {
    private long id;
    private Date horaEntrada;
    private Vehiculo vehiculo;
    private List<Salida> listaSalida;
    
    

    public Entrada(long id, Date horaEntrada) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.listaSalida= new ArrayList();
    }

    public Entrada(long id, Date horaEntrada,Vehiculo vehiculo,List<Salida> listaSalida) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.vehiculo = vehiculo;
        this.listaSalida= listaSalida;
    }
        public Entrada(long id, Date horaEntrada,Vehiculo vehiculo) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.vehiculo = vehiculo;
        this.listaSalida= new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Salida> getListaSalida() {
        return listaSalida;
    }

    public void setListaSalida(List<Salida> listaSalida) {
        this.listaSalida = listaSalida;
    }

    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", horaEntrada=" + horaEntrada + ", vehiculo=" + vehiculo + '}';
    }
    
    

 
}