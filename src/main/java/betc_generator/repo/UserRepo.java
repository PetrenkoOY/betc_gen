package betc_generator.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import betc_generator.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
