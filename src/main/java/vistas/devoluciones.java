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
import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class devoluciones extends javax.swing.JPanel {

    private final int diasMaximos = 5;
    private final int sacncionDia = 20;

    public devoluciones() {
        initComponents();
        estilos();
    }

    private void estilos() {
        txtFolioUsuario.putClientProperty("JTextField.placeholderText", "Ingrese el folio del usuario.");
        txtLibroId.putClientProperty("JTextField.placeholderText", "Ingrese el ID del Libro a devolver.");
    }

    private void devolverLibro() {

        if (validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor completar los campos", "WARINING", JOptionPane.WARNING_MESSAGE);
            txtFolioUsuario.requestFocus();
        } else {
            String folioUsuario = txtFolioUsuario.getText();
            String libroId = txtLibroId.getText();
            if (!Utileria.esNumero(folioUsuario) || !Utileria.esNumero(libroId)) {
                JOptionPane.showMessageDialog(null, """
                                                    Los Campos de ID tanto del Usuario y Libro
                                                     Deben de ser Numeros Enteros  """, "WARINING", JOptionPane.ERROR_MESSAGE);
            } else if (comprobarNumero(folioUsuario, libroId)) {
                JOptionPane.showMessageDialog(null, "Los Id deben ser Mayores que 0", "WARNING", JOptionPane.ERROR_MESSAGE);
            }

            try {
                UsuarioDao usuarioDao = new DaoUserImplementacion();
                // Validamos existencia del usuario
                Usuarios currentsUser = usuarioDao.obtenerIdUsuario(Integer.parseInt(folioUsuario));

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
                    txtLibroId.requestFocus();
                    return;
                }

                PrestamoDao prestamoDao = new DaoPrestamosImplementacion();

                // Validamos que el usuario tenga ese libro prestado.
                Prestamos curentprestamos = prestamoDao.ObtenerPrestamos(currentsUser, currentLibro);

                if (curentprestamos == null) {
                    JOptionPane.showMessageDialog(this, "No se ha podido encontrar el préstamo correspiendote a los datos ingresados. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    txtLibroId.requestFocus();
                    return;
                }
                // Todo OK: Devolvemos libro.
                curentprestamos.setFechaIngreso(Utileria.obtenerFechaActual());
                prestamoDao.modificar(curentprestamos);

                // Modificamos el libro sumandole 1 en disponibilidad.
                currentLibro.setDisponibles(currentLibro.getDisponibles() + 1);
                libroDao.modificar(currentLibro);

                JOptionPane.showMessageDialog(null, "Libro con ID: " + currentLibro.getId() + " Devuelto exitosamente a " + currentsUser.getNombre() + "\n", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);

                limpiarcampos();

                //verificamos sanciones
                int dias = Utileria.diferenciasFechas(Utileria.stringtoDate(curentprestamos.getFechaSalida()), new Date());

                if (dias > diasMaximos) {
                    int diferenciaDias = dias - diasMaximos;
                    int sancionDinero = diferenciaDias * sacncionDia;

                    //aumentamos sancion del usuario y en dinero
                    currentsUser.setSanciones(currentsUser.getSanciones() + 1);
                    currentsUser.setDineroSanciones(currentsUser.getDineroSanciones() + sancionDinero);
                    JOptionPane.showMessageDialog(this, "¡USUARIO SANCIONADO POR ENTREGA A DESTIEMPO! ($" + sancionDinero + ") \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (HeadlessException | NumberFormatException | ParseException e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al prestar el libro. \n", "AVISO", JOptionPane.ERROR_MESSAGE);
                System.out.println("error en devolver libro: " + e.toString());
            }
        }
    }

    private void limpiarcampos() {
        txtFolioUsuario.setText(null);
        txtLibroId.setText(null);
        txtFolioUsuario.requestFocus();
    }

    private boolean comprobarNumero(String num, String num2) {
        int nume1, nume2;
        nume1 = Integer.parseInt(num);
        nume2 = Integer.parseInt(num2);

        return nume1 <= 0 || nume2 <= 0;
    }

    private boolean validarCampos() {
        return txtFolioUsuario.getText().trim().isEmpty()
                || txtLibroId.getText().trim().isEmpty();
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
        jLabel2 = new javax.swing.JLabel();
        txtFolioUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtLibroId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(880, 470));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Devolucion de Libro");

        jLabel2.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel2.setText("Folio Usuario:");

        txtFolioUsuario.setFont(new java.awt.Font("FrankRuehl", 0, 14)); // NOI18N
        txtFolioUsuario.setBorder(null);

        txtLibroId.setFont(new java.awt.Font("FrankRuehl", 0, 14)); // NOI18N
        txtLibroId.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        jLabel3.setText("Libro Id:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libro (3) (1).png"))); // NOI18N

        jButton1.setText("Devolver Libro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtLibroId, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(9, 9, 9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFolioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFolioUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLibroId, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(130, 130, 130))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        devolverLibro();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtFolioUsuario;
    private javax.swing.JTextField txtLibroId;
    // End of variables declaration//GEN-END:variables
}
