package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Login {
    private String id;
    private String senha;

    public Login(String id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public Login(DadosLogin dados) {
        this.id = dados.id();
        this.senha = dados.senha();
    }


}
