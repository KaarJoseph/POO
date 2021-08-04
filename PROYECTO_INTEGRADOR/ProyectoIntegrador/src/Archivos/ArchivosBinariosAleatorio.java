/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Controlador.EntradaControlador;
import Controlador.VehiculoControlador;
import Modelo.Entrada;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KAAR_JOSEPH
 */
public class ArchivosBinariosAleatorio {
    private String ruta;
    public ArchivosBinariosAleatorio(String ruta){
        this.ruta = ruta;
    }
    public void escribir(List<Entrada> Entradas) throws IOException{
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            for (Entrada Entrada : Entradas) {
                archivo.writeLong(Entrada.getId());
                archivo.writeLong(Entrada.getHoraEntrada().getTime());
                archivo.writeUTF(Entrada.getVehiculo().getPlaca());
            }
            archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
    }
    public List<Entrada> leer(VehiculoControlador vehiculoControlador){
        List<Entrada> Entradas = new ArrayList<>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            while (true) {                
                Entrada Entrada = new Entrada(archivo.readLong(),new Date(archivo.readLong()));
                Entrada.setVehiculo(vehiculoControlador.buscar(archivo.readUTF()));
                Entradas.add(Entrada);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
        return Entradas;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}
