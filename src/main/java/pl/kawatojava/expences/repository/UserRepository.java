package pl.kawatojava.expences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kawatojava.expences.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAddress(String emailAddress);

    @Modifying
    @Query("UPDATE User u SET u.password = ?1 WHERE u.emailAddress = ?2")
    void updateUserPasswordByEmailAddress(String encodedPassword, String emailAddress);

    @Modifying
    @Query("DELETE User u WHERE u.emailAddress = ?1")
    void deleteByEmailAddress(String emailAddress);
}
