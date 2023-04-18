package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.*;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.math.BigInteger;
import java.util.List;

@Service
public class AlunoService extends UsuarioService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Usuario salvar(DadosCadastroUsuario dados) {
        Aluno aluno = alunoRepository.save(new Aluno((DadosCadastroAluno) dados));
        UsuarioCredentials credentials = usuarioCredentialsService.salvar(new DadosCadastroUsuarioCredentials(dados.getCpf(), dados.getSenha(), dados.getUserType()));
        return aluno;
    }
    @Override
    public DadosListagemUsuario resgatar(BigInteger id) {
        return new DadosListagemAluno(alunoRepository.findById(id).orElse(null));
    }

    @Override
    public List<DadosListagemAluno> resgatarTodos() {
        return alunoRepository.findAllByActiveTrue()
                .stream()
                .map(DadosListagemAluno::new)
                .toList();
    }

    @Override
    public void atualizar(DadosAtualizacaoUsuario dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.getId());
        aluno.updateInfo((DadosAtualizacaoAluno) dados);
    }
    @Override
    public void deletar(BigInteger id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        usuarioCredentialsService.deletar(id.toString());
        aluno.excluir();
    }
    @Override
    public void linkarATurma(DadosLinkarUsuarioTurma dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id_usuario());
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        aluno.setTurma(turma);
    }
    @Override
    public void deslinkarATurma(DadosLinkarUsuarioTurma dados) {
        Aluno aluno = alunoRepository.findById(dados.id_usuario()).orElse(null);
//        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);

        aluno.setTurma(null);

//        turma.getAlunos().remove(aluno);
//        turmaRepository.save(turma);
    }
    public void suspender(BigInteger id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.suspender();
    }
}
