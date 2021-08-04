/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controlador.ClienteControlador;
import Modelo.Cliente;
import Archivos.ArchivoTexto;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.ls.LSException;

/**
 *
 * @author KAAR_JOSEPH
 */
public class ClienteVista extends javax.swing.JInternalFrame {
    private ClienteControlador clienteControlador;
    private DefaultTableModel tblModelCliente;
    private int posicion;
    private ArchivoTexto archivoTexto;

    public ClienteVista(ClienteControlador clienteControlador) {
        initComponents();
        archivoTexto= new ArchivoTexto("/Users/GAMER I7 10TH GEN/Desktop/ParqueaderoEmov/src/archivo/ClienteArchivo");
        this.clienteControlador = clienteControlador;
        tblModelCliente=(DefaultTableModel)tblDatos.getModel();
        this.cargarDatos();
        tblDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {//escuha cuando se de clic en unos de los items de la tabla
            public void valueChanged(ListSelectionEvent lse) {
                cargarElemento(tblDatos.getSelectedRow());
            }
        });
        
    }
    
    public void cargarDatos(){
    tblModelCliente.setRowCount(0);
    for(Modelo.Cliente cliente: clienteControlador.getDatos()){
        String datos[]={String.valueOf(cliente.getId()), cliente.getNombre(), cliente.getApellido(),cliente.getCedula()};
        tblModelCliente.addRow(datos);
    }
    }
    public void cargarElemento(int posicion){
        this.posicion= posicion;
        if(posicion>=0){
            Cliente cliente= clienteControlador.getDatos().get(posicion);
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtCedula.setText(cliente.getCedula());
        }else{
            txtNombre.setText(" ");
            txtApellido.setText(" ");
            txtCedula.setText(" ");
        }
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnGuardarArchivo = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");

        lblNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblApellido.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblApellido.setText("Apellido");

        lblCedula.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCedula.setText("Cedula");

        btnCrear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tblDatos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "CEDULA"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnLeer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLeer.setText("Leer Archivo");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnGuardarArchivo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGuardarArchivo.setText("Guardar Archivo");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnEliminar)
                                .addGap(27, 27, 27)
                                .addComponent(btnGuardarArchivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnActualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCedula)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)))
                                .addComponent(btnLeer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeer))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrear)
                            .addComponent(btnEliminar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnGuardarArchivo)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        boolean resultado = clienteControlador.crear(txtNombre.getText(), txtApellido.getText(), txtCedula.getText());
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        this.cargarDatos();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        boolean resultado=clienteControlador.eliminar(txtCedula.getText());
        this.cargarDatos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        boolean resultado= clienteControlador.actualizar(this.posicion,txtNombre.getText());
        txtNombre.setText(" ");
        this.cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        archivoTexto.escribir(clienteControlador.getDatos());
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        clienteControlador.setDatos(archivoTexto.leer());
        this.cargarDatos();
    }//GEN-LAST:event_btnLeerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnLeer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
