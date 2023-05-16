package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.*;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosDeslinkarProfessorTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosDeslinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Repository.MateriaRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaProfessorRepository;
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

    @Autowired
    MateriaRepository materiaRepository;

    @Override
    public Usuario salvar(DadosCadastroUsuario dados) throws Exception {
        Optional<Professor> professorOptional = professorRepository.findById(new BigInteger(dados.getCpf()));

        if (professorOptional.isPresent()) {
            throw new Exception("Já existe cadastro desse usuário, não é possível cadastrar novamente.");
        } else {

            Professor professor = new Professor((DadosCadastroProfessor) dados);
            Materia materia = new Materia();
            materia.setId(((DadosCadastroProfessor) dados).getMateria_id());
            professor.setMateria(materia);
            UsuarioCredentials credentials = usuarioCredentialsService.salvar(new DadosCadastroUsuarioCredentials(dados.getCpf(), dados.getSenha(), dados.getUserType()));
            return professorRepository.save(professor);

        }

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

            if (turma.getProfessores().contains(turma)) {
                throw new Exception(String.format("O professor %d e a turma de ID %d já têm vínculo.", dados.id_usuario(), dados.id_turma()));
            }

            turma.getProfessores().add(professor);
            turmaRepository.save(turma);
        } catch (ProfessorNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", dados.id_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", dados.id_turma()));
        };
    }

    @Override
    public void deslinkarATurma(DadosDeslinkarUsuarioTurma dados) throws Exception {

        try {
            Professor professor = professorRepository.findById(dados.getId_usuario()).orElse(null);
            Turma turma = turmaRepository.findById(dados.getId_turma()).orElse(null);
            System.out.println(turma.getProfessores().contains(professor));


            if (!turma.getProfessores().contains(professor)) {
                throw new Exception(String.format("O professor %d e a turma de ID %d não têm vínculo.", dados.getId_usuario(), dados.getId_turma()));
            }

            turma.getProfessores().remove(professor);
            turmaRepository.save(turma);
        } catch (ProfessorNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar o professor de ID %d", dados.getId_usuario()));
        } catch (TurmaNotFoundException e) {
            throw new Exception(String.format("Não foi possível localizar a turma de ID %d", ((DadosDeslinkarProfessorTurma) dados).getId_turma()));
        };
    }

    public List<DadosListagemTurma> resgatarTurmasDoProfessor(BigInteger professor_id) throws Exception {
        return turmaProfessorRepository.getByProfessorId(professor_id)
                .stream()
                .map(DadosListagemTurma::new)
                .toList();
    }
}
