package com.example.boernetoej.Repository;

import com.example.boernetoej.Model.Produkter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdukterRepo extends JpaRepository<Produkter, Integer> {
    // Find produkter med titler der indeholder søgeord
    List<Produkter> findByTitelContaining(String titel);
}