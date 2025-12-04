package com.example.boernetoej.Repository;
import com.example.boernetoej.Model.Ordre;
import com.example.boernetoej.Model.OrdreProdukter;
import com.example.boernetoej.Model.Produkter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdreProdukterRepo extends JpaRepository<OrdreProdukter, Integer> {
    // finder alle ordreprodukter for en ordre
    List<OrdreProdukter> findByOrdre(Ordre ordre);

    // finder alle ordreprodukter for et produkt
    List<OrdreProdukter> findByProdukter(Produkter produkt);
}