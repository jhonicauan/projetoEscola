package jhonilavan.sistemaEscola.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_user")
@Data
public class userModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    private String name;
    private String password;
    private String username;
}
