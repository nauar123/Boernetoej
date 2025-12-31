package com.example.boernetoej.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Fortæller Spring, at denne klasse indeholder konfiguration og beans, som Spring skal styre
public class SecurityConfig {

    @Bean //fortæller Spring at metoden returnerer et objekt, som Spring skal styre

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //Spring opretter et objekt ( SecurityFilterChain) og styrer det som en bean.
        // "SecurityFilterChain" objektet, som definerer alle sikkerhedsregler for HTTP-requests.
        //spring Security objekt, som vi konfigurerer med regler.
        //nødvendigt, fordi nogle metoder i HttpSecurity kan kaste exceptions.


        http
                .csrf(csrf -> csrf.disable())
                //Standard i Spring Security er, at CSRF-beskyttelse er slået til for POST/PUT/DELETE. for at beskytte mod hacker
                // det er dog en simpel opgave vi har lavet og vi har ikke ment den var nødvendig.
                //auth = et alias for objektet, hvor du tilføjer regler

                .authorizeHttpRequests(auth -> auth
                        //Metoden bruges til at definere regler for adgang til forskellige URL’er
                        //

                        // OFFENTLIG WEBSHOP
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/**/*.html",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/produkter/**",
                                "/kunder/opret"
                        ).permitAll() // alle mÅ tilgå dem

                        //  KUN LOGGET-IN BRUGER
                        .requestMatchers(
                                "/profil",
                                "/ordre/**",
                                "/ordreprodukter/**"
                        ).hasRole("USER")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login.html")
                        .permitAll()
                )

                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
