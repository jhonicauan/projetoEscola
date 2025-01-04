package jhonilavan.sistemaEscola.User;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jhonilavan.sistemaEscola.schoolClasses.modelClasses;
import lombok.Data;

@Entity(name = "tb_user")
@Data
public class modelUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    private String name;
    private String password;
    @Column(unique = true)
    private String enrollment;
    private int userType;

    @ManyToMany
    @JoinTable(name = "user_classes", joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_class"))
    Set<modelClasses> classes = new HashSet<>();
}
