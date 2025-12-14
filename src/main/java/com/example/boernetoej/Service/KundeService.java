package com.example.boernetoej.Service;

import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class KundeService {

        @Autowired
     private   KundeRepo kundeRepo;

        // Opret eller opdater kunde
        public Kunde gemKunde(Kunde kunde) {
            return kundeRepo.save(kunde);
        }

        // Find kunde via ID
        public Optional<Kunde> findById(int id) {
            return kundeRepo.findById(id);
        }

        // Find kunde via email
        public Kunde findByEmail(String email) {
            return kundeRepo.findByEmail(email);
        }

        // Hent alle kunder
        public List<Kunde> findAlle() {
            return kundeRepo.findAll();
        }

        // Slet kunde
        public void sletKunde(int id) {
            kundeRepo.deleteById(id);
        }
    }



