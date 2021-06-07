/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Factura {
    private long id;
    private Date fecha;
    private double valorTotal;
    private int cantidad;
    private int valor;
    private List<Producto> listaproducto;
    private Cliente cliente;

    public Factura(long id, Date fecha, double valorTotal, int cantidad,int valor) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.cantidad = cantidad;
        this.valor=valor;
    }

    public Factura(long id, Date fecha, double valorTotal, int cantidad,int valor, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.cantidad = cantidad;
        this.listaproducto = listaproducto;
        this.cliente = cliente;
        this.valor=valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getListaproducto() {
        return listaproducto;
    }

    public void setListaproducto(List<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void borrado(){
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", valorTotal=" + valorTotal + ", cantidad=" + cantidad + ", valor="+valor+", cliente="+cliente+ '}';
    }

    
    
            
}
