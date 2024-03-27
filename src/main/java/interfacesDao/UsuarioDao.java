package interfacesDao;

import Models.Usuarios;
import java.util.List;

public interface UsuarioDao {

    //metodos 
    public void regristrar(Usuarios usuario);

    public void modificar(Usuarios usuario);

    public void eliminar(Usuarios usuario);

    public List<Usuarios> listar();
}
