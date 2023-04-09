package com.travelin.travelinchat.services;

import com.mongodb.MongoException;
import com.travelin.travelinchat.entities.User;
import com.travelin.travelinchat.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@Log4j2
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(final String id) {
        return userRepository.findById(id).orElseThrow(() -> {
            final String message = String.format("User : %s not found!", id);

            log.info(message);
            return new MongoException(121, message);
        });
    }

    public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            final String message = String.format("User : %s not found!", email);

            log.info(message);
            return new MongoException(121, message);
        });
    }

    public User createUser(final User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            final String message = String.format("User : %s duplicate email!", user.getEmail());
            log.warn(message);
            throw  new MongoException(11000, message);
        }
        return userRepository.save(user);
    }

    public String deleteUserById(final String id) {
        userRepository.deleteById(id);
        log.info(String.format("Deleted user with ID %s", id));
        return id;
    }

    public String deleteUserByEmail(final String email) {
        userRepository.deleteByEmail(email);
        log.info(String.format("Delete user by email : %s", email));
        return email;
    }
}
