package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosCadastroTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosLinkarProfessorTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.TurmaProfessorRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    TurmaProfessorRepository turmaProfessorRepository;

    public Turma salvar(DadosCadastroTurma dados) throws Exception {
        Optional<Turma> turmaOptional = Optional.ofNullable(turmaRepository.findByAnoEscolarAndLetra(dados.anoEscolar(), dados.letra()));

        if (turmaOptional.isPresent()) {
            throw  new Exception("A turma " + dados.anoEscolar() + dados.letra() + " já existe, não é possível cadastrar novamente.");
        } else {
            return turmaRepository.save(new Turma(dados));
        }

    }

    public List<DadosListagemTurma> listar() {
        return turmaRepository.findAll().stream().map(DadosListagemTurma::new).toList();
    }

    public List<DadosListagemTurma> listarTurmasDeAnoEscolar(int anoEscolar) {
        return turmaRepository.findAllByAnoEscolar(anoEscolar).stream().map(DadosListagemTurma::new).toList();
    }

    public DadosListagemTurma listarTurmaEspecifica(DadosCadastroTurma dados) {
        return new DadosListagemTurma(turmaRepository.findByAnoEscolarAndLetra(dados.anoEscolar(), dados.letra()));
    }

}
