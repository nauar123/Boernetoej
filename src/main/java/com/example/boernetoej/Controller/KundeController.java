package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunder")
@CrossOrigin(origins = "*")

public class KundeController {

    @Autowired
    private  KundeService kundeService;

    // OPRET kunde
    @PostMapping("/opret")
    public Kunde opretKunde(@RequestBody Kunde kunde) {
        return kundeService.gemKunde(kunde);
    }

    // HENT alle kunder
    @GetMapping
    public List<Kunde> hentAlleKunder() {
        return kundeService.findAlle();
    }

    // HENT kunde via ID
    @GetMapping("/{id}")
    public Kunde hentKunde(@PathVariable int id) {
        return kundeService.findById(id).orElse(null);
    }

    // OPDATER kunde
    @PutMapping("/opdater/{id}")
    public Kunde opdaterKunde(@PathVariable int id, @RequestBody Kunde opdateret) {
        return kundeService.findById(id).map(k -> {
            k.setNavn(opdateret.getNavn());
            k.setEmail(opdateret.getEmail());
            k.setAdresse(opdateret.getAdresse());
            return kundeService.gemKunde(k);
        }).orElse(null);
    }

    // SLET kunde
    @DeleteMapping("/slet/{id}")
    public void sletKunde(@PathVariable int id) {
        kundeService.sletKunde(id);
    }
}
