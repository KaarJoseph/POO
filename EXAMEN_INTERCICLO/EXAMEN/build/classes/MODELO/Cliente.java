/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Cliente {
    private long id;
    private String nombre;
    private String cedula;
    private int fiabilidadPago;

    public Cliente(long id, String nombre, String cedula, int fiabilidadPago) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fiabilidadPago = fiabilidadPago;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getFiabilidadPago() {
        return fiabilidadPago;
    }

    public void setFiabilidadPago(int fiabilidad_pago) {
        this.fiabilidadPago = fiabilidadPago;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", fiabilidadPago=" + fiabilidadPago + '}';
    }
    
}
