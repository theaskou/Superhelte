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
        Superhero wonderwoman = new Superhero("Wonderwoman", "Diana Prince", "Superhuman strength, flying", 1941, "Demi-godess", 10);

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

    // Metode til at søge efter en superhelt i databasen:
    // Virker ikke på tal
    // Skal håndtere søgninger der ikke giver resultater
    // Udskrivning skal gøres bedre, der kommer [ og , med.
    // Der må findes en simplere måde at kalde alle attributter i funktionen.

    // font colors
    final String BLACK_BOLD = "\033[1;30m";
    final String RESET = "\033[0m";
    public ArrayList<String> søgeFunktion (String søgeOrd) {

        ArrayList<String> søgning = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(søgeOrd.toLowerCase()) || superhero.getRealName().toLowerCase().contains(søgeOrd.toLowerCase()) || superhero.getIsHuman().toLowerCase().contains(søgeOrd.toLowerCase()) || superhero.getSuperPowers().toLowerCase().contains(søgeOrd.toLowerCase())) {

                if (!søgning.contains(superhero.getName()) || !søgning.contains(superhero.getRealName()) || !søgning.contains(superhero.getIsHuman()) || !søgning.contains(superhero.getSuperPowers())) {
                   søgning.add(BLACK_BOLD + "\nNavn: " + RESET + superhero.getName() + BLACK_BOLD + " Rigtigt navn: " + RESET + superhero.getRealName() + BLACK_BOLD + " Superkræfter: " + RESET + superhero.getSuperPowers() + BLACK_BOLD + " Oprindelsesår: " + RESET + superhero.getYearCreated() + BLACK_BOLD + " Race: " + RESET + superhero.getIsHuman() + BLACK_BOLD + " Styrke: " + RESET + superhero.getStrength() + "\n");
                }
            }
        }
            return søgning;

        }

        // Metode til at redigere i listerne:






    }



