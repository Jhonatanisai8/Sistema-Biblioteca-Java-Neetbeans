package interfacesDao;

import Models.Usuarios;
import java.util.List;

public interface UsuarioDao {

    //metodos 
    public void regristrar(Usuarios usuario);

    public void modificar(Usuarios usuario);

    public void eliminar(int idUsuario);

    public List<Usuarios> listar();

    public Usuarios obtenerInformacionUsuario(int idUsuario);

    public Usuarios obtenerIdUsuario(int idUsuario);

    public void sancionar(Usuarios usuario);
}
