package jhonilavan.sistemaEscola.User;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    IUserRepository userRepository;

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody modelUser user){

        try{
            boolean checkEnrollment = userRepository.findByEnrollment(user.getEnrollment()) == null;
            if(!checkEnrollment){
                return ResponseEntity.badRequest().body("nome de usuario não esta disponivel.");
            }

            int passwordLength = user.getPassword().length();

            if(passwordLength < 8){
                return ResponseEntity.badRequest().body("A senha deve ter ao menos 8 digitos.");
            }
            String password = BCrypt.withDefaults().hashToString(12,user.getPassword().toCharArray());

            user.setPassword(password);

            userRepository.save(user);

            return ResponseEntity.accepted().body(user);
        }catch(Error e){
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

    @PostMapping("/login")
    public boolean checkLogin(@RequestBody Map<String,String> login){
        modelUser checkUser = userRepository.findByEnrollment(login.get("enrollment"));
        if(checkUser == null){
            return false;
        }
        var passwordLogin = login.get("password").toCharArray();
        var passwordCheck = checkUser.getPassword().toCharArray();
        return BCrypt.verifyer().verify(passwordLogin, passwordCheck).verified;
    }
}
