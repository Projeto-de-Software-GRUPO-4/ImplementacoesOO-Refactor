package org.grupo4.implementacoesoo.Repository;
import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarDTO;
import org.grupo4.implementacoesoo.Domain.User;
import org.grupo4.implementacoesoo.LoginUser.LoginDTO;

public interface UserRepository<T extends User> {

    public T getInfo(String id);
    public boolean saveInfo(User user);

    public LoginDTO getCredentials(String id);

    public boolean saveCredentials(AdicionarDTO adicionarDTO);
}
