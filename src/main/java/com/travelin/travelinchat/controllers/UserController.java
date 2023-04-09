package com.travelin.travelinchat.controllers;

import com.travelin.travelinchat.entities.User;
import com.travelin.travelinchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@RestController
@RequestMapping("/chat/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUserById(@RequestParam(name = "id", required = false) final Optional<String> id,
                            @RequestParam(name = "email", required = false) final Optional<String> email) {

        if (id.isPresent()) {
            return new ResponseEntity<>(userService.getUserById(id.get()), HttpStatus.OK);
        }

        if (email.isPresent()) {
            return new ResponseEntity<>(userService.getUserByEmail(email.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody final User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
}
