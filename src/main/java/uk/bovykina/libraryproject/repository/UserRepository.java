package uk.bovykina.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.bovykina.libraryproject.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
