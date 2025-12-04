package com.example.boernetoej.Model;

import jakarta.persistence.*;

@Entity
@Table(name="kunder")
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="kunde_id")
    private int kundeId;
    private String navn;
    private String email;
    private String adresse;

    public Kunde(){}

    public Kunde(int kundeId, String navn, String email, String adresse)
    {
        this.kundeId = kundeId;
        this.navn = navn;
        this.email = email;
        this.adresse = adresse;
    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }



}
