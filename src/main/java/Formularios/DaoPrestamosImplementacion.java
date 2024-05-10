package Formularios;

import Conexion.Conexion;
import Models.Libros;
import Models.Prestamos;
import Models.Usuarios;
import interfacesDao.PrestamoDao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/*
'user_id', 'int', 'NO', '', NULL, ''
'libro_id', 'int', 'NO', '', NULL, ''
'fechasalida', 'varchar(300)', 'NO', '', NULL, ''

 */
public class DaoPrestamosImplementacion extends Conexion implements PrestamoDao {

    @Override
    public void regristrar(Prestamos prestamo) {
        try {
            this.Conectar();
            String sql = "INSERT INTO PRESTAMOS (user_id,libro_id,fechasalida) VALUES (?,?,?)";

            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setInt(1, prestamo.getUserId());
            consulta.setInt(2, prestamo.getLibroId());
            consulta.setString(3, prestamo.getFechaSalida());

            //ejecutamos
            consulta.executeUpdate();

            //cerramos
            consulta.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar Prestamos: " + e.toString());
        } finally {
            this.cerrarBD();
        }
    }

    @Override
    public void modificar(Prestamos prestamo) {
        try {
            this.Conectar();
            String sql = "UPDATE PRESTAMOS SET user_id = ?, libro_id = ?, fechasalida = ?, fechaingreso = ? WHERE id = ?  ";

            PreparedStatement consulta = this.conexion.prepareStatement(sql);

            consulta.setInt(1, prestamo.getUserId());
            consulta.setInt(2, prestamo.getLibroId());
            consulta.setString(3, prestamo.getFechaSalida());
            consulta.setString(4, prestamo.getFechaIngreso());
            consulta.setInt(5, prestamo.getId());
            

            //ejecutamos
            consulta.executeUpdate();

            //cerramos
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.toString());
        } finally {
            this.cerrarBD();
        }

    }

    @Override
    public Prestamos ObtenerPrestamos(Usuarios usuario, Libros libro) {
        Prestamos prestamo = null;
        try {
            this.Conectar();
            String sql = "SELECT * FROM PRESTAMOS WHERE user_id = ? and libro_id = ? and fechaingreso IS NULL ORDER BY id DESC LIMIT 1 ";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);

            consulta.setInt(1, usuario.getId());
            consulta.setInt(2, libro.getId());

            ResultSet seleccion = consulta.executeQuery();

            while (seleccion.next()) {
                prestamo = new Prestamos();
                prestamo.setId(seleccion.getInt("id"));
                prestamo.setUserId(seleccion.getInt("user_id"));
                prestamo.setLibroId(seleccion.getInt("libro_id"));
                prestamo.setFechaSalida(seleccion.getString("fechasalida"));
                prestamo.setFechaIngreso(seleccion.getString("fechaingreso"));
            }

            //cerramos
            consulta.close();
            seleccion.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener informacion de libro: " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return prestamo;
    }

    @Override
    public List<Prestamos> listar() {
        List<Prestamos> lista = null;
        try {
            this.Conectar();
            String sql = "SELECT * FROM  PRESTAMOS ORDER BY id DESC";

            PreparedStatement consulta = this.conexion.prepareStatement(sql);

            lista = new ArrayList();
            ResultSet seleccion = consulta.executeQuery();

            while (seleccion.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setId(seleccion.getInt("id"));
                prestamo.setUserId(seleccion.getInt("user_id"));
                prestamo.setLibroId(seleccion.getInt("libro_id"));
                prestamo.setFechaSalida(seleccion.getString("fechasalida"));
                prestamo.setFechaIngreso(seleccion.getString("fechaingreso"));

                lista.add(prestamo);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return lista;

    }

}
