package com.gustavo.parkingcontrolapi.controller;

import com.gustavo.parkingcontrolapi.DTO.AuthenticationDTO;
import com.gustavo.parkingcontrolapi.DTO.UserModelDto;
import com.gustavo.parkingcontrolapi.configs.TokenService;
import com.gustavo.parkingcontrolapi.model.UserModel;
import com.gustavo.parkingcontrolapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<UserModel>> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.getOneUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Optional<UserModel>> getOneUserByName(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getOneUserByName(username));
    }
    @PostMapping("/register")
    public ResponseEntity<Optional<UserModel>> createUser(@RequestBody @Valid UserModelDto userModelDto) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userModelDto, userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(Optional.ofNullable(userService.createUser(userModel)));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(@RequestBody @Valid UserModelDto userModelDto) {
       var usernamePassword = new UsernamePasswordAuthenticationToken(userModelDto.username(), userModelDto.password());
       var auth = this.authenticationManager.authenticate(usernamePassword);

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Optional<UserModel> userModel = userService.getOneUserByName(userDetails.getUsername());
        if(userModel.isPresent()) {
            String token = tokenService.generateToken(userModel.get());
            return ResponseEntity.ok(new AuthenticationDTO(token));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
