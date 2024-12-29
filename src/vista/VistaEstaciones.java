/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.EstacionControlador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estacion;

/**
 *
 * @author Heidy
 */
public class VistaEstaciones extends javax.swing.JFrame {

    /**
     * Creates new form VistaEstaciones
     */
    public VistaEstaciones() {
        initComponents();
        setTitle("Estaciones");
        cargarEstacionesEnTabla(tablaEstaciones);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEstacionId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        btnBorrar = new javax.swing.JButton();
        btnLeerTodos = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstaciones = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Estaciones");

        jLabel1.setText("Aquí podrás gestionar las estaciones");

        jLabel3.setText("estacion_id");

        jLabel4.setText("ubicación");

        jLabel5.setText("estado");

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Habilitada", "Inhabilitada" }));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLeerTodos.setText("Leer todos");
        btnLeerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerTodosActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLeer.setText("Leer");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaEstaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "estacion_id", "ubicación", "estado"
            }
        ));
        jScrollPane1.setViewportView(tablaEstaciones);

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstacionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLeerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAtras)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLeer))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEstacionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear)
                                .addGap(16, 16, 16)
                                .addComponent(btnEditar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLeer)
                                .addGap(16, 16, 16)
                                .addComponent(btnBorrar)))
                        .addGap(18, 18, 18)
                        .addComponent(btnLeerTodos)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int estacionId = Integer.parseInt(txtEstacionId.getText());
        
        EstacionControlador estacionControlador = new EstacionControlador();
        estacionControlador.eliminarEstacion(estacionId);
        
        JOptionPane.showMessageDialog(this, "Estación eliminada correctamente.");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLeerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerTodosActionPerformed
        cargarEstacionesEnTabla(tablaEstaciones);
    }//GEN-LAST:event_btnLeerTodosActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String ubicacion = txtUbicacion.getText();
        String estado = (String) txtEstado.getSelectedItem();
        
        Estacion estacion = new Estacion(ubicacion,estado);
        
        EstacionControlador estacionControlador = new EstacionControlador();
        estacionControlador.insertarEstacion(estacion);    
        
        JOptionPane.showMessageDialog(this, "Estación creada correctamente.");
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        int estacionId = Integer.parseInt(txtEstacionId.getText());
        
        EstacionControlador estacionControlador = new EstacionControlador();
        Estacion estacion = estacionControlador.obtenerEstacionPorId(estacionId);
        
         // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaEstaciones.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);
        
        if (estacion != null) {
            // Agregar una única fila al modelo
            modelo.addRow(new Object[]{
                estacion.getId(),                   
                estacion.getUbicacion(),              
                estacion.getEstado(), 
            });
        } else {
            // Mostrar mensaje si no se encontró la visita
            JOptionPane.showMessageDialog(null, "No se encontró la estación con el ID especificado.",
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int estacionId = Integer.parseInt(txtEstacionId.getText());
        String ubicacion = txtUbicacion.getText();
        String estado = (String) txtEstado.getSelectedItem();
        
        EstacionControlador estacionControlador = new EstacionControlador();
        Estacion estacion = new Estacion(ubicacion,estado);
        
        estacionControlador.actualizarEstacion(estacionId, estacion);
        
        JOptionPane.showMessageDialog(this, "Estación actualizada correctamente.");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
            dispose();
            VistaAdministracion vistaAdministracion = new VistaAdministracion();
            vistaAdministracion.setLocationRelativeTo(null);
            vistaAdministracion.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed
    
    public void cargarEstacionesEnTabla(javax.swing.JTable tablaEstaciones) {
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaEstaciones.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Crear un controlador o acceso al DAO de Estaciones
        EstacionControlador estacionControlador = new EstacionControlador();

        // Obtener todas las estaciones desde el controlador
        List<Estacion> estaciones = estacionControlador.obtenerTodasLasEstaciones();

        // Iterar por la lista de estaciones y agregar filas al modelo
        for (Estacion estacion : estaciones) {
            modelo.addRow(new Object[]{
                estacion.getId(),                   // ID de la estación
                estacion.getUbicacion(),            // Ubicación de la estación
                estacion.getEstado(),               // Estado de la estación
            });
        }
    }
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnLeerTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstaciones;
    private javax.swing.JTextField txtEstacionId;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
