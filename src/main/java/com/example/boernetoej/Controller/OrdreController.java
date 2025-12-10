package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Model.Ordre;
import com.example.boernetoej.Repository.OrdreRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordrer")
public class OrdreController {

    private final OrdreRepo ordreRepo;

    public OrdreController(OrdreRepo ordreRepo) {
        this.ordreRepo = ordreRepo;
    }

    // Opret ordre
    @PostMapping("/opret")
    public Ordre opretOrdre(@RequestBody Ordre ordre) {
        return ordreRepo.save(ordre);
    }

    //henter alle
    @GetMapping
    public List<Ordre> hentAlle() {
        return ordreRepo.findAll();
    }

    // Henter én
    @GetMapping("/{id}")
    public Ordre hentEn(@PathVariable int id) {
        return ordreRepo.findById(id).orElse(null);
    }

    // Finder alle ordrer for en bestemt kunde
    @GetMapping("/kunde/{kundeId}")
    public List<Ordre> hentOrdrerForKunde(@PathVariable int kundeId) {
        Kunde kunde = new Kunde();
        kunde.setKundeId(kundeId);
        return ordreRepo.findByKunde(kunde);
    }

    // update
    @PutMapping("/opdater/{id}")
    public Ordre opdaterOrdre(@PathVariable int id, @RequestBody Ordre opdateret) {
        return ordreRepo.findById(id).map(o -> {
            o.setKunde(opdateret.getKunde());
            o.setOrdreDato(opdateret.getOrdreDato());
            o.setTotalPris(opdateret.getTotalPris());
            return ordreRepo.save(o);
        }).orElse(null);
    }

    // delete
    @DeleteMapping("/slet/{id}")
    public void sletOrdre(@PathVariable int id) {
        ordreRepo.deleteById(id);
    }
}
