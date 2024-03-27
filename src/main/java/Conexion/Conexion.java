package Conexion;

import java.sql.*;

public class Conexion {

    protected Connection conexion;
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private final String Url = "jdbc:mysql://localhost/libreria";
    private final String password = "1234";
    private final String user = "root";

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection(Url, user, password);
            Class.forName(jdbcDriver);
            System.out.println("Conectado a la BD");
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
            System.out.println("Desconectado de la BD");
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexion => " + e.getMessage());
        }
    }
}
