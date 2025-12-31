

package com.example.boernetoej.Model;


import jakarta.persistence.*;


@Entity
@Table(name = "Produkter")
public class Produkter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produkt_id")
    private int produktId;
    private String titel;
    private String beskrivelse;
    private double pris;
    private String stoerrelse;


    @Column(name = "billede_url")
    private String billedeUrl;

    //risiko for broken browser med billedeUrl,

// id det primærnøgle
    // generer fra primærnøglerne


    public Produkter() {}
//

    public Produkter(String titel,String beskrivelse, double pris, String stoerrelse, String billedeUrl) {
        this.titel = titel;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.stoerrelse = stoerrelse;
        this.billedeUrl = billedeUrl;
    }


    public int getProduktId() {
        return produktId;
    }


    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }


    public String getTitel() {
        return titel;
    }


    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeskrivelse()
    {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse)
    {
        this.beskrivelse = beskrivelse;
    }

    public double getPris() {
        return pris;
    }


    public void setPris(double pris) {
        this.pris = pris;
    }


    public String getStoerrelse() {
        return stoerrelse;
    }


    public void setStoerrelse(String stoerrelse) {
        this.stoerrelse = stoerrelse;
    }


    public String getBilledeUrl() {
        return billedeUrl;
    }


    public void setBilledeUrl(String billedeUrl) {
        this.billedeUrl = billedeUrl;
    }
}
