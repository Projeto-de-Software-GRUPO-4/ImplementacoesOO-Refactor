package grupo.quatro.api_manage_escola.States;

import grupo.quatro.api_manage_escola.Domain.Boletim;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Service.BoletimService;

public class AlunoAprovadoState implements AlunoAprovacaoState {


    @Override
    public void checkState(Boletim boletim, BoletimService boletimService, AlunoRepository alunoRepository) {
        // Do nothing

    }
}
