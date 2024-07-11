package com.kahindi.briskspringdemo.user_mngmt;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"api/users"})
@Tag(name = "User Management")
public class UserEntityController {

    private final UserEntityService service;


    @GetMapping
    @Operation(summary = "get user")
    public ResponseEntity<UserDetails> getUserByUsername(String username) {

        UserDetails userDetails = service.loadUserByUsername(username);

        return ResponseEntity.ok(userDetails);
    }

    @PostMapping
    @Operation(summary = "create user")
    @PreAuthorize("hasAuthority()")
    public ResponseEntity<Void> createUser(String username, String password) {

        service.createUser(UserEntity.builder().username(username).password(password).build());
        return ResponseEntity.ok().build();
    }



}
