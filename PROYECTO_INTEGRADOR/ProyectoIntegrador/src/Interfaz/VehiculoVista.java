/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.ClienteControlador;
import Controlador.VehiculoControlador;
import Modelo.Cliente;
import Modelo.Vehiculo;
import Archivos.ArchivoObjeto;
import Archivos.ArchivosBinarios;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KAAR_JOSEPH
 */
public class VehiculoVista extends javax.swing.JInternalFrame {
    public VehiculoControlador vehiculoControlador;
    public ClienteControlador clienteControlador;
    public ArchivosBinarios archivosBinarios ;
    public DefaultTableModel tblModelVehiculos;
    public DefaultComboBoxModel cmbModelCliente;

    public VehiculoVista( VehiculoControlador vehiculoControlador,ClienteControlador clienteControlador,ArchivosBinarios archivosBinarios) {
        initComponents();
        this.vehiculoControlador= vehiculoControlador;
        this.clienteControlador= clienteControlador;
        this.archivosBinarios= archivosBinarios;
        tblModelVehiculos= (DefaultTableModel)tblVehiculos.getModel();
        cmbModelCliente=(DefaultComboBoxModel)cmbCliente.getModel();
        tblVehiculos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if(tblVehiculos.getSelectedRow()>=0){
                vehiculoControlador.setSeleccionado(vehiculoControlador.getListaVehiculo().get(tblVehiculos.getSelectedRow()));
                cargarValores();
            }else{
                limpiarDatos();
                }
            }
        });
        cargarDatosCombo();
        cargarDatosTabla();
    }
    public void limpiarDatos(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        cmbCliente.setSelectedIndex(0);
        vehiculoControlador.setSeleccionado(null);
    }
    
    public void cargarValores(){
        txtPlaca.setText(vehiculoControlador.getSeleccionado().getPlaca());
        txtMarca.setText(vehiculoControlador.getSeleccionado().getMarca());
        txtModelo.setText(vehiculoControlador.getSeleccionado().getModelo());
        cmbCliente.setSelectedItem(vehiculoControlador.getSeleccionado().getPropietario().getNombre());
    }
    
    
    public void cargarDatosTabla(){
        tblModelVehiculos.setRowCount(0);
        for(Vehiculo dato: vehiculoControlador.getListaVehiculo()){
            String datos[]={String.valueOf(dato.getId()),dato.getPlaca(), dato.getMarca(), dato.getModelo(),dato.getPropietario().getNombre()};
            tblModelVehiculos.addRow(datos);
        }
    
    }
    public void cargarDatosCombo(){
        for(Cliente propietario:clienteControlador.getDatos())
        cmbModelCliente.addElement(propietario.getNombre());       
       }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        btnCargarDatossss = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vehiculos");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Placa");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Marca");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Propietario");

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PLACA", "MARCA", "MODELO", "PROPIETARIO"
            }
        ));
        jScrollPane1.setViewportView(tblVehiculos);

        btnCargarDatossss.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCargarDatossss.setText("Cargar");
        btnCargarDatossss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatossssActionPerformed(evt);
            }
        });

        btnGuardarDatos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuardarDatos.setText("Guardar ");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCargarDatossss)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardarDatos)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCargarDatossss)
                            .addComponent(btnGuardarDatos))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    Cliente propietario= clienteControlador.getDatos().get(cmbCliente.getSelectedIndex());
        if(vehiculoControlador.getSeleccionado()!=null){
            boolean resultado =vehiculoControlador.actualizar(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(),propietario);
            System.out.println(resultado);
        }else{
        boolean resultado =vehiculoControlador.crear(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(),propietario);
            System.out.println(resultado);       
        }
        cargarDatosTabla();
        limpiarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(vehiculoControlador.getSeleccionado()!=null){
        boolean resultado= vehiculoControlador.eliminar(vehiculoControlador.getSeleccionado().getPlaca());
            System.out.println(resultado);
            cargarDatosTabla();
            limpiarDatos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        JFileChooser directorio = new JFileChooser();
        int resultado = directorio.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION){
            File seleccionado = directorio.getSelectedFile();
            archivosBinarios.setRuta(seleccionado);
            try {
                archivosBinarios.escribir(vehiculoControlador.getListaVehiculo());
            } catch (IOException ex) {
                Logger.getLogger(VehiculoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void btnCargarDatossssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatossssActionPerformed
        JFileChooser directorio= new JFileChooser();
        int resultado=directorio.showOpenDialog(this);
        if(resultado==JFileChooser.APPROVE_OPTION){
        File seleccionado= directorio.getSelectedFile();
        archivosBinarios.setRuta(seleccionado);
        vehiculoControlador.setListaVehiculo(archivosBinarios.leer(clienteControlador));
        cargarDatosTabla();
        }
        
    }//GEN-LAST:event_btnCargarDatossssActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarDatossss;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
