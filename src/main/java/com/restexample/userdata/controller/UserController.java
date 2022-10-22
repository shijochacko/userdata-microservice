package com.restexample.userdata.controller;

import com.restexample.userdata.model.User;
import com.restexample.userdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@RestController
@RequestMapping("/api")
public class UserController {


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private final UserService userService;

    @PostMapping(path = "/create-user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createTutorial(@RequestBody @Valid User user) {

        try {
            List<User> userList =  this.userService.save(user);
            if(isEmpty(userList)){
                return new ResponseEntity<>(String.format("User with id %s exist", user.getId()), HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(userList);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{id}")
    private ResponseEntity getUser(@PathVariable("id") long userId)
    {
        List<User> userList = this.userService.getUser(userId);
        return  isEmpty(userList) ?
                ResponseEntity.notFound().build() : ResponseEntity.ok(userList) ;
    }



}
