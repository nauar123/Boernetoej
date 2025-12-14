package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Produkter;
import com.example.boernetoej.Service.ProdukterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produkter")
public class ProdukterController {

@Autowired
    private ProdukterService produkterService;


    // OPRET produkt
    @PostMapping("/opret")
    public Produkter opretProdukt(@RequestBody Produkter produkt) {
        return produkterService.gemProdukt(produkt);
    }

    // HENT alle produkter
    @GetMapping
    public List<Produkter> hentAlle() {
        return produkterService.findAlle();
    }

    // HENT ét produkt
    @GetMapping("/{id}")
    public Produkter hentEt(@PathVariable int id) {
        return produkterService.findById(id).orElse(null);
    }

    // SØG på titel / produktnavn
    @GetMapping("/soeg")
    public List<Produkter> soeg(@RequestParam String titel) {
        return produkterService.søgPåTitel(titel);
    }

    // OPDATER produkt
    @PutMapping("/opdater/{id}")
    public Produkter opdaterProdukt(
            @PathVariable int id,
            @RequestBody Produkter opdateret) {

        return produkterService.findById(id).map(p -> {
            p.setTitel(opdateret.getTitel());
            p.setBeskrivelse(opdateret.getBeskrivelse());
            p.setPris(opdateret.getPris());
            p.setStoerrelse(opdateret.getStoerrelse());
            p.setBilledeUrl(opdateret.getBilledeUrl());
            return produkterService.gemProdukt(p);
        }).orElse(null);
    }

    // SLET produkt
    @DeleteMapping("/slet/{id}")
    public void sletProdukt(@PathVariable int id) {
        produkterService.sletProdukt(id);
    }
}
