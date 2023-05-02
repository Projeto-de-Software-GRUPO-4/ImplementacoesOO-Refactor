package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.*;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosDeslinkarAlunoTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosDeslinkarUsuarioTurma;
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
    public Usuario salvar(DadosCadastroUsuario dados) throws Exception {
        Optional<Aluno> alunoOptional = alunoRepository.findById(new BigInteger(dados.getCpf()));

        if (alunoOptional.isPresent()) {
            throw new Exception("Já existe cadastro desse usuário, não é possível cadastrar novamente.");
        } else {

            Aluno aluno = alunoRepository.save(new Aluno((DadosCadastroAluno) dados));
            UsuarioCredentials credentials = usuarioCredentialsService.salvar(new DadosCadastroUsuarioCredentials(dados.getCpf(), dados.getSenha(), dados.getUserType()));
            return aluno;

        }


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

    public List<DadosListagemAluno> resgatarTodosDeTurma(BigInteger turma_id) throws Exception {
        Optional<Turma> turmaOptional = turmaRepository.findById(turma_id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            return alunoRepository.findAllByTurma(turma)
                    .stream()
                    .map(DadosListagemAluno::new)
                    .toList();
        } else {
            throw new Exception("Não foi possível achar a turma.");
        }

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

            if (aluno.getTurma() == turma) {
                throw new Exception(String.format("O aluno %d e a turma de ID %d já têm vínculo.", dados.id_usuario(), dados.id_turma()));
            }

            aluno.setTurma(turma);
        } catch (AlunoNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", dados.id_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", dados.id_turma()));
        }
    }

    @Override
    public void deslinkarATurma(DadosDeslinkarUsuarioTurma dados) throws Exception {


            Optional<Aluno> alunoOptional = alunoRepository.findById(dados.getId_usuario());

            if (alunoOptional.isPresent()) {
                Aluno aluno = alunoOptional.get();
                aluno.setTurma(null);
            } else {
                throw new Exception("Não foi possível localizar o aluno " + dados.getId_usuario());
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

    public void expulsar(BigInteger id) throws Exception {
        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            usuarioCredentialsService.deletar(id.toString());
            aluno.excluir();
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível localizar o aluno de ID %d", id));
        }
    }
}
