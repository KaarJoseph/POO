/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Controlador.EntradaControlador;
import Modelo.Salida;
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
public class ArchivosBinariosAleatorio2 {
    private String ruta;
    public ArchivosBinariosAleatorio2(String ruta){
        this.ruta = ruta;
    }
    public void escribir(List<Salida> Salidas) throws IOException{
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            for (Salida Salida : Salidas) {
                archivo.writeLong(Salida.getId());
                archivo.writeLong(Salida.getHoraEntrada().getTime());
                archivo.writeLong(Salida.getHoraSalida().getTime());
                archivo.writeDouble(Salida.getValor());

            }
            archivo.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
    }
    public List<Salida> leer(EntradaControlador entradaControlador){
        List<Salida>Salidas = new ArrayList<>();
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            while (true) {                
                Salida Salida = new Salida(archivo.readLong(), new Date(archivo.readLong()), new Date(archivo.readLong()), archivo.readDouble());
                
                Salidas.add(Salida);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
        }
        return Salidas;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
}

