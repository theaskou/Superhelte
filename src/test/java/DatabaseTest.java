import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    Database db = new Database();
    ArrayList<Superhero> superheroes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Superhero superman = new Superhero("Superman", "Ken Clark", "Flying, strength", 1938, "Not human", 10);
        Superhero batwoman = new Superhero("Batwoman", "Kathy Kane", "Martial arts and stealth", 1956, "Human", 9);
        Superhero batman = new Superhero("Batman", "Bruce Wayne", "Wealth, strength, strategist", 1939, "Human", 8);
        Superhero spiderman = new Superhero("Spiderman", "Peter Parker", "Spider-mutant powers", 1962, "Human mutant", 6);
        Superhero wonderwoman = new Superhero("Wonderwoman", "Diana Prince", "Superhuman strength, flying", 1941, "Demi-godess", 10);
        superheroes.addAll(Arrays.asList(superman, batwoman, batman, spiderman, wonderwoman));
    }

    @Test
    void createSuperhero() {
        int startSize = superheroes.size();
        db.createSuperhero("Dronning", "Margrethe", "statsoverhoved, kæderygning", 1804, "Human", 9);
        int expectedSize = startSize ++;
        int actualSize = superheroes.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void seeAllSuperHeroes() {

    }

    @Test
    void søgeFunktion() {
    }

    @Test
    void editSuperhero() {
    }
}