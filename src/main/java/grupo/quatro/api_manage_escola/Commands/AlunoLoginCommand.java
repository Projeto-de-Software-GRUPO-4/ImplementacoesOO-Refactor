package grupo.quatro.api_manage_escola.Commands;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAlunoLogin;
import grupo.quatro.api_manage_escola.Service.LogInAlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AlunoLoginCommand implements LoginCommand {

    private LogInAlunoService logInAlunoService;

    public AlunoLoginCommand(LogInAlunoService logInAlunoService) {
        this.logInAlunoService = logInAlunoService;
    }

    @Override
    public ResponseEntity execute(DadosLogin dados) {
        DadosListagemAlunoLogin dadosLogin = logInAlunoService.login(dados);
        return new ResponseEntity<>(dadosLogin, HttpStatus.OK);
    }

}
