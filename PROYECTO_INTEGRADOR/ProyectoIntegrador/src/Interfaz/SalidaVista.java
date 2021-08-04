/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.EntradaControlador;
import Controlador.SalidaControlador;
import Modelo.Salida;
import Interfaz.TablaSalidaModelo;
import Archivos.ArchivosBinariosAleatorio2;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author KAAR_JOSEPH
 */
public class SalidaVista extends javax.swing.JInternalFrame {
    public EntradaControlador entradaControlador;
    public SalidaControlador salidaControlador;
    public TablaSalidaModelo tablaSalidaModelo;
    public ArchivosBinariosAleatorio2 archivosBinariosAleatorio2;

    public SalidaVista(EntradaControlador entradaControlador,SalidaControlador salidaControlador,ArchivosBinariosAleatorio2 archivosBinariosAleatorio2) {
        initComponents();
        this.entradaControlador= entradaControlador;
        this.salidaControlador= salidaControlador;
        salidaControlador.setDatos(archivosBinariosAleatorio2.leer(entradaControlador));
        tablaSalidaModelo= new TablaSalidaModelo(salidaControlador, entradaControlador);
        tblSalida.setModel(tablaSalidaModelo);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalida = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        tblSalida.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        tblSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VEHICULO", "HORA DE ENTRADA", "HORA DE SALIDA", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblSalida);

        btnNuevo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnEliminar)
                        .addGap(197, 197, 197))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
            boolean resultado= salidaControlador.crear(new Date(), new Date(), 0.0, null);
            System.out.println(resultado);
            tablaSalidaModelo.fireTableDataChanged();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Salida Salida= salidaControlador.getDatos().get(tblSalida.getSelectedRow());
        salidaControlador.eliminar(Salida.getHoraEntrada());
        tablaSalidaModelo.fireTableDataChanged();  
    }//GEN-LAST:event_btnEliminarActionPerformed
     private void guardarDatos(javax.swing.event.InternalFrameEvent evt) throws IOException{
        this.archivosBinariosAleatorio2.escribir(salidaControlador.getDatos());
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalida;
    // End of variables declaration//GEN-END:variables
}
