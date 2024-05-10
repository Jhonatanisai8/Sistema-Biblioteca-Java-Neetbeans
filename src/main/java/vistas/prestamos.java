package vistas;

import Formularios.DaoLibrosImplementacion;
import Formularios.DaoPrestamosImplementacion;
import Formularios.DaoUserImplementacion;
import Models.Libros;
import Models.Prestamos;
import Models.Usuarios;
import Utilirias.Utileria;
import interfacesDao.LibroDao;
import interfacesDao.PrestamoDao;
import interfacesDao.UsuarioDao;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class prestamos extends javax.swing.JPanel {

    public prestamos() {
        initComponents();
        estilos();

    }

    private void estilos() {
        txtFolioUsuario.putClientProperty("JTextField.placeholderText", "Ingrese el folio del usuario.");
        txtIdLibro.putClientProperty("JTextField.placeholderText", "Ingrese el ID del Libro a prestar.");
    }

    public void prestar() {
        //pedimos los datos
        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos", "WARINING", JOptionPane.WARNING_MESSAGE);
            txtFolioUsuario.requestFocus();
            // txtIdLibro.requestFocus();
        } else {
            String folioUsuario = txtFolioUsuario.getText();
            String libroId = txtIdLibro.getText();
            if (!Utileria.esNumero(folioUsuario) || !Utileria.esNumero(libroId)) {
                JOptionPane.showMessageDialog(null, """
                                                    Los Campos de ID tanto del Usuario y Libro
                                                     Deben de ser Numeros Enteros  """, "WARINING", JOptionPane.ERROR_MESSAGE);
            } else if (validarCampos()) {
                JOptionPane.showMessageDialog(null, "Los Id deben ser Mayores que 0", "WARNING", JOptionPane.ERROR_MESSAGE);
            }

            try {
                UsuarioDao usuarioDao = new DaoUserImplementacion();
                Usuarios currentsUser = usuarioDao.obtenerIdUsuario(Integer.parseInt(folioUsuario));
                // Validamos existencia del usuario

                if (currentsUser == null) {
                    JOptionPane.showMessageDialog(null, "No se encontro a ningun usuario con ese ID", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
                    txtFolioUsuario.requestFocus();
                    return;
                }

                LibroDao libroDao = new DaoLibrosImplementacion();

                //validamos la existencia del libro
                Libros currentLibro = libroDao.obtenerIdLibro(Integer.parseInt(libroId));
                if (currentLibro == null) {
                    JOptionPane.showMessageDialog(null, "Id del libro No encontrado", "ATENCIÓN", JOptionPane.ERROR_MESSAGE);
                    txtIdLibro.requestFocus();
                    return;
                } //validamos la disponibilidad del libro
                else if (currentLibro.getDisponibles() < 1) {
                    JOptionPane.showMessageDialog(null, "Libro no disponible", "ATENCIÓN", JOptionPane.ERROR);
                    txtIdLibro.requestFocus();
                    return;
                }

                PrestamoDao prestamoDao = new DaoPrestamosImplementacion();

                // Validamos que el usuario no tenga ya ese libro prestado.
                Prestamos curentprestamos = prestamoDao.ObtenerPrestamos(currentsUser, currentLibro);

                if (curentprestamos != null) {
                    JOptionPane.showMessageDialog(this, "Esa persona ya cuenta con el préstamo de ese mismo Libro. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    txtIdLibro.requestFocus();
                    return;
                }

                //todo ok: prestamos el libro
                Prestamos prestamo = new Prestamos();
                prestamo.setUserId(currentsUser.getId());
                prestamo.setLibroId(currentLibro.getId());
                prestamo.setFechaSalida(Utileria.obtenerFechaActual());

                prestamoDao.regristrar(prestamo);

                // Modificamos el libro restandole 1 en disponibilidad.
                currentLibro.setDisponibles(currentLibro.getDisponibles() - 1);
                libroDao.modificar(currentLibro);

                JOptionPane.showMessageDialog(null, "Libro con ID: " + currentLibro.getId() + " Prestado exitosamente a " + currentsUser.getNombre() + "\n", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);

                limpiarcampos();
            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error al Boton prestar: " + e.toString());
            }
        }
    }

    private void limpiarcampos() {
        txtFolioUsuario.setText(null);
        txtIdLibro.setText(null);
        txtFolioUsuario.requestFocus();
    }

    public boolean validarCampos() {
        return txtFolioUsuario.getText().trim().isEmpty()
                || txtIdLibro.getText().trim().isEmpty();
    }

    public boolean validarNumeros(String idUusuario, String idLibro) {
        int numero = Integer.parseInt(idUusuario);
        int numero2 = Integer.parseInt(idLibro);

        return numero <= 0 || numero2 <= 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtFolioUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtIdLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPrestar = new javax.swing.JButton();

        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(880, 470));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prestamo (1).png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel2.setText("Folio Usuario:");

        txtFolioUsuario.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        txtFolioUsuario.setBorder(null);

        txtIdLibro.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        txtIdLibro.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel3.setText("Libro ID:");

        btnPrestar.setBackground(new java.awt.Color(51, 51, 255));
        btnPrestar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnPrestar.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestar.setText("Prestar");
        btnPrestar.setBorderPainted(false);
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnPrestar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                            .addComponent(jSeparator3))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFolioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFolioUsuario)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdLibro)
                        .addGap(1, 1, 1)
                        .addComponent(jSeparator3)
                        .addGap(36, 36, 36)
                        .addComponent(btnPrestar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(185, 185, 185)))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        // TODO add your handling code here:
        prestar();
    }//GEN-LAST:event_btnPrestarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrestar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtFolioUsuario;
    private javax.swing.JTextField txtIdLibro;
    // End of variables declaration//GEN-END:variables
}
