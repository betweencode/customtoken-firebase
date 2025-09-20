package mx.betweencode.customtoken.customtoken.autenticacion.modelos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String message;
}
