package com.revature.gymapp.api.controller;

import com.revature.gymapp.api.dto.UserDto;
import com.revature.gymapp.api.dto.security.AuthenticationRequest;
import com.revature.gymapp.api.dto.security.RegistrationRequest;
import com.revature.gymapp.api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody RegistrationRequest registrationRequest){
        return userService.registerUser(registrationRequest);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody AuthenticationRequest authenticationRequest){
        return userService.login(authenticationRequest);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping
    public List<UserDto> findAllUsers(){
        return userService.findAllUsers();
    }

    @PatchMapping("/{id}")
    public UserDto updateUserById(@RequestBody UserDto userDto, @PathVariable Long id){
        return userService.updateUserById(userDto, id);
    }
}
