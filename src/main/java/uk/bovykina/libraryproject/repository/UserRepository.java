package uk.bovykina.libraryproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.bovykina.libraryproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
