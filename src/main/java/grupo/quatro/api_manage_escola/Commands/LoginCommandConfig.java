package grupo.quatro.api_manage_escola.Commands;

import grupo.quatro.api_manage_escola.Service.LogInAlunoService;
import grupo.quatro.api_manage_escola.Service.LogInProfessorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import grupo.quatro.api_manage_escola.Commands.LoginCommand;
import grupo.quatro.api_manage_escola.Commands.AdminLoginCommand;
import grupo.quatro.api_manage_escola.Commands.ProfessorLoginCommand;
import grupo.quatro.api_manage_escola.Commands.AlunoLoginCommand;
import java.util.List;
import java.util.Arrays;

@Configuration
public class LoginCommandConfig {

    @Bean
    public List<LoginCommand> loginCommands(LogInProfessorService professorService, LogInAlunoService alunoService) {
        return Arrays.asList(
                new AdminLoginCommand(),
                new ProfessorLoginCommand(professorService),
                new AlunoLoginCommand(alunoService)
        );
    }
}
