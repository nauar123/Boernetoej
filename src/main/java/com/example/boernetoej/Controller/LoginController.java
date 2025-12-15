package com.example.boernetoej.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @GetMapping("/profil")
    public String profil() {
        return "Du er logget ind!";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "Alle må se denne side"; // FInd ud af hvad den returnerer, og se om den kan gøre på en anden måde.
    }
}
