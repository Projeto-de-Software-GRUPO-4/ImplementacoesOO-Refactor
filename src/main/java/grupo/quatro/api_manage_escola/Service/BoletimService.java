package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Boletim;
import grupo.quatro.api_manage_escola.Receive.Boletim.DadosRegistrarBoletim;
import grupo.quatro.api_manage_escola.Repository.AlunoBoletimRepository;
import grupo.quatro.api_manage_escola.Repository.BoletimRepository;
import grupo.quatro.api_manage_escola.Respond.AlunoBoletim.DadosListagemAlunoBoletim;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Respond.Professor.DadosListagemProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class BoletimService {

    @Autowired
    BoletimRepository boletimRepository;

    @Autowired
    AlunoBoletimRepository alunoBoletimRepository;

    public List<DadosListagemAlunoBoletim> listarNotasDeUmaTurma(@PathVariable int materia_id, @PathVariable Year ano) {
        return alunoBoletimRepository.getNotasAlunosTurma(ano, materia_id)
                .stream()
                .map(DadosListagemAlunoBoletim::new)
                .toList();
    }

    public Message registrar(DadosRegistrarBoletim dados) throws Exception{
        try {
            // Check if already exists
            Optional<Boletim> boletimOptional = boletimRepository.findByBimestreAndAluno_Id(dados.bimestre(), dados.aluno_id());

            if (boletimOptional.isPresent()) {
                // Just update
                Boletim boletim = boletimRepository.getReferenceById(boletimOptional.get().getId());
                boletim.updateInfo(dados);
                return new Message("Boletim " + boletim.getBimestre() + " - " + boletim.getAluno_id() + " salvo com sucesso.");

            } else {
                // Save
                Boletim boletim = boletimRepository.save(new Boletim(dados));
                return new Message("Boletim " + boletim.getBimestre() + " - " + boletim.getAluno_id() + " salvo com sucesso.");
            }


        } catch (Exception e) {
            throw new Exception("Não foi possível salvar a nota " + dados.nota() + " do bimestre " + dados.bimestre() + " do aluno de id " + dados.aluno_id());
        }
    }



}
