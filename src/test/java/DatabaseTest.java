import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
    }

    @Test
    void createSuperhero() {
        int startSize = db.superheroes.size();
        db.createSuperhero("Dronning", "Margrethe", "statsoverhoved, kæderygning", 1804, "Human", 9);
        int expectedSize = startSize + 1;
        int actualSize = db.superheroes.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void seeAllSuperHeroes() {

    }

    @Test
    void søgeFunktion() {
        Superhero actual = db.søgeFunktion("superman").get(0);
        Superhero expected = new Superhero("Superman", "Ken Clark", "Flying, strength", 1938, "Not human", 10);

        assertEquals(actual.getName(), expected.getName());
        // TODO: assetEquals for hvert felt i Superhero klassen
    }

    @Test
    void editSuperhero() {


    }



    @Test
    void deleteSuperhero() {
        // Gem start size
        int startArraySize = db.superheroes.size();
        int testIndex = 0;
        // Gem superhelt på bestemt indeks i en variabel
        Superhero heroToDelete = db.superheroes.get(testIndex);
        // Kør delete metode med et bestemt indeks
        db.deleteSuperhero(testIndex);

        // Tjek om superhelt (gemt i variabel) på det givne indeks er fjernet
        assertNotEquals(heroToDelete.getName(), db.superheroes.get(testIndex).getName());
        // Tjek om array er blevet 1 kortere efter deletion
        int expectedSize = startArraySize -1;
        int actualSize = db.superheroes.size();

        assertEquals(expectedSize, actualSize);
    }
}