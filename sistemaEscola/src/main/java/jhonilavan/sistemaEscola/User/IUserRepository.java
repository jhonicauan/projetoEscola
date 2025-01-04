package jhonilavan.sistemaEscola.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<modelUser,Long>{
    modelUser findByEnrollment(String enrollment);
}