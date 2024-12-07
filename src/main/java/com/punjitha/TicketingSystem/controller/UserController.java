package com.punjitha.TicketingSystem.controller;

import com.punjitha.TicketingSystem.model.User;
import com.punjitha.TicketingSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable("id") Long id) {
        User user = userService.FindUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.DeleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
