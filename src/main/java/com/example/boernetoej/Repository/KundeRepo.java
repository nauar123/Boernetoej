package com.example.boernetoej.Repository;
import com.example.boernetoej.Model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepo extends JpaRepository<Kunde, Integer>
{
    Kunde findByEmail(String email);
}
