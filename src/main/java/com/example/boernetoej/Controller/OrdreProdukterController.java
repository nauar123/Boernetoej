package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.OrdreProdukter;
import com.example.boernetoej.Repository.OrdreProdukterRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordreprodukter")
public class OrdreProdukterController {

    private final OrdreProdukterRepo ordreProdukterRepo;

    public OrdreProdukterController(OrdreProdukterRepo ordreProdukterRepo) {
        this.ordreProdukterRepo = ordreProdukterRepo;
    }

    // CREATE
    @PostMapping("/opret")
    public OrdreProdukter opretOrdreProdukt(@RequestBody OrdreProdukter ordreProdukt) {
        return ordreProdukterRepo.save(ordreProdukt);
    }

    // READ – alle
    @GetMapping
    public List<OrdreProdukter> hentAlle() {
        return ordreProdukterRepo.findAll();
    }

    // READ – én
    @GetMapping("/{id}")
    public OrdreProdukter hentEt(@PathVariable int id) {
        return ordreProdukterRepo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/opdater/{id}")
    public OrdreProdukter opdaterOrdreProdukt(@PathVariable int id, @RequestBody OrdreProdukter opdateret) {
        return ordreProdukterRepo.findById(id).map(op -> {
            op.setOrdre(opdateret.getOrdre());
            op.setProdukt(opdateret.getProdukt());
            op.setAntal(opdateret.getAntal());
            return ordreProdukterRepo.save(op);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/slet/{id}")
    public void sletOrdreProdukt(@PathVariable int id) {
        ordreProdukterRepo.deleteById(id);
    }
}
