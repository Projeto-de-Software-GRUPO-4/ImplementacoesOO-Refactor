package grupo.quatro.api_manage_escola.Commands;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAlunoLogin;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosListagemProfessorLogin;
import grupo.quatro.api_manage_escola.Service.LogInAlunoService;
import grupo.quatro.api_manage_escola.Service.LogInProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProfessorLoginCommand implements LoginCommand {
    private LogInProfessorService logInProfessorService;

    public ProfessorLoginCommand(LogInProfessorService logInProfessorService) {
        this.logInProfessorService = logInProfessorService;
    }

    @Override
    public ResponseEntity execute(DadosLogin dados) {

        DadosListagemProfessorLogin dadosLogin = logInProfessorService.login(dados);
        return new ResponseEntity<>(dadosLogin, HttpStatus.OK);
    }

}
