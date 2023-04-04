package grupo.quatro.api_manage_escola.UsuarioCredentials;

import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@NoArgsConstructor
@Getter
@Setter
@Entity(name="Credential")
@Table(name="credentials")
public class UsuarioCredentials {

    @Id
    private String id;
    private String senha;

    private UserType userType;

    public UsuarioCredentials(DadosCadastroUsuarioCredentials dados) {
        this.id = dados.id();
        this.senha = dados.senha();
        this.userType = dados.userType();
    }

    public UsuarioCredentials(String id, String senha, UserType userType) {
        this.id = id;
        this.senha = senha;
        this.userType = userType;
    }

}
