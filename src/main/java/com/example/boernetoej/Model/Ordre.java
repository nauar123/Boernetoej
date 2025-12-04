package com.example.boernetoej.Model;


import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
@Table(name="ordrer")
public class Ordre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name="kunde_id")
    private Kunde kunde;

    @Column(name = "ordre_id")
    private int ordreId;
    @Column(name="ordre_dato")
    private LocalDate ordreDato;
    @Column (name="total_pris")
    private Double totalPris;

    public int getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public LocalDate getOrdreDato() {
        return ordreDato;
    }

    public void setOrdreDato(LocalDate ordreDato) {
        this.ordreDato = ordreDato;
    }

    public double getTotalPris() {
        return totalPris;
    }

    public void setTotalPris(Double totalPris) {
        this.totalPris = totalPris;
    }
}



