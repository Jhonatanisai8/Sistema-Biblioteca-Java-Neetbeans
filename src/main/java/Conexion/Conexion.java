package Conexion;

import java.sql.*;

public class Conexion {

    Connection conexion;
    private final String jdbcDriver = "com.mysql.jdbc.Driver";
    private final String Url = "jdbc:mysql://localhost/libreria";
    private final String password = "1234";
    private final String user = "root";

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection(Url, user, password);
            Class.forName(jdbcDriver);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar => " + e.getMessage());
        }
    }

    public void cerrarBD() {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion => " + e.getMessage());
        }
    }
}
