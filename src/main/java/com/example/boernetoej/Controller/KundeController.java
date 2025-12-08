package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Repository.KundeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunder")
public class KundeController {

    private final KundeRepo kundeRepo;

    public KundeController(KundeRepo kundeRepo) {
        this.kundeRepo = kundeRepo;
    }


    @PostMapping("/opret")
    public Kunde opretKunde(@RequestBody Kunde kunde) {
        return kundeRepo.save(kunde);
    }


    @GetMapping
    public List<Kunde> hentAlleKunder() {
        return kundeRepo.findAll();
    }


    @GetMapping("/{id}")
    public Kunde hentKunde(@PathVariable int id) {
        return kundeRepo.findById(id).orElse(null);
    }


    @PutMapping("/opdater/{id}")
    public Kunde opdaterKunde(@PathVariable int id, @RequestBody Kunde opdateret) {
        return kundeRepo.findById(id).map(k -> {
            k.setNavn(opdateret.getNavn());
            k.setEmail(opdateret.getEmail());
            k.setAdresse(opdateret.getAdresse());
            return kundeRepo.save(k);
        }).orElse(null);
    }


    @DeleteMapping("/slet/{id}")
    public void sletKunde(@PathVariable int id) {
        kundeRepo.deleteById(id);
    }
}
