package grupo.quatro.api_manage_escola.Respond;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainException extends Exception {

    private int code;
    public MainException(String message, int code) {
        super(message);
        this.code = code;
    }


}
