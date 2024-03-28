package vistas;

/*
    id
titulo
fecha
autor
categoria
editorial
paginas
descripcion
ejemplares
stock
diponibles
 */
import Formularios.DaoLibrosImplementacion;
import Models.Libros;
import interfacesDao.LibroDao;
import javax.swing.JOptionPane;

public class darAlta extends javax.swing.JPanel {

    public darAlta() {
        initComponents();
    }

    private void agregarLibro() {
        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            String titulo = txtitulo.getText().trim();
            int anio = Integer.parseInt(txtFechaPublicacion.getText());
            String autor = txtAutor.getText().trim();
            String categoria = txtCategoria.getText().trim();
            int paginas = Integer.parseInt(txtPaginas.getText());
            String descripcion = txtDiscripcion.getText().trim();
            String ejemplares = txtEjemplares.getText().trim();
            String edicion = txtEdicion.getText();
            String idioma = cbxIdioma.getSelectedItem().toString();
            int stock = Integer.parseInt(txtStock.getText());
            int disponibles = Integer.parseInt(txtDisponibles.getText());

            if (!validarAnio(anio)) {
                JOptionPane.showMessageDialog(null, "El año debe de ser positivo", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (!validarPaginas(paginas)) {
                JOptionPane.showMessageDialog(null, "Las paginas deben de ser Positivas positivo", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (!validarStock(stock)) {
                JOptionPane.showMessageDialog(null, "El stock debe de ser positivo", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else if (!validarCantidad(disponibles)) {
                JOptionPane.showMessageDialog(null, "Debe de ser positivo", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                Libros libro = new Libros();
                LibroDao libroDao = new DaoLibrosImplementacion();

                libro.setAutor(autor);
                libro.setCategoria(categoria);
                libro.setDiscripcion(descripcion);
                libro.setDisponibles(disponibles);
                libro.setEditorial(edicion);
                libro.setEjemplares(ejemplares);
                libro.setFecha(anio);
                libro.setPaginas(paginas);
                libro.setStock(stock);
                libro.setIdioma(idioma);
                libro.setTitulo(titulo);

                libroDao.regristrar(libro);

                JOptionPane.showMessageDialog(null, "Libro Insertado");
            }
        }
    }

    public boolean validarCampos() {
        return txtCategoria.getText().trim().isEmpty()
                || txtDisponibles.getText().trim().isEmpty()
                || txtEdicion.getText().trim().isBlank()
                || txtEjemplares.getText().trim().isEmpty()
                || txtFechaPublicacion.getText().trim().isEmpty()
                || cbxIdioma.getSelectedItem().equals("=Selecionar=")
                || txtPaginas.getText().trim().isEmpty()
                || txtStock.getText().trim().isEmpty()
                || txtitulo.getText().trim().isEmpty();
    }

    public boolean validarAnio(int anio) {
        return anio > 0 && anio < 2024;
    }

    public boolean validarPaginas(int cantPaginas) {
        return cantPaginas > 10;
    }

    public boolean validarStock(int stock) {
        return stock > 0;
    }

    public boolean validarCantidad(int disponibles) {
        return disponibles > 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaPublicacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPaginas = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDisponibles = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEjemplares = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbxIdioma = new javax.swing.JComboBox<>();
        txtAutor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDiscripcion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 14, 20, 480));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Subir Nuevo Libro:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 395, -1));

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Título:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 31, 395, 28));

        txtitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtituloActionPerformed(evt);
            }
        });
        add(txtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 395, 30));

        jLabel4.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Fecha de Publicación:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 395, 28));

        txtFechaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPublicacionActionPerformed(evt);
            }
        });
        add(txtFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 395, 30));

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Categoría:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 395, 30));

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });
        add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 395, 30));

        jLabel6.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Editorial:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 395, 30));

        txtEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdicionActionPerformed(evt);
            }
        });
        add(txtEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 395, 30));

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Idioma:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 20, 330, 34));

        jLabel8.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Pagínas:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 111, 330, 34));
        add(txtPaginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 158, 330, 42));
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 255, 145, 30));

        jLabel9.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Stock:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 212, 127, 34));

        txtDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponiblesActionPerformed(evt);
            }
        });
        add(txtDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 255, 145, 30));

        jLabel10.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Disponibles:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 212, 163, 34));

        jLabel11.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Ejemplares:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 340, 38));
        add(txtEjemplares, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 340, 30));

        jButton1.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Subir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 420, 40));

        cbxIdioma.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        cbxIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "Español", "Ingles", "Portuges", "Italiano" }));
        add(cbxIdioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 60, 330, 45));

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });
        add(txtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 390, 30));

        jLabel12.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Autor:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 101, 374, 28));
        add(txtDiscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 410, 30));

        jLabel13.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Discripcion:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 400, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaPublicacionActionPerformed

    private void txtDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponiblesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.agregarLibro();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:


    }//GEN-LAST:event_formComponentAdded

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtituloActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxIdioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDiscripcion;
    private javax.swing.JTextField txtDisponibles;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtEjemplares;
    private javax.swing.JTextField txtFechaPublicacion;
    private javax.swing.JTextField txtPaginas;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtitulo;
    // End of variables declaration//GEN-END:variables
}
