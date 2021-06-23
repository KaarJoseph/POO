/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Plano;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class PlanoControlador {
        private List<Plano> listaPlanos;
    private Plano seleccionado;
    public PlanoControlador(){
        listaPlanos=new ArrayList<>();
        seleccionado=null;
    }
    public long GenerarID(){
        if(listaPlanos.size()>0){
            return listaPlanos.get(listaPlanos.size()-1).getId()+1;
        }else{
            return 1;
        }
    }
    public boolean Crear( int identificacion, Date fechaEntrega, int arquitectos){
        Plano planos=new Plano(this.GenerarID(), identificacion, fechaEntrega, arquitectos);
        return listaPlanos.add(planos);
    }
    public boolean Crear( int identificacion, Date fechaEntrega, int arquitectos,Proyecto proyecto){
          Plano planos=new Plano(this.GenerarID(), identificacion, fechaEntrega, arquitectos, proyecto);
          proyecto.getListaPlanos().add(planos);
          return listaPlanos.add(planos);
    }
    public Plano Buscar(int identificacion){
        for (Plano plano : listaPlanos) {
            if (plano.getIdentificacion()==identificacion) {
                return plano;
            }
        }
        return null;
    }
    public boolean Actualizar(int identificacion, Date fechaEntrega, int arquitectos){
        Plano plano=Buscar(identificacion);
        if (plano!=null) {
            int posicion=listaPlanos.indexOf(plano);
            plano.setIdentificacion(identificacion);
            plano.setArquitectos(arquitectos);
            plano.setFechaEntrega(fechaEntrega);
            listaPlanos.set(posicion, plano);
            return true;
        }
        return false;
    }
    public boolean Eliminar(int identificacion){
        Plano plano=Buscar(identificacion);
        if (plano!=null) {
            plano.getProyecto().getListaPlanos().remove(plano);
            return listaPlanos.remove(plano);
        }
        return false;
    }
    public void Imprimir(){
        for (Plano plano : listaPlanos) {
            System.out.println(plano);
        }
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    public Plano getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Plano seleccionado) {
        this.seleccionado = seleccionado;
    }
}
