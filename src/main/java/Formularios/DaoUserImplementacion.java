package Formularios;

import Conexion.Conexion;
import Models.Usuarios;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DaoUserImplementacion extends Conexion
        implements interfacesDao.UsuarioDao {

    @Override
    public void regristrar(Usuarios usuario) {
        try {
            this.Conectar();
            String sql = "INSERT INTO USUARIOS (nombre,apellidopaterno,apellidomaterno,domicilio,telefono) VALUES (?,?,?,?,?);";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellidoPaterno());
            consulta.setString(3, usuario.getApellidoMaterno());
            consulta.setString(4, usuario.getDomicilio());
            consulta.setString(5, usuario.getTelefono());
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error el insertar => " + e.getMessage());
        } finally {
            this.cerrarBD();
        }
    }

    @Override
    public void modificar(Usuarios usuario) {
        try {
            this.Conectar();
            String sql = "UPDATE Usuarios set nombre = ?, apellidopaterno = ?,apellidomaterno = ?,domicilio = ?,telefono = ? Where id = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getApellidoPaterno());
            consulta.setString(3, usuario.getApellidoMaterno());
            consulta.setString(4, usuario.getDomicilio());
            consulta.setString(5, usuario.getTelefono());
            consulta.setInt(6, usuario.getId());

            consulta.executeUpdate();

            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error el insertar => " + e.getMessage());
        } finally {
            this.cerrarBD();
        }
    }

    @Override
    public void eliminar(int idusuario) {
        try {
            this.Conectar();
            String sql = "DELETE FROM USUARIOS WHERE ID = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setInt(1, idusuario);
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar => " + e.toString());
        } finally {
            this.cerrarBD();
        }
    }

    @Override
    public List<Usuarios> listar() {
        List<Usuarios> lista = null;
        try {
            this.Conectar();
            String sql;
            sql = "SELECT * FROM usuarios";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            lista = new ArrayList();
            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                Usuarios usuario = new Usuarios();

                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoPaterno(rs.getString("apellidopaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidomaterno"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setSanciones(rs.getInt("sanciones"));
                usuario.setDineroSanciones(rs.getInt("dinerosancionado"));

                //agreagamos a la lista
                lista.add(usuario);

            }
            //cerramos
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al litar => " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return lista;
    }

    @Override
    public Usuarios obtenerInformacionUsuario(int idUsuario) {
        Usuarios usuario = new Usuarios();
        try {
            this.Conectar();
            String sql = "SELECT * FROM USUARIOS WHERE Id = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setInt(1, idUsuario);

            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoPaterno(rs.getString("apellidopaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidomaterno"));
                usuario.setDomicilio(rs.getString("domicilio"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setSanciones(rs.getInt("sanciones"));
                usuario.setDineroSanciones(rs.getInt("dinerosancionado"));
            }
            //cerramos
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al litar => " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return usuario;
    }
}
