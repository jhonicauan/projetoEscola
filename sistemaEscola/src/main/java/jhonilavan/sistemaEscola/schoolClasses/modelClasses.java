package jhonilavan.sistemaEscola.schoolClasses;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jhonilavan.sistemaEscola.User.modelUser;
import lombok.Data;

@Entity(name = "tb_class")
@Data
public class modelClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_class;
    private String className;

    @ManyToMany(mappedBy = "classes")
    Set<modelUser> users = new HashSet<>();
}
