package Formularios;

import Conexion.Conexion;
import Models.Libros;
import Models.Usuarios;
import interfacesDao.LibroDao;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DaoLibrosImplementacion extends Conexion implements LibroDao {
    
    @Override
    public void regristrar(Libros libro) {
        try {
            this.Conectar();
            
            String sql = "INSERT INTO LIBROS(titulo,fecha,autor,categoria,"
                    + "editorial,idioma,paginas,descripcion,ejemplares,"
                    + "stock,disponibles) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            
            consulta.setString(1, libro.getTitulo());
            consulta.setInt(2, libro.getFecha());
            consulta.setString(3, libro.getAutor());
            consulta.setString(4, libro.getCategoria());
            consulta.setString(5, libro.getEditorial());
            consulta.setString(6, libro.getIdioma());
            consulta.setInt(7, libro.getPaginas());
            consulta.setString(8, libro.getDiscripcion());
            consulta.setString(9, libro.getEjemplares());
            consulta.setInt(10, libro.getStock());
            consulta.setInt(11, libro.getDisponibles());

            //ejecutamos
            consulta.executeUpdate();
            consulta.close();
            
        } catch (SQLException e) {
            System.out.println("Error al insertar Libro => " + e.toString());
        } finally {
            this.cerrarBD();
        }
        
    }

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
    @Override
    public void modificar(Libros libro) {
        try {
            this.Conectar();
            String sql = "UPDATE libros SET titulo = ?, fecha = ?, "
                    + "autor = ?, categoria = ?,"
                    + " editorial = ?, idioma = ?,"
                    + " paginas = ?,"
                    + "descripcion = ?, ejemplares = ?,"
                    + " stock = ?, disponibles = ? "
                    + "where id = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            
            consulta.setString(1, libro.getTitulo());
            consulta.setInt(2, libro.getFecha());
            consulta.setString(3, libro.getAutor());
            consulta.setString(4, libro.getCategoria());
            consulta.setString(5, libro.getEditorial());
            consulta.setString(6, libro.getIdioma());
            consulta.setInt(7, libro.getPaginas());
            consulta.setString(8, libro.getDiscripcion());
            consulta.setString(9, libro.getEjemplares());
            consulta.setInt(10, libro.getStock());
            consulta.setInt(11, libro.getDisponibles());
            consulta.setInt(12, libro.getId());
            
            consulta.executeUpdate();
            consulta.close();
            
        } catch (SQLException e) {
            System.out.println("Error en modificar: " + e.toString());
        } finally {
            this.cerrarBD();
        }
    }
    
    @Override
    public List<Libros> listar() {
        List<Libros> listaLibros = null;
        try {
            this.Conectar();
            String sql = "SELECT * FROM LIBROS";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            
            listaLibros = new ArrayList();
            ResultSet seleccion = consulta.executeQuery();

            //recoremos la tabls libros
            while (seleccion.next()) {
                Libros libros = new Libros();
                
                libros.setId(seleccion.getInt("id"));
                libros.setTitulo(seleccion.getString("titulo"));
                libros.setFecha(seleccion.getInt("fecha"));
                libros.setAutor(seleccion.getString("autor"));
                libros.setCategoria(seleccion.getString("categoria"));
                libros.setEditorial(seleccion.getString("editorial"));
                libros.setIdioma(seleccion.getString("idioma"));
                libros.setPaginas(seleccion.getInt("paginas"));
                libros.setDiscripcion(seleccion.getString("descripcion"));
                libros.setEjemplares(seleccion.getString("ejemplares"));
                libros.setStock(seleccion.getInt("stock"));
                libros.setDisponibles(seleccion.getInt("disponibles"));
                
                listaLibros.add(libros);
                
            }

            //cerramos
            seleccion.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al listar libros => " + e.toString());
        } finally {
            this.cerrarBD();
        }
        
        return listaLibros;
    }
    
    @Override
    public void eliminar(int idLibro) {
        try {
            this.Conectar();
            String sql = "DELETE FROM libros WHERE id = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setInt(1, idLibro);

            //ejecutamos 
            consulta.executeUpdate();

            //cerramos
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar: " + e.toString());
        } finally {
            this.cerrarBD();
        }
    }
    
    @Override
    public Libros obtenerInformacion(int idLibro) {
        Libros libro = new Libros();
        try {
            
            this.Conectar();
            String sql = "SELECT * FROM LIBROS WHERE id = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sql);
            consulta.setInt(1, idLibro);
            
            ResultSet rs = consulta.executeQuery();
            
            while (rs.next()) {
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setFecha(rs.getInt("fecha"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setIdioma(rs.getString("idioma"));
                libro.setPaginas(rs.getInt("paginas"));
                libro.setDiscripcion(rs.getString("descripcion"));
                libro.setEjemplares(rs.getString("ejemplares"));
                libro.setStock(rs.getInt("stock"));
                libro.setDisponibles(rs.getInt("disponibles"));
                
            }
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            System.out.println("Error en Obtener Informacion: " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return libro;
    }

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
    @Override
    public Libros obtenerIdLibro(int libroId) {
        Libros libro = null;
        try {
            this.Conectar();
            String sql = "SELECT * FROM LIBROS WHERE ID = ? LIMIT 1";
            PreparedStatement seleccion = this.conexion.prepareStatement(sql);
            
            seleccion.setInt(1, libroId);
            ResultSet rs = seleccion.executeQuery();
            while (rs.next()) {
                libro = new Libros();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setFecha(rs.getInt("fecha"));
                libro.setAutor(rs.getString("autor"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setIdioma(rs.getString("idioma"));
                libro.setPaginas(rs.getInt("paginas"));
                libro.setDiscripcion(rs.getString("descripcion"));
                libro.setEjemplares(rs.getString("ejemplares"));
                libro.setStock(rs.getInt("stock"));
                libro.setDisponibles(rs.getInt("disponibles"));
            }
        } catch (SQLException e) {
            System.out.println("Error en obtenerIdLibro(int libroId): " + e.toString());
        } finally {
            this.cerrarBD();
        }
        return libro;
    }
    
}
