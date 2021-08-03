/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Modelo.ModeloAhorcado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class Jugador {
    private String ruta;
    public Jugador(String ruta){
        this.ruta = ruta;
    }
    public void Escribir(List<ModeloAhorcado> ahorcados){
        try {
            FileWriter archivo = new FileWriter(this.ruta);
            BufferedWriter escritura = new BufferedWriter(archivo);
            for (ModeloAhorcado ahorcado : ahorcados) {
                escritura.append(ahorcado.getUsuario());
                escritura.append(ahorcado.getPalabra());
                escritura.append((char) ahorcado.getIntentos());
            }
            escritura.close();
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<ModeloAhorcado> Imprimir(){
        List<ModeloAhorcado> ahorcados = new  ArrayList<>();
        try {
            FileReader archivo = new FileReader(this.ruta);
            BufferedReader lectura = new BufferedReader(archivo);
            String lineaUsuario = " ";
            String lineaPalabra = " ";
            String lineaIntentos = " ";
            while(lineaIntentos != null&& lineaUsuario != null){
                lineaUsuario = lectura.readLine();
                lineaPalabra = lectura.readLine();
                lineaIntentos = lectura.readLine();
                if(lineaIntentos != null || lineaUsuario != null){
                    ModeloAhorcado e = new ModeloAhorcado(lineaPalabra, lineaUsuario, Integer.parseInt(lineaIntentos));
                    ahorcados.add(e);}
            }
            lectura.close();
            archivo.close();
            return ahorcados;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ahorcados;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
