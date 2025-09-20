package mx.betweencode.customtoken.customtoken.autenticacion;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionCoreService {

    public Boolean autenticar(String username, String password){
        return username.equals("admin") && password.equals("12345");
    }


    public String autenticar(String username){
        FirebaseApp.initializeApp();
        String uid = username;
        try {
            String customToken = FirebaseAuth.getInstance().createCustomToken(uid);
            return customToken;
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }

    }



}
