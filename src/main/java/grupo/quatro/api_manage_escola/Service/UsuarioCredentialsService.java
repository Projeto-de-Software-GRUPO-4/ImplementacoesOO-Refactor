package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UsuarioCredentialsService {

    @Autowired
    UsuarioCredentialsRepository repository;

    public UsuarioCredentials salvar(DadosCadastroUsuarioCredentials dados) {
        return repository.save(new UsuarioCredentials(dados.id(), dados.senha(), dados.userType()));
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }


}
