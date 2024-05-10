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
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class darAlta extends javax.swing.JPanel {

    boolean isEdition = false;
    Libros libroEditado;

    public darAlta() {
        initComponents();
        estilosJtext();
    }

    //panel para editar
    public darAlta(Libros libro) {
        initComponents();
        isEdition = true;
        libroEditado = libro;
        estilosJtext();
    }

    private void estilosJtext() {
        txtitulo.putClientProperty("JTextField.placeholderText", "Ingrese el Titulo");
        txtAutor.putClientProperty("JTextField.placeholderText", "Ingrese el Autor");
        txtFechaPublicacion.putClientProperty("JTextField.placeholderText", "Ingrese el Fecha de Publicacíon");
        txtEdicion.putClientProperty("JTextField.placeholderText", "Ingrese la Editorial");
        txtDiscripcion.putClientProperty("JTextField.placeholderText", "Ingrese pequeña Discripcion");
        txtPaginas.putClientProperty("JTextField.placeholderText", "Ingrese la cantidad de paginas");
        txtStock.putClientProperty("JTextField.placeholderText", "Ingrese el stock");
        txtDisponibles.putClientProperty("JTextField.placeholderText", "Ingrese cantidad de disponibles");
        txtEjemplares.putClientProperty("JTextField.placeholderText", "Ingrese cuantos ejemplares");

        if (isEdition) {
            lbltitulo.setText("Informacion del libro");
            jButton1.setText("Guardar Informacion");

            if (libroEditado != null) {
                
                
                txtitulo.setText(libroEditado.getTitulo());

                txtAutor.setText(libroEditado.getAutor());

                txtDisponibles.setText(libroEditado.getDisponibles() + "");

                txtEdicion.setText(libroEditado.getEditorial());

                txtDiscripcion.setText(libroEditado.getDiscripcion());

                txtEjemplares.setText(libroEditado.getEjemplares());

                txtFechaPublicacion.setText(libroEditado.getFecha() + "");

                cbxCategoria.setSelectedItem(libroEditado.getCategoria());

                cbxIdioma.setSelectedItem(libroEditado.getIdioma());

                txtStock.setText(libroEditado.getStock() + "");

                txtPaginas.setText(libroEditado.getPaginas() + "");

            }
        }
    }

    private void agregarLibro() {
        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            String titulo = txtitulo.getText().trim();
            int anio = Integer.parseInt(txtFechaPublicacion.getText());
            String autor = txtAutor.getText().trim();
            String categoria = cbxCategoria.getSelectedItem().toString();
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
                Libros libro;
                if (isEdition) {
                    libro = libroEditado;
                } else {
                    libro = new Libros();
                }

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

                try {
                    LibroDao libroDao = new DaoLibrosImplementacion();
                    if (!isEdition) {
                        libroDao.regristrar(libro);
                    } else {
                        libroDao.modificar(libro);

                    }

                    String mensaje;

                    if (isEdition) {
                        mensaje = "Libro Modificado";
                    } else {
                        mensaje = "Libro Agregado";
                    }

                    JOptionPane.showMessageDialog(null, mensaje);
                } catch (HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error en; " + e.toString());
                }

            }
        }
    }

    public boolean validarCampos() {
        return cbxCategoria.getSelectedItem().equals("=Seleccionar=")
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
        lbltitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaPublicacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        cbxCategoria = new javax.swing.JComboBox<>();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbltitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbltitulo.setText("Subir Nuevo Libro:");

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Título:");

        txtitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtituloActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Fecha de Publicación:");

        txtFechaPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaPublicacionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Categoría:");

        jLabel6.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Edicion:");

        txtEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdicionActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Idioma:");

        jLabel8.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Pagínas:");

        jLabel9.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Stock:");

        txtDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponiblesActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Disponibles:");

        jLabel11.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Ejemplares:");

        jButton1.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Subir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxIdioma.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        cbxIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "Español", "Ingles", "Portuges", "Italiano" }));

        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Autor:");

        jLabel13.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Discripcion:");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "Novela", "Cuento", "Poesía", "Teatro", "Ciencia Ficcion", "Misterio", "Romance", "Fantasía", "Terror", "AutoBiografia", "Biografía", "Ensayo", "Historia", "Ciencia", "Tecnología", "Politíca", "Filosofia", "Religión", "Autoayuda" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cbxIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(txtDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbltitulo)
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtDiscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbxIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
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
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxIdioma;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtAutor;
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
