
package interfacesDao;

import Models.Prestamos;
import java.util.List;

public interface PrestamoDao {
    //metodos 
    public void regristrar(Prestamos prestamo);

    public void modificar(Prestamos prestamo);

    //public void eliminar(Prestamos prestamo);

    public List<Prestamos> listar();
}
