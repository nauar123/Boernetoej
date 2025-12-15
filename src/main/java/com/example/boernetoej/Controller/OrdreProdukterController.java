package com.example.boernetoej.Controller;

import com.example.boernetoej.Model.OrdreProdukter;
import com.example.boernetoej.Service.OrdreProdukterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordreprodukter")
@CrossOrigin(origins = "*")
public class OrdreProdukterController {

    @Autowired
    private OrdreProdukterService ordreProdukterService;



    // CREATE
    @PostMapping("/opret")
    public OrdreProdukter opretOrdreProdukt(@RequestBody OrdreProdukter ordreProdukt) {
        return ordreProdukterService.gem(ordreProdukt);
    }

    // READ – alle
    @GetMapping
    public List<OrdreProdukter> hentAlle() {
        return ordreProdukterService.findAlle();
    }

    // READ – én
    @GetMapping("/{id}")
    public OrdreProdukter hentEt(@PathVariable int id) {
        return ordreProdukterService.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/opdater/{id}")
    public OrdreProdukter opdaterOrdreProdukt(
            @PathVariable int id,
            @RequestBody OrdreProdukter opdateret) {

        return ordreProdukterService.findById(id).map(op -> {
            op.setOrdre(opdateret.getOrdre());
            op.setProdukt(opdateret.getProdukt());
            op.setAntal(opdateret.getAntal());
            return ordreProdukterService.gem(op);
        }).orElse(null);
    }

    // DELETE
    @DeleteMapping("/slet/{id}")
    public void sletOrdreProdukt(@PathVariable int id) {
        ordreProdukterService.slet(id);
    }
}
