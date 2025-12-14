package com.example.boernetoej.Service;

import com.example.boernetoej.Model.Ordre;
import com.example.boernetoej.Model.OrdreProdukter;
import com.example.boernetoej.Model.Produkter;
import com.example.boernetoej.Repository.OrdreProdukterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreProdukterService {

@Autowired
    private OrdreProdukterRepo ordreProdukterRepo;

    public OrdreProdukterService(OrdreProdukterRepo ordreProdukterRepo) {
        this.ordreProdukterRepo = ordreProdukterRepo;
    }

    // Gem ordreprodukt
    public OrdreProdukter gem(OrdreProdukter ordreProdukt) {
        return ordreProdukterRepo.save(ordreProdukt);
    }

    // Find via ID
    public Optional<OrdreProdukter> findById(int id) {
        return ordreProdukterRepo.findById(id);
    }

    // Find alle produkter i en ordre
    public List<OrdreProdukter> findByOrdre(Ordre ordre) {
        return ordreProdukterRepo.findByOrdre(ordre);
    }

    // Find alle ordrer der indeholder et produkt
    public List<OrdreProdukter> findByProdukt(Produkter produkt) {
        return ordreProdukterRepo.findByProdukter(produkt);
    }

    // Slet
    public void slet(int id) {
        ordreProdukterRepo.deleteById(id);
    }

    public List<OrdreProdukter> findAlle() {
        return ordreProdukterRepo.findAll();
    }

}
