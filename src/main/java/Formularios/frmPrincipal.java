package Formularios;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;
import vistas.RegistrarUsuario;
import vistas.Reportes;
import vistas.darAlta;
import vistas.devoluciones;
import vistas.listasLibros;
import vistas.prestamos;
import vistas.reportesUsuarios;
import vistas.vistaPrincipal;

/*
 * @author Jhonatan
 */
public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
        this.mostrarPanel();
        this.estilos();
        this.fecha();

    }

    private void mostrarPanel() {
        this.colocarPanel(new vistaPrincipal());
    }

    private void colocarPanel(JPanel p) {
        //vistaPrincipal p = new vistaPrincipal();
        p.setSize(878, 440);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        p.setBackground(Color.WHITE);

    }

    private void estilos() {
        this.setTitle("Bienvenido al Sistema");
        this.setLocationRelativeTo(null);
        mensaje.setForeground(Color.BLACK);
        navText.setFont(Font.decode("Consolas"));
        FlatMaterialLighterIJTheme.setup();

        this.colocarPanel(new vistaPrincipal());
    }

    private void fecha() {
        LocalDate nov = LocalDate.now();
//        int anio = nov.getYear();
//        int dia = nov.getDayOfMonth();
//        int month = nov.getMonthValue();
//        String[] meses = {"Enero", "Febrero", "Marzo", "Abril",
//            "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
//            "Octubre", "Noviembre", "Diciembre"};
//
//        navDate.setText("Hoy es " + dia + " de " + meses[month - 1]
//                + " de " + anio);
        Locale spanishLocalDate = new Locale("es", "Es");
        navDate.setText(nov.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocalDate)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bagraund = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPrestamos = new javax.swing.JButton();
        btnDevolouciones = new javax.swing.JButton();
        tbnUsuarios = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnLibros = new javax.swing.JButton();
        btnPrincipal = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        navDate = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bagraund.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(0, 0, 153));
        menu.setPreferredSize(new java.awt.Dimension(240, 642));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("!Lib");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        btnPrestamos.setBackground(new java.awt.Color(0, 0, 204));
        btnPrestamos.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnPrestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libro (1).png"))); // NOI18N
        btnPrestamos.setText("Prestamos");
        btnPrestamos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        btnPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestamosActionPerformed(evt);
            }
        });

        btnDevolouciones.setBackground(new java.awt.Color(0, 0, 204));
        btnDevolouciones.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnDevolouciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devolucion-de-producto (1).png"))); // NOI18N
        btnDevolouciones.setText("Devoluciones");
        btnDevolouciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        btnDevolouciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDevolouciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDevolouciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevoloucionesActionPerformed(evt);
            }
        });

        tbnUsuarios.setBackground(new java.awt.Color(0, 0, 204));
        tbnUsuarios.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        tbnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario (1).png"))); // NOI18N
        tbnUsuarios.setText("Usuarios");
        tbnUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        tbnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tbnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnUsuariosActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(0, 0, 204));
        btnReportes.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reporte (1).png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnLibros.setBackground(new java.awt.Color(0, 0, 204));
        btnLibros.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pila-de-libros-de-tres (1).png"))); // NOI18N
        btnLibros.setText("Libros");
        btnLibros.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        btnLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrosActionPerformed(evt);
            }
        });

        btnPrincipal.setBackground(new java.awt.Color(0, 0, 204));
        btnPrincipal.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/casa (2).png"))); // NOI18N
        btnPrincipal.setText("Principal");
        btnPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 204)));
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDevolouciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolouciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(0, 0, 255));
        header.setPreferredSize(new java.awt.Dimension(150, 150));

        navText.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        navText.setForeground(new java.awt.Color(255, 255, 255));
        navText.setText("Administracion/Control de Biblioteca");

        navDate.setFont(new java.awt.Font("Constantia", 0, 24)); // NOI18N
        navDate.setForeground(new java.awt.Color(255, 255, 255));
        navDate.setText("Hoy es {dayname} de {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navDate, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(navDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        mensaje.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        mensaje.setText("Hola, Bienvenido");

        javax.swing.GroupLayout bagraundLayout = new javax.swing.GroupLayout(bagraund);
        bagraund.setLayout(bagraundLayout);
        bagraundLayout.setHorizontalGroup(
            bagraundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bagraundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bagraundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagraundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bagraundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bagraundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        bagraundLayout.setVerticalGroup(
            bagraundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bagraundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bagraund, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bagraund, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestamosActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new prestamos());
    }//GEN-LAST:event_btnPrestamosActionPerformed

    private void btnDevoloucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevoloucionesActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new devoluciones());
    }//GEN-LAST:event_btnDevoloucionesActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new vistaPrincipal());
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrosActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new listasLibros());
    }//GEN-LAST:event_btnLibrosActionPerformed

    private void tbnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnUsuariosActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new reportesUsuarios());

    }//GEN-LAST:event_tbnUsuariosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        this.colocarPanel(new darAlta());
    }//GEN-LAST:event_btnReportesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */


 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bagraund;
    private javax.swing.JButton btnDevolouciones;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnReportes;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navDate;
    private javax.swing.JLabel navText;
    private javax.swing.JButton tbnUsuarios;
    // End of variables declaration//GEN-END:variables
}
