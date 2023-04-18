package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Usuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public abstract class UsuarioService<T> {

    @Autowired
    UsuarioCredentialsService usuarioCredentialsService;

    @Autowired
    TurmaRepository turmaRepository;
    public abstract Usuario salvar(DadosCadastroUsuario dados);
    public abstract DadosListagemUsuario resgatar(BigInteger id);
    public abstract List<T> resgatarTodos();
    public abstract void atualizar(DadosAtualizacaoUsuario dados);
    public abstract void deletar(BigInteger id);
    public abstract void linkarATurma(DadosLinkarUsuarioTurma dados);
    public abstract void deslinkarATurma(DadosLinkarUsuarioTurma dados);


}
