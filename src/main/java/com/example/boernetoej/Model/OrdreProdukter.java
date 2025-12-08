package com.example.boernetoej.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "Ordreprodukter")
public class OrdreProdukter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordreprodukt_id")
    private int ordreProduktId;


    @ManyToOne
    @JoinColumn(name = "ordre_id")
    private Ordre ordre;


    @ManyToOne
    @JoinColumn(name = "produkt_id")
    private Produkter produkter;


    private int antal;


    // Standard constructor
    public OrdreProdukter() {}


    // Parametriseret constructor
    public OrdreProdukter(Ordre ordre, Produkter produkt, int antal) {
        this.ordre = ordre;
        this.produkter = produkt;
        this.antal = antal;
    }


    // Getters og Setters
    public int getOrdreProduktId() {
        return ordreProduktId;
    }


    public void setOrdreProduktId(int ordreProduktId) {
        this.ordreProduktId = ordreProduktId;
    }


    public Ordre getOrdre() {
        return ordre;
    }


    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }


    public Produkter getProdukt() {
        return produkter;
    }


    public void setProdukt(Produkter produkter) {
        this.produkter = produkter;
    }


    public int getAntal() {
        return antal;
    }


    public void setAntal(int antal) {
        this.antal = antal;
    }
}
