/*package com.example.boernetoej;

import com.example.boernetoej.Model.Produkter;
import com.example.boernetoej.Repository.ProdukterRepo;
import com.example.boernetoej.Service.ProdukterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



// Testen kan finde ud af om findAll metoden virker
class ProdukterServiceTest {

    @Mock // det en fake version af ProdukterRepo. Vi tester nemlig kun service, vi vil ikke tilgå databasen
    private ProdukterRepo produkterRepo;

    @InjectMocks
//Mockito indsætter automatisk produkterRepo (mocked) ind i produkterService.
    private ProdukterService produkterService;

    public ProdukterServiceTest() {
        MockitoAnnotations.openMocks(this); //Uden dette vil @Mock og @InjectMocks ikke virke.
    }

    @Test
    void findAlle_returnererListeAfProdukter() {

        // Arrange
        // Der laver fake data til testen. det som repo normalt ville returnere til os
        Produkter p1 = new Produkter("T-shirt", "Blød", 199, "98", "img1.jpg");
        Produkter p2 = new Produkter("Bukser", "Sorte", 299, "104", "img2.jpg");

        // Når repo bliver kaldt, returner listen af produkter
        when(produkterRepo.findAll()).thenReturn(List.of(p1, p2));
        


        // Act
        //  Vi kalder den rigtige service-metode, som vi vil teste. kun service testes her
        List<Produkter> result = produkterService.findAlle();

        // Assert – der tjekkes at listen indeholder produkterne
        assertEquals(2, result.size()); // testen fejler, hvis listen ikke har 2 produkter.
        assertEquals("T-shirt", result.get(0).getTitel()); // tester første produkts titel
        assertEquals("Bukser", result.get(1).getTitel()); // tester andet produkts titel
    }
}
*/