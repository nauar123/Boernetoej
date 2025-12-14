package com.example.boernetoej.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String role; // ROLE_USER eller ROLE_ADMIN

    @OneToOne
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;

    public User() {
    }

    public User(String username, String password, String role, Kunde kunde) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.kunde = kunde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}


