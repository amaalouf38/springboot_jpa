package springbootjpa.springbootjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootjpa.springbootjpa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
