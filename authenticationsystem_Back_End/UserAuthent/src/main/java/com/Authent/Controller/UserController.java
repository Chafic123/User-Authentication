package com.Authent.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Authent.Service.UserService;
import com.Authent.model.Userr;

@RestController
@RequestMapping(path= "/")
@CrossOrigin 
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Userr user) {
        try {
            userService.signUp(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Userr user) {
        boolean authenticated = userService.login(user.getEmail(), user.getPassword());

        if (authenticated) {
            Userr loggedInUser = userService.findByEmail(user.getEmail()); // Fetch the full user details
            return ResponseEntity.ok("Login successful! Welcome, " + loggedInUser.getFullName());
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

	
}
