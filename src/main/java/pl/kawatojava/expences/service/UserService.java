package pl.kawatojava.expences.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kawatojava.expences.model.User;
import pl.kawatojava.expences.repository.UserRepository;

import java.util.Date;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void addUser(User user) {
        user.setCreateDate(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean isUserEmailAddressExists(String emailAddress) {
        return userRepository.existsByEmailAddress(emailAddress);
    }

    public void changePassword(String password, String emailAddress) {
        String encodedPassword = passwordEncoder().encode(password);
        userRepository.updateUserPasswordByEmailAddress(encodedPassword, emailAddress);
    }

    public void deleteUser(String emailAddress) {
        userRepository.deleteByEmailAddress(emailAddress);
    }
}
