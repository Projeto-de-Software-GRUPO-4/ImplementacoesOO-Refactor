package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosAtualizarUsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosChecagemUsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UsuarioCredentialsService {

    @Autowired
    UsuarioCredentialsRepository repository;

    public UsuarioCredentials salvar(DadosCadastroUsuarioCredentials dados) {
        return repository.save(new UsuarioCredentials(dados.id(), dados.senha(), dados.userType()));
    }

//    public boolean verificarSenha(DadosChecagemUsuarioCredentials dados) throws Exception {
//        Optional<UsuarioCredentials> credentialsOptional = repository.findById(dados.usuario_id());
//
//        if (credentialsOptional.isPresent()) {
//            UsuarioCredentials credentials = credentialsOptional.get();
//            return credentials.getSenha().equals(dados.senhaTentativa());
//
//        } else {
//            throw new Exception("Não existe credencial para esse usuário.");
//        }
//
//    }

    public UsuarioCredentials atualizar(DadosAtualizarUsuarioCredentials dados) throws Exception {
        try {
            UsuarioCredentials credentials = repository.getReferenceById(dados.usuario_id());

            if (dados.tentativaSenha().equals(credentials.getSenha())) {
                credentials.changeSenha(dados.novaSenha());

                return credentials;
            } else {
                throw new Exception("A senha não está correta.");
            }

        } catch (Exception e) {
            throw new Exception("Não existe credencial para esse usuário.");
        }

    }

    public void deletar(String id) {
        repository.deleteById(id);
    }


}
