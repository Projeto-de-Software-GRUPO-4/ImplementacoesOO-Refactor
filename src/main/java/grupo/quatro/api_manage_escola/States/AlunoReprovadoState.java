package grupo.quatro.api_manage_escola.States;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Boletim;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.OptionalDouble;

@Component
public class AlunoReprovadoState implements AlunoAprovacaoState {

    @Override
    public void checkState(Boletim boletim, BoletimService boletimService, AlunoRepository alunoRepository) {
        OptionalDouble media = boletimService.listarNotasAlunoEmAnoEMateria(boletim.getAluno_id(), boletim.getAno(), new BigInteger(String.valueOf(boletim.getMateria_id())))
                .stream()
                .mapToDouble(Boletim::getNota)
                .average();
        if (media.isPresent()) {
            if (media.getAsDouble() >= 6.0) {
                try {
                    Aluno aluno = alunoRepository.getReferenceById(boletim.getAluno_id());
                    aluno.setState(new AlunoAprovadoState());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.getClass());
                    System.out.println(Arrays.toString(e.getStackTrace()));
                    System.out.println("Não foi possível localizar o aluno " + boletim.getAluno_id() + " para calcular sua média.");
                }
            }

        }
    }
}
