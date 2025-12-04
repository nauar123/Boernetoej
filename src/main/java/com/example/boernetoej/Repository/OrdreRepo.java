package com.example.boernetoej.Repository;
import com.example.boernetoej.Model.Kunde;
import com.example.boernetoej.Model.Ordre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdreRepo extends JpaRepository<Ordre, Integer> {
    // finder alle ordrer for en kunde
    List<Ordre> findByKunde(Kunde kunde);
}
