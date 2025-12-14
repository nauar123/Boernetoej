package com.example.boernetoej.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/profil")
    public String profil() {
        return "Du er logget ind!";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "Alle må se denne side";
    }
}
