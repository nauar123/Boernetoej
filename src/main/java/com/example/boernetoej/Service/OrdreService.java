package com.example.boernetoej.Service;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Model.Ordre;
import com.example.boernetoej.Repository.OrdreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdreService {

    @Autowired
    private  OrdreRepo ordreRepo;


    // Opret ordre
    public Ordre gemOrdre(Ordre ordre) {
        return ordreRepo.save(ordre);
    }

    // Find ordre via ID
    public Optional<Ordre> findById(int id) {
        return ordreRepo.findById(id);
    }

    // Find alle ordrer
    public List<Ordre> findAlle() {
        return ordreRepo.findAll();
    }

    // Find ordrer for en kunde
    public List<Ordre> findByKunde(Kunde kunde) {
        return ordreRepo.findByKunde(kunde);
    }

    // Slet ordre
    public void sletOrdre(int id) {
        ordreRepo.deleteById(id);
    }
}

