package com.example.boernetoej.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // ✅ OFFENTLIG WEBSHOP
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/**/*.html",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/produkter/**",
                                "/kunder/opret"
                        ).permitAll()

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
