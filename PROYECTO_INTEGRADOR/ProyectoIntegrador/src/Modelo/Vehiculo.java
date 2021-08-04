/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Vehiculo {
    private long id;
    private String placa;
    private String marca;
    private String modelo;
    private Cliente propietario;
    private List<Entrada> listaEntrada;
    
    

    public Vehiculo(long id, String placa, String marca, String modelo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.listaEntrada = new ArrayList();
    }

    public Vehiculo(long id, String placa, String marca, String modelo, Cliente propietario,List<Entrada> listaEntrada) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.listaEntrada = listaEntrada;
    }

    public Vehiculo(long id, String placa, String marca, String modelo, Cliente propietario) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.listaEntrada = new ArrayList();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public List<Entrada> getListaServicios() {
        return listaEntrada;
    }

    public void setListaServicios(List<Entrada> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", propietario=" + propietario + '}';
    }
    

    
}
