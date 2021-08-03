/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author KAAR_JOSEPH
 */
public class ModeloAhorcado {
    private String usuario;
    private String palabra;
    private int intentos;

    public ModeloAhorcado(String palabra,String usuario, int intentos){
        this.palabra = palabra;
        this.intentos = intentos;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    @Override
    public String toString() {
        return "Ahorcado{" + "palabra=" + palabra + ", intentos=" + intentos + '}';
    }
}
