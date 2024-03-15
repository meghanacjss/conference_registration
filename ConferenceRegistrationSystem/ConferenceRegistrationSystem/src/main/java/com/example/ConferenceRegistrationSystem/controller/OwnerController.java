package com.example.ConferenceRegistrationSystem.controller;
import com.example.ConferenceRegistrationSystem.entity.Owner;
import com.example.ConferenceRegistrationSystem.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

//@PreAuthorize("hasRole('ROLE_USER')")
//@PreAuthorize("hasRole('USER')")
//@PreAuthorize("hasRole('ROLE_ADMIN')")


public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<Owner> registerOwner(@Valid @RequestBody Owner owner) {
        Owner registeredOwner = ownerService.registerOwner(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredOwner);
    }
    @PostMapping("/login")
    public ResponseEntity<Owner> loginOwner(@RequestParam String username, @RequestParam String password) {
        Owner loggedInOwner = ownerService.login(username, password);
        if (loggedInOwner != null) {
            return ResponseEntity.ok(loggedInOwner);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
