package interfacesDao;

import Models.Libros;
import Models.Prestamos;
import Models.Usuarios;
import java.util.List;

public interface PrestamoDao {

    //metodos 
    public void regristrar(Prestamos prestamo);

    public void modificar(Prestamos prestamo);

    public Prestamos ObtenerPrestamos(Usuarios usuario, Libros libro);

    public List<Prestamos> listar();
}
