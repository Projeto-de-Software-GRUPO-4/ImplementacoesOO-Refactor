package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Domain.Usuario;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Repository.TurmaProfessorRepository;
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
    public DadosListagemUsuario resgatar(BigInteger id) {
        return new DadosListagemProfessor(professorRepository.findById(id).orElse(null));
    }

    @Override
    public List<DadosListagemProfessor> resgatarTodos() {
        return professorRepository.findAllByActiveTrue()
                .stream()
                .map(DadosListagemProfessor::new)
                .toList();
    }

    @Override
    public void atualizar(DadosAtualizacaoUsuario dados) {
        Professor professor = professorRepository.getReferenceById(dados.getId());
        professor.updateInfo((DadosAtualizacaoProfessor) dados);
    }

    @Override
    public void deletar(BigInteger id) {
        Professor professor = professorRepository.getReferenceById(id);
        usuarioCredentialsService.deletar(id.toString());
        turmaProfessorRepository.deleteByProfessorId(id);
        professor.excluir();
    }

    @Override
    public void linkarATurma(DadosLinkarUsuarioTurma dados) {
        Professor professor = professorRepository.findById(dados.id_usuario()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().add(professor);
        turmaRepository.save(turma);
    }

    @Override
    public void deslinkarATurma(DadosLinkarUsuarioTurma dados) {
        Professor professor = professorRepository.findById(dados.id_usuario()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().remove(professor);
        turmaRepository.save(turma);
    }
}
