package grupo.quatro.api_manage_escola.States;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Boletim;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Service.BoletimService;

public interface AlunoAprovacaoState {

    void checkState(Boletim boletim, BoletimService boletimService, AlunoRepository alunoRepository);

}
