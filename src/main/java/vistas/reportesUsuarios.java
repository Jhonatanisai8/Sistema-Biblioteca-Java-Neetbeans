/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import Formularios.DaoUserImplementacion;
import Formularios.frmPrincipal;
import interfacesDao.UsuarioDao;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class reportesUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form listasLibros
     */
    //declaramos variables para el boton buscar 
    private TableRowSorter trsFiltro;
    String filtro;

    public reportesUsuarios() {
        initComponents();
        mostrarTabla();
        estilodPanel();
    }

    private void estilodPanel() {
        txtBuscarUsuario.putClientProperty("JTextField.placeholderText", "Ingrese el usuario a buscar");
    }

    private void mostrarTabla() {
        try {
            //Usuarios usuario = new Usuarios();
            UsuarioDao usuarioDao = new DaoUserImplementacion();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            usuarioDao.listar().forEach((u)
                    -> modelo.addRow(new Object[]{u.getId(), u.getNombre(),
                u.getApellidoPaterno(),
                u.getApellidoMaterno(),
                u.getDomicilio(),
                u.getTelefono()}));

        } catch (Exception e) {
            System.out.println("Mostrar tabla => " + e.toString());
        }
    }

    private void borrar() {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione almenos una fila", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            UsuarioDao usuarioDao = new DaoUserImplementacion();
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (int i : jTable1.getSelectedRows()) {
                try {
                    int idUsuario;
                    idUsuario = (int) jTable1.getValueAt(i, 0);
                    int opcion = JOptionPane.showConfirmDialog(null, """
                                                    Estas seguro(a) de Eliminar al
                                                    Registro de ID: """ + idUsuario
                            + "\nDel Registro", "ELIMINANDO REGISTROS", JOptionPane.WARNING_MESSAGE);
                    if (opcion == 0) {
                        JOptionPane.showMessageDialog(null, "Registro con ID: " + idUsuario
                                + "\n Eliminado", "ELIMINANDO REGISTROS", JOptionPane.WARNING_MESSAGE);
                        usuarioDao.eliminar(idUsuario);
                        modelo.removeRow(i);
                    }
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(null, """
                                                    Upss algo : 
                                                    """ + e.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        // mostrarTabla();
    }

    public void filtro() {//creamos el metodo filtro
        if (txtBuscarUsuario == null) {
        } else {
            try {
                filtro = txtBuscarUsuario.getText();

                //va a buscar en la colunna 1 y buscar lo que esta almacenado en la caja de texto
                trsFiltro.setRowFilter(RowFilter.regexFilter(filtro, 1));
            } catch (Exception e) {
                System.out.println("buscar: " + e.toString());
            }
        }
    }

    private void buscar() {
        txtBuscarUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = txtBuscarUsuario.getText();
                txtBuscarUsuario.setText(cadena);
                repaint();

                // Verificar si trsFiltro está inicializado antes de llamar a filtro()
                if (trsFiltro != null) {
                    filtro();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarUsuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JToggleButton();
        btnNuevo = new javax.swing.JToggleButton();
        btnBorrar = new javax.swing.JToggleButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Usuarios");

        txtBuscarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarUsuarioMouseClicked(evt);
            }
        });
        txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Domicilio", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        frmPrincipal.colocarPanel(new RegistrarUsuario());

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // System.out.println(jTable1.getSelectedRow());
        int fila;
        int idUsuario;
        fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione almenos una fila", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            UsuarioDao usuarioDao = new DaoUserImplementacion();
            idUsuario = (int) jTable1.getValueAt(fila, 0);
            frmPrincipal.colocarPanel(new RegistrarUsuario(usuarioDao.obtenerInformacionUsuario(idUsuario)));
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Haga clik en Buscar Nombre", "Atención", JOptionPane.WARNING_MESSAGE);
        // txtBuscarUsuario.requestFocus();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioKeyTyped
        // TODO add your handling code here:
        trsFiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(trsFiltro);
    }//GEN-LAST:event_txtBuscarUsuarioKeyTyped

    private void txtBuscarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarUsuarioMouseClicked
        // TODO add your handling code here:
        this.buscar();
    }//GEN-LAST:event_txtBuscarUsuarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBorrar;
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscarUsuario;
    // End of variables declaration//GEN-END:variables
}
