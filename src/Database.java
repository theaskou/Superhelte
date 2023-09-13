import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    //Opret et justerbart array:
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public Database() {
        Superhero superman = new Superhero("Superman", "Ken Clark", "Flying, strength", 1938, "Not human", 10);
        Superhero batwoman = new Superhero("Batwoman", "Kathy Kane", "Martial arts and stealth", 1956, "Human", 9);
        Superhero batman = new Superhero("Batman", "Bruce Wayne", "Wealth, strength, strategist", 1939, "Human", 8);
        Superhero spiderman = new Superhero("Spiderman", "Peter Parker", "Spider-mutant powers", 1962, "Human mutant", 6);
        Superhero wonderwoman = new Superhero("Wonderwoman", "Diana Prince", "Superhuman strength, flight", 1941, "Demi-godess", 10);

        // Tilføj superheltene til listen:
        superheroes.addAll(Arrays.asList(superman, batwoman, batman, spiderman, wonderwoman));
    }

    // Metode til at tilføje superhelte fra brugerindtastning:

    public void createSuperhero(String name, String realName, String superPowers, int yearCreated, String isHuman, int strength) {
        superheroes.add(new Superhero(name, realName, superPowers, yearCreated, isHuman, strength));
    }

    // Metode til at udskrive databasen:
    public void seeAllSuperHeroes() {
        for (Superhero fullList : superheroes) {
            System.out.println(fullList);
        }
    }

}

