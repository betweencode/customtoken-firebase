package mx.betweencode.customtoken.customtoken.autenticacion.modelos;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.ToString;

@Data
public class ResponseLogin {
    private String tokenfirebase;
}
