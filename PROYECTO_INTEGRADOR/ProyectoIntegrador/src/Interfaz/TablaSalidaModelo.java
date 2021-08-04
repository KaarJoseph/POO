/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.EntradaControlador;
import Controlador.SalidaControlador;
import Controlador.VehiculoControlador;
import Modelo.Entrada;
import Modelo.Salida;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author KAAR_JOSEPH
 */

public class TablaSalidaModelo extends AbstractTableModel {
    private final SimpleDateFormat simpleDateFormat;
    private final SalidaControlador salidaControlador;
    private final EntradaControlador entradaControlador;
    private final Class tipoColumnas[] = new Class[]{Integer.class, String.class, String.class, String.class, Double.class};
    private final String nombreColumnas[] = {"Id", "Vehiculo", "Hora Entrada", "Hora Salida", "Valor"};

    public TablaSalidaModelo(SalidaControlador salidaControlador, EntradaControlador entradaControlador) {
        this.salidaControlador = salidaControlador;
        this.entradaControlador = entradaControlador;   
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tipoColumnas[columnIndex];
    }
    @Override
    public String getColumnName(int columnIndex)
    {
        return nombreColumnas[columnIndex];
    }
    @Override
    public int getRowCount() {
        return salidaControlador.getDatos().size();
    }
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }
    @Override
    public Object getValueAt(int row, int column) {
       Salida Salida = salidaControlador.getDatos().get(row);
        switch (column) {
            case 0:
                return Salida.getId();
            case 1:
                if(Salida.getEntrada() != null)
                    return Salida.getEntrada().getHoraEntrada();
                return "";
            case 2:
                return simpleDateFormat.format(Salida.getHoraEntrada());
            case 3:
                if(Salida.getHoraSalida() != null)
                    return simpleDateFormat.format(Salida.getHoraSalida());
            case 4:
                return Salida.getValor();
        }
        return null;
    }
    @Override
    public void setValueAt(Object value, int row, int column) {
        Salida Salida = salidaControlador.getDatos().get(row);
        try {
            switch (column) {
                case 1:
                    Entrada Entrada = entradaControlador.buscar((Date)value);
                    if(Entrada != null)
                        Salida.setEntrada(Entrada);
                    break;
                case 2:
                    Date date = simpleDateFormat.parse((String) value);
                    Salida.setHoraEntrada(date);
                    break;
                case 3:
                    Date dateSalida = simpleDateFormat.parse((String) value);
                    Salida.setHoraSalida(dateSalida);
                    salidaControlador.actualizar(Salida.getHoraEntrada(), Salida.getHoraSalida());
                    break;
                case 4:
//                    servicio.setValorPagar((Double) value);
                    break;
            }
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column != 0)
            return true;
        return false;
    }
    

}
