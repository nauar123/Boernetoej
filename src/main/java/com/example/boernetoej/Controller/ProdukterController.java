package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Produkter;
import com.example.boernetoej.Repository.ProdukterRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produkter")
public class ProdukterController {

    private final ProdukterRepo produkterRepo;

    public ProdukterController(ProdukterRepo produkterRepo) {
        this.produkterRepo = produkterRepo;
    }

    // opret produkt
    @PostMapping("/opret")
    public Produkter opretProdukt(@RequestBody Produkter produkt) {
        return produkterRepo.save(produkt);
    }

    // henter alle
    @GetMapping
    public List<Produkter> hentAlle() {
        return produkterRepo.findAll();
    }

    // henter én
    @GetMapping("/{id}")
    public Produkter hentEt(@PathVariable int id) {
        return produkterRepo.findById(id).orElse(null);
    }

    // søg på titel/profukt navn
    @GetMapping("/soeg")
    public List<Produkter> soeg(@RequestParam String titel) {
        return produkterRepo.findByTitelContaining(titel);
    }

    // updaterr
    @PutMapping("/opdater/{id}")
    public Produkter opdaterProdukt(@PathVariable int id, @RequestBody Produkter opdateret) {
        return produkterRepo.findById(id).map(p -> {
            p.setTitel(opdateret.getTitel());
            p.setBeskrivelse(opdateret.getBeskrivelse());
            p.setPris(opdateret.getPris());
            p.setStoerrelse(opdateret.getStoerrelse());
            p.setBilledeUrl(opdateret.getBilledeUrl());
            return produkterRepo.save(p);
        }).orElse(null);
    }

    // delete
    @DeleteMapping("/slet/{id}")
    public void sletProdukt(@PathVariable int id) {
        produkterRepo.deleteById(id);
    }
}
