package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Model.Ordre;
import com.example.boernetoej.Service.OrdreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordrer")
@CrossOrigin(origins = "*")
public class OrdreController {

    @Autowired

    private OrdreService ordreService;

    // OPRET ordre
    @PostMapping("/opret")
    public Ordre opretOrdre(@RequestBody Ordre ordre) {
        return ordreService.gemOrdre(ordre);
    }

    // HENT alle ordrer
    @GetMapping
    public List<Ordre> hentAlle() {
        return ordreService.findAlle();
    }

    // HENT én ordre
    @GetMapping("/{id}")
    public Ordre hentEn(@PathVariable int id) {
        return ordreService.findById(id).orElse(null);
    }

    // HENT ordrer for en bestemt kunde
    @GetMapping("/kunde/{kundeId}")
    public List<Ordre> hentOrdrerForKunde(@PathVariable int kundeId) {
        Kunde kunde = new Kunde();
        kunde.setKundeId(kundeId);
        return ordreService.findByKunde(kunde);
    }

    // OPDATER ordre
    @PutMapping("/opdater/{id}")
    public Ordre opdaterOrdre(@PathVariable int id, @RequestBody Ordre opdateret) {
        return ordreService.findById(id).map(o -> {
            o.setKunde(opdateret.getKunde());
            o.setOrdreDato(opdateret.getOrdreDato());
            o.setTotalPris(opdateret.getTotalPris());
            return ordreService.gemOrdre(o);
        }).orElse(null);
    }

    // SLET ordre
    @DeleteMapping("/slet/{id}")
    public void sletOrdre(@PathVariable int id) {
        ordreService.sletOrdre(id);
    }
}
