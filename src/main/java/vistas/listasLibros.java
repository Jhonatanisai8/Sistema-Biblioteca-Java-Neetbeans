package vistas;

import Formularios.DaoLibrosImplementacion;
import Formularios.DaoUserImplementacion;
import Formularios.frmPrincipal;
import interfacesDao.LibroDao;
import interfacesDao.UsuarioDao;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class listasLibros extends javax.swing.JPanel {

    /*
                    /*
                
                titulo
fecha
autor
categoria
editorial
idioma
paginas
descripcion
ejemplares
stock
disponibles
     */
    //variables para buscar
    private TableRowSorter trsFiltro;
    String filtro;

    public listasLibros() {
        initComponents();
        mostrarTablaLibros();
        estilos();
    }

    private void estilos() {
        txtBusacarLibro.putClientProperty("JTextField.placeholderText", "Ingresa el libro a buscar");
    }

    public void mostrarTablaLibros() {
        try {
            LibroDao libroDao = new DaoLibrosImplementacion();

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            libroDao.listar().forEach((u) -> modelo.addRow(new Object[]{
                u.getId(),
                u.getTitulo(),
                u.getFecha(),
                u.getAutor(),
                u.getCategoria(),
                u.getEditorial(),
                u.getIdioma(),
                u.getPaginas(),
                u.getDiscripcion(),
                u.getEjemplares(),
                u.getStock(),
                u.getDisponibles()}));
        } catch (Exception e) {
            System.out.println("Error al mostrar tabla libros => " + e.toString());
        }
    }

    private void filtro() {
        if (txtBusacarLibro == null) {

        } else {
            try {
                filtro = txtBusacarLibro.getText();
                trsFiltro.setRowFilter(RowFilter.regexFilter(filtro, 1));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al Buscar: " + e.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void buscar() {
        txtBusacarLibro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = txtBusacarLibro.getText();
                txtBusacarLibro.setText(cadena);
                repaint();

                // Verificar si trsFiltro está inicializado antes de llamar a filtro()
                if (trsFiltro != null) {
                    filtro();
                }
            }
        });
    }

    private void borrar() {
        int[] filasSeleccionadas = jTable1.getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione al menos una fila", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LibroDao libroDao = new DaoLibrosImplementacion();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        String ids = "";
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            int idlibro = (int) jTable1.getValueAt(filasSeleccionadas[i], 0);
            if (!ids.isEmpty()) {
                ids += ", ";
            }
            //vamos agregando
            ids += "" + idlibro;
        }

        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) de eliminar los registros con ID: " + ids
                + "\nDel registro?", "ELIMINANDO REGISTROS", JOptionPane.WARNING_MESSAGE);
        if (opcion == 0) {
            for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                int idLibro = (int) jTable1.getValueAt(filasSeleccionadas[i], 0);
                libroDao.eliminar(idLibro);
                modelo.removeRow(filasSeleccionadas[i]);
            }
            JOptionPane.showMessageDialog(null, "Registros eliminados", "ELIMINANDO REGISTROS", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void LimpiarTabla(DefaultTableModel modelo) {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBusacarLibro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEditar = new javax.swing.JToggleButton();
        btnNuevo = new javax.swing.JToggleButton();
        btnBorrar = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(51, 51, 255));
        setPreferredSize(new java.awt.Dimension(880, 470));

        jLabel1.setText("Libros:");

        txtBusacarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusacarLibroMouseClicked(evt);
            }
        });
        txtBusacarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusacarLibroKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 102, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Fecha", "Autor", "Categoria", "Edicion", "Idioma", "Páginas", "Descripción", "Ejemplares", "Stock", "Disponibles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtBusacarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusacarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        frmPrincipal.colocarPanel(new darAlta());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBusacarLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusacarLibroMouseClicked
        // TODO add your handling code here:
        this.buscar();
    }//GEN-LAST:event_txtBusacarLibroMouseClicked

    private void txtBusacarLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusacarLibroKeyTyped
        // TODO add your handling code here:ere:
        trsFiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(trsFiltro);

    }//GEN-LAST:event_txtBusacarLibroKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Haga clik en Buscar Libro", "Atención", JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        borrar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int fila;
        int idLibro;
        fila = jTable1.getSelectedRow();

        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione almenos una fila", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            LibroDao libroDao = new DaoLibrosImplementacion();
            idLibro = (int) jTable1.getValueAt(fila, 0);
            frmPrincipal.colocarPanel(new darAlta(libroDao.obtenerInformacion(idLibro)));
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBorrar;
    private javax.swing.JToggleButton btnBuscar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JToggleButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBusacarLibro;
    // End of variables declaration//GEN-END:variables
}
