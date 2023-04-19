package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.*;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Repository.TurmaProfessorRepository;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Respond.Exceptions.AlunoNotFoundException;
import grupo.quatro.api_manage_escola.Respond.Exceptions.ProfessorNotFoundException;
import grupo.quatro.api_manage_escola.Respond.Exceptions.TurmaNotFoundException;
import grupo.quatro.api_manage_escola.Respond.Professor.DadosListagemProfessor;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService extends UsuarioService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    TurmaProfessorRepository turmaProfessorRepository;

    @Override
    public Usuario salvar(DadosCadastroUsuario dados) {
        Professor professor = professorRepository.save(new Professor((DadosCadastroProfessor) dados));
        UsuarioCredentials credentials = usuarioCredentialsService.salvar(new DadosCadastroUsuarioCredentials(dados.getCpf(), dados.getSenha(), dados.getUserType()));

        return professor;
    }

    @Override
    public DadosListagemUsuario resgatar(BigInteger id) throws Exception {
        Optional<Professor> professorOptional = professorRepository.findById(id);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            return new DadosListagemProfessor(professor);
        } else {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", id));
        }

    }

    @Override
    public List<DadosListagemProfessor> resgatarTodos() {
        return professorRepository.findAllByActiveTrue()
                .stream()
                .map(DadosListagemProfessor::new)
                .toList();
    }

    @Override
    public DadosListagemUsuario atualizar(DadosAtualizacaoUsuario dados) throws Exception {
        try {
            Professor professor = professorRepository.getReferenceById(dados.getId());
            professor.updateInfo((DadosAtualizacaoProfessor) dados);
            return new DadosListagemProfessor(professor);
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", dados.getId()));
        }
    }

    @Override
    public void deletar(BigInteger id) throws Exception {
        try {
            Professor professor = professorRepository.getReferenceById(id);
            usuarioCredentialsService.deletar(id.toString());
            turmaProfessorRepository.deleteByProfessorId(id);
            professor.excluir();
        } catch (Exception e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", id));
        }
    }

    @Override
    public void linkarATurma(DadosLinkarUsuarioTurma dados) throws Exception {
        try {
            Professor professor = professorRepository.getReferenceById(dados.id_usuario());
            Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
            turma.getProfessores().add(professor);
            turmaRepository.save(turma);
        } catch (ProfessorNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", dados.id_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", dados.id_turma()));
        };
    }

    @Override
    public void deslinkarATurma(DadosLinkarUsuarioTurma dados) throws Exception {
        try {
            Professor professor = professorRepository.findById(dados.id_usuario()).orElse(null);
            Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
            turma.getProfessores().remove(professor);
            turmaRepository.save(turma);
        } catch (ProfessorNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", dados.id_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", dados.id_turma()));
        };
//        Professor professor = professorRepository.findById(dados.id_usuario()).orElse(null);
//        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
//        turma.getProfessores().remove(professor);
//        turmaRepository.save(turma);
    }
}
