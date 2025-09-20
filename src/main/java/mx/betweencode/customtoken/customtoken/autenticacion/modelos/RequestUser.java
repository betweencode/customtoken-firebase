package mx.betweencode.customtoken.customtoken.autenticacion.modelos;


import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class RequestUser {
    private String username;
    private String password;
}
