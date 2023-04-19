package grupo.quatro.api_manage_escola.Respond.Exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}