/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Salida {
    private long id;
    private Date horaEntrada;
    private Date horaSalida;
    private double valor;
    private Entrada Entrada;

    public Salida(long id, Date horaEntrada, Date horaSalida, double valor) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.valor = valor;
    }

    public Salida(long id, Date horaEntrada, Date horaSalida, double valor,Entrada Entrada) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.valor = valor;
        this.Entrada = Entrada;
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

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Entrada getEntrada() {
        return Entrada;
    }

    public void setEntrada(Entrada Entrada) {
        this.Entrada = Entrada;
    }

    @Override
    public String toString() {
        return "Salida{" + "id=" + id + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", valor=" + valor + '}';
    }
    
    

 
}

