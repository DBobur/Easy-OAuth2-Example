package org.example.easyoauth2example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @GetMapping("/")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}
