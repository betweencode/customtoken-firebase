package mx.betweencode.customtoken.customtoken.autenticacion;

import lombok.RequiredArgsConstructor;
import mx.betweencode.customtoken.customtoken.autenticacion.modelos.Error;
import mx.betweencode.customtoken.customtoken.autenticacion.modelos.RequestUser;
import mx.betweencode.customtoken.customtoken.autenticacion.modelos.ResponseLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public  class AutenticacionController {

    private final AutenticacionCoreService autenticacion;

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody RequestUser requestUser){
        Boolean isAutenticado = autenticacion.autenticar(requestUser.getUsername(), requestUser.getPassword());
        if(!isAutenticado){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Error.builder().message("Usuario incorrecto").build());
        }

        String token = autenticacion.autenticar(requestUser.getUsername());
        ResponseLogin responseLogin = new ResponseLogin();
        responseLogin.setTokenfirebase(token);


        return ResponseEntity.ok().body(responseLogin);
    }
}
