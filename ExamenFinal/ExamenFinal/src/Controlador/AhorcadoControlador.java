/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Archivos.Palabras;
import Modelo.ModeloAhorcado;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author KAAR_JOSEPH
 */
public class AhorcadoControlador {
        private List<ModeloAhorcado> Ahorcados;
    private Palabras palabras;
    private ModeloAhorcado seleccionado;
    private ArrayList palabra;
    public AhorcadoControlador(Palabras palabras){
        Ahorcados=new ArrayList<>();
        palabra=new ArrayList<>();
        this.palabras=palabras;
    }
    public boolean Crear(String usuario,int intentos){
        ModeloAhorcado ahorcado = new ModeloAhorcado(this.Imprimir(), usuario, intentos);
        seleccionado = ahorcado;
        return Ahorcados.add(ahorcado);
    }
    public ModeloAhorcado Buscar(String usuario){
        for (ModeloAhorcado ahorcado : Ahorcados) {
            if (ahorcado.getUsuario().equals(usuario)) {
                return ahorcado;
            }
        }
        return null;
    }
    public boolean Actualizar(String usuario,int intentos){
        ModeloAhorcado ahorcado = this.Buscar(usuario);
        if (ahorcado!=null) {
            int posicion=Ahorcados.indexOf(ahorcado);
            ahorcado.setIntentos(intentos);
            ahorcado.setPalabra(this.Imprimir());
            ahorcado.setUsuario(usuario);
            Ahorcados.set(posicion, ahorcado);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String usuario){
        ModeloAhorcado ahorcado = this.Buscar(usuario);
        if (ahorcado!=null) {
            Ahorcados.remove(ahorcado);
            return true;
        }
        return false;
    }
    public String Imprimir(){
        Random r = new Random();
        List<String> lista = new ArrayList<>();
        lista = palabras.Imprimir();
        int n = r.nextInt(lista.size()-1);
        String palabra = lista.get(n);
        return palabra;
    }
    public int Comparar(String consonante,String palabra){ 
        char [] longitud=palabra.toCharArray();
        for (int i = 0; i < longitud.length; i++) {
            String com = String.valueOf(longitud[i]);
            if (com.equals(consonante)) {
                return i+1;
            }
        }
        return 0;
    }

    public List<ModeloAhorcado> getAhorcados() {
        return Ahorcados;
    }

    public void setAhorcados(List<ModeloAhorcado> Ahorcados) {
        this.Ahorcados = Ahorcados;
    }

    public Palabras getPalabras() {
        return palabras;
    }

    public void setPalabras(Palabras palabras) {
        this.palabras = palabras;
    }

    public ModeloAhorcado getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(ModeloAhorcado seleccionado) {
        this.seleccionado = seleccionado;
    }
}
