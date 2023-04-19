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
import grupo.quatro.api_manage_escola.Respond.Exceptions.AlunoNotFoundException;
import grupo.quatro.api_manage_escola.Respond.Exceptions.TurmaNotFoundException;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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
    public DadosListagemUsuario resgatar(BigInteger id) throws Exception {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            return new DadosListagemAluno(aluno);
        } else {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", id));
        }


    }

    @Override
    public List<DadosListagemAluno> resgatarTodos() {
        return alunoRepository.findAllByActiveTrue()
                .stream()
                .map(DadosListagemAluno::new)
                .toList();
    }

    @Override
    public DadosListagemUsuario atualizar(DadosAtualizacaoUsuario dados) throws Exception {
        try {
            Aluno aluno = alunoRepository.getReferenceById(dados.getId());
            aluno.updateInfo((DadosAtualizacaoAluno) dados);
            return new DadosListagemAluno(aluno);
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", dados.getId()));
        }

    }
    @Override
    public void deletar(BigInteger id) throws Exception {
        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            usuarioCredentialsService.deletar(id.toString());
            aluno.excluir();
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", id));
        }
    }
    @Override
    public void linkarATurma(DadosLinkarUsuarioTurma dados) throws Exception {
        try {
            Aluno aluno = alunoRepository.getReferenceById(dados.id_usuario());
            Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
            aluno.setTurma(turma);
        } catch (AlunoNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", dados.id_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", dados.id_turma()));
        }
    }
    @Override
    public void deslinkarATurma(DadosLinkarUsuarioTurma dados) throws Exception {
        try {
            Aluno aluno = alunoRepository.findById(dados.id_usuario()).orElse(null);
            aluno.setTurma(null);
        } catch (AlunoNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", dados.id_usuario()));
        }
    }
    public void suspender(BigInteger id) throws Exception {
        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            aluno.suspender();
        } catch (AlunoNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", id));
        }
    }
}
