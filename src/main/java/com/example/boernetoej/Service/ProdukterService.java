package com.example.boernetoej.Service;

import com.example.boernetoej.Model.Produkter;
import com.example.boernetoej.Repository.ProdukterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdukterService {

 @Autowired
 private ProdukterRepo produkterRepo;


    // Opret eller opdater produkt
    public Produkter gemProdukt(Produkter produkt) {
        return produkterRepo.save(produkt);
    }

    // Find produkt via ID
    public Optional<Produkter> findById(int id) {
        return produkterRepo.findById(id);
    }

    // Find alle produkter
    public List<Produkter> findAlle() {
        return produkterRepo.findAll();
    }

    // Søg produkter på titel
    public List<Produkter> søgPåTitel(String titel) {
        return produkterRepo.findByTitelContaining(titel);
    }

    // Slet produkt
    public void sletProdukt(int id) {
        produkterRepo.deleteById(id);
    }
}

