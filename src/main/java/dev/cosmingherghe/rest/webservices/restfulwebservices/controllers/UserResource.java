package dev.cosmingherghe.rest.webservices.restfulwebservices.controllers;

import dev.cosmingherghe.rest.webservices.restfulwebservices.exception.DateOfBirthNotFoundException;
import dev.cosmingherghe.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import dev.cosmingherghe.rest.webservices.restfulwebservices.services.UserDaoService;
import dev.cosmingherghe.rest.webservices.restfulwebservices.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {

        User user = userDaoService.findUserById(id);

        if(user == null) throw new UserNotFoundException("id : " + id);

        return userDaoService.findUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {

        User savedUser = userDaoService.save(user);

        if(savedUser.getBirthDate() == null) throw new DateOfBirthNotFoundException();

        //Created
        // /user/{id}   savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {

        User user = userDaoService.findUserById(id);
        if(user == null) throw new UserNotFoundException("id : " + id);

        userDaoService.deleteUserById(id);

        //Created response
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.noContent().build();
    }
}