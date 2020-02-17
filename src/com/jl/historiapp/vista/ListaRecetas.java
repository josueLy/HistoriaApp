/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jl.historiapp.vista;

import com.jl.historia.entidad.Historia;
import com.jl.historia.entidad.Receta;
import com.jl.historiapp.controlador.RecetaControlador;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author famleto
 */
public class ListaRecetas extends javax.swing.JFrame {

    private RecetaControlador recetaControlador = new RecetaControlador();
    private CRUDHistoria crudhistoria;
    public int idReceta;
    private DefaultTableModel modelo;
    public ListaRecetas(CRUDHistoria crudhistoria) {
        initComponents();
        this.crudhistoria = crudhistoria;
        modelo = (DefaultTableModel) tblRecetas.getModel();
        Object[] rowData = new Object[3];
        List<Receta> recetas = recetaControlador.listarRecetas(crudhistoria.historia);

        for (int i = 0; i < recetas.size(); i++) {
            rowData[0] = recetas.get(i).getMedicinas();
            rowData[1] = recetas.get(i).getId();SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
            rowData[2] = formato.format(recetas.get(i).getFecha());

            modelo.addRow(rowData);
        }
        tblRecetas.getColumnModel().getColumn(1).setMinWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setMaxWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setWidth(0);
    }

    public ListaRecetas() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblRecetas.getModel();
        Object[] rowData = new Object[3];
        List<Receta> recetas = recetaControlador.listarRecetas(crudhistoria.historia);
        
        
        for (int i = 0; i < recetas.size(); i++) {
            rowData[0] = recetas.get(i).getMedicinas();
            rowData[1] = recetas.get(i).getId();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");  
            rowData[2] = formato.format(recetas.get(i).getFecha());

            modelo.addRow(rowData);
        }
        tblRecetas.getColumnModel().getColumn(1).setMinWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setMaxWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setWidth(0);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecetas = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        dchDesde = new com.toedter.calendar.JDateChooser();
        dchHasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtHasta = new javax.swing.JLabel();
        btnLIstar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recetas del Paciente");

        tblRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Id", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRecetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRecetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecetas);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        dchDesde.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchDesdePropertyChange(evt);
            }
        });

        dchHasta.setEnabled(false);
        dchHasta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dchHastaPropertyChange(evt);
            }
        });

        jLabel1.setText("Desde:");

        txtHasta.setText("Hasta:");

        btnLIstar.setText("Listar");
        btnLIstar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLIstarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnSeleccionar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dchDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(txtHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dchHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLIstar)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dchDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dchHasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(txtHasta)
                    .addComponent(btnLIstar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecetasMouseClicked
        JTable tabla = (JTable) evt.getSource();
        int fila = tabla.getSelectedRow();
        int columna = 1;
        idReceta = Integer.valueOf(tblRecetas.getModel().getValueAt(fila, columna).toString());
   
    }//GEN-LAST:event_tblRecetasMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        this.crudhistoria.llenarReceta(idReceta);
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void dchHastaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchHastaPropertyChange
        Date fechaDesde = dchDesde.getDate();
        Date fechaHasta = dchHasta.getDate();
        if (fechaDesde != null &&  fechaHasta != null){
        List<Receta> recetas = recetaControlador.buscarRecetaPorFecha(fechaDesde, fechaHasta,crudhistoria.historia);
            modelo = (DefaultTableModel) this.tblRecetas.getModel();
            modelo.setRowCount(0);
            Object[] filadata = new Object[3];
            for (Receta receta : recetas) {
                filadata[0] = receta.getMedicinas();
                filadata[1] = receta.getId();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");            
                filadata[2] = formato.format(receta.getFecha());
                modelo.addRow(filadata);
            }
        }
    }//GEN-LAST:event_dchHastaPropertyChange

    private void btnLIstarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLIstarActionPerformed
        modelo.setRowCount(0);
        modelo = (DefaultTableModel) tblRecetas.getModel();
        Object[] rowData = new Object[3];
        List<Receta> recetas = recetaControlador.listarRecetas(this.crudhistoria.historia);

        for (int i = 0; i < recetas.size(); i++) {
            rowData[0] = recetas.get(i).getMedicinas();
            rowData[1] = recetas.get(i).getId();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");            
            rowData[2] = formato.format(recetas.get(i).getFecha());

            modelo.addRow(rowData);
        }
        tblRecetas.getColumnModel().getColumn(1).setMinWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setMaxWidth(0);
        tblRecetas.getColumnModel().getColumn(1).setWidth(0);
    }//GEN-LAST:event_btnLIstarActionPerformed

    private void dchDesdePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dchDesdePropertyChange
        dchHasta.setEnabled(true);
    }//GEN-LAST:event_dchDesdePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaRecetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaRecetas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLIstar;
    private javax.swing.JButton btnSeleccionar;
    private com.toedter.calendar.JDateChooser dchDesde;
    private com.toedter.calendar.JDateChooser dchHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecetas;
    private javax.swing.JLabel txtHasta;
    // End of variables declaration//GEN-END:variables
}
