package com.dk.socialmediaclone.userservice.controllers;


import com.dk.socialmediaclone.userclientlibs.models.UserNotFoundException;
import com.dk.socialmediaclone.userservice.entity.User;
import com.dk.socialmediaclone.userservice.services.UserRepository;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable UUID id) {
    User user = userRepository
        .findById(id)
        .orElseThrow(() -> new UserNotFoundException("User id " + id + " is not found."));

    return user;
  }

  @PostMapping
  public void createUser(@Valid  @RequestBody User updatedUser) {
    userRepository.save(updatedUser);
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {
    User fetchUser = this.getUserById(id);
    fetchUser.setName(updatedUser.getName());
    userRepository.save(fetchUser);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable UUID id) {
    userRepository.deleteById(id);
  }

}
