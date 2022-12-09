package pl.kawatojava.expences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kawatojava.expences.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
