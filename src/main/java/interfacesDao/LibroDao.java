
package interfacesDao;

import Models.Libros;
import Models.Usuarios;
import java.util.List;

public interface LibroDao {
     //metodos 
    public void regristrar(Libros libro);

    public void modificar(Libros libro);

    public void eliminar(Libros libro);

    public List<Libros> listar();
}
