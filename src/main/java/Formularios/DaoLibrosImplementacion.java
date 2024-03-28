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

    @Override
    public void modificar(Libros libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuarios obtenerInformacion(int idLibro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
