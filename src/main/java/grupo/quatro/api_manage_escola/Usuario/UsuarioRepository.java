package grupo.quatro.api_manage_escola.Usuario;

import java.util.ArrayList;

public interface UsuarioRepository {
    //    count, delete, deleteAll, deleteAll, deleteAllById, deleteById, existsById, findById, save
    // getAll, deleteAll, getById, deleteById, save
    public ArrayList<Usuario> getAllUsers();
    public boolean deleteAllUsers();
    public Usuario getUsuario();
    public boolean updateUsuario();
    public boolean deleteUsuario();
}
