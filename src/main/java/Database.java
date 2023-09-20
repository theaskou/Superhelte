import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Database {

    //Opret et justerbart array:
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public Database() {
        Superhero superman = new Superhero("Superman", "Ken Clark", "Flying, strength", 1938, "Not human", 10);
        Superhero batwoman = new Superhero("Batwoman", "Kathy Kane", "Martial arts and stealth", 1956, "Human", 9);
        Superhero batman = new Superhero("Batman", "Bruce Wayne", "Wealth, strength, strategist", 1939, "Human", 8);
        Superhero spiderman = new Superhero("Spiderman", "Peter Parker", "Spider-mutant powers", 1962, "Human mutant", 6);
        Superhero wonderwoman = new Superhero("Wonderwoman", "Diana Prince", "Superhuman strength, flying", 1941, "Demi-goddess", 10);
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
    // Skal håndtere søgninger der ikke giver resultater -
    // Udskrivning skal gøres bedre, der kommer [ og , med.
    // Der må findes en simplere måde at kalde alle attributter i funktionen.

    // font colors
    final String BLACK_BOLD = "\033[1;30m";
    final String RESET = "\033[0m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_PURPLE = "\u001B[35m";

    public ArrayList<Superhero> søgeFunktion(String søgeOrd) {
        ArrayList<Superhero> søgeresultat = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(søgeOrd.toLowerCase()) ||
                    superhero.getRealName().toLowerCase().contains(søgeOrd.toLowerCase())) {
                søgeresultat.add(superhero);
            }
        }
        return søgeresultat;
    }

    // Metode til at redigere i listerne:

    public void editSuperhero(String superhero, Scanner keyboard) {
        ArrayList<Superhero> resultsToEdit = søgeFunktion(superhero);
        Superhero superheroToEdit = null;

        if (resultsToEdit.size() == 0) {
            System.out.println(ANSI_RED + "Der findes ingen superhelte der opfylder søgekriterierne." + RESET);

        } else if (resultsToEdit.size() > 1) {
            System.out.println("Vælg superhelt: ");
            int i = 1;
            for (Superhero sh : resultsToEdit) {
                System.out.println(i++ + ". " +

                        BLACK_BOLD + "Navn: " + RESET + sh.getName() +
                        BLACK_BOLD + " Rigtigt navn: " + RESET + sh.getRealName() +
                        BLACK_BOLD + " Superkræfter: " + RESET + sh.getSuperPowers() +
                        BLACK_BOLD + " Oprindelsesår: " + RESET + sh.getYearCreated() +
                        BLACK_BOLD + " Race: " + RESET + sh.getIsHuman() +
                        BLACK_BOLD + " Styrke: " + RESET + sh.getStrength());
            }

            // indsæt try-catch for at håndtere forkert input
            int userChoice = keyboard.nextInt();
            keyboard.nextLine(); // Scanner bug
            superheroToEdit = resultsToEdit.get(userChoice - 1);

        } else {
            superheroToEdit = resultsToEdit.get(0);
        }

        if (superheroToEdit != null) {
            System.out.println(ANSI_PURPLE + "Redigér data og tryk ENTER. Hvis data ikke skal redigeres, tryk ENTER" + RESET);

            System.out.println("Navn: " + superheroToEdit.getName() + "\nIndtast nyt navn: ");
            String newName = keyboard.nextLine();
            if (!newName.isEmpty())
                superheroToEdit.setName(newName);

            System.out.println("Rigtigt navn: " + superheroToEdit.getRealName() + "\nIndtast nyt navn: ");
            String newRealName = keyboard.nextLine();
            if (!newRealName.isEmpty())
                superheroToEdit.setRealName(newRealName);

            System.out.println("Superkræfter: " + superheroToEdit.getSuperPowers() + "\nIndtast nye superkræfter: (OBS. gamle superkræfter bliver også overskrevet, hvis de ikke indtastes igen.) ");
            String newSuperPowers = keyboard.nextLine();
            if (!newSuperPowers.isEmpty())
                superheroToEdit.setSuperPowers(newSuperPowers);

            System.out.println("Oprindelsesår " + superheroToEdit.getYearCreated() + "\nIndtast nyt årstal: ");
            String newYearCreated = keyboard.nextLine();
            if (!newYearCreated.isEmpty()) {
                superheroToEdit.setYearCreated(Integer.parseInt(newYearCreated));
            }

            System.out.println("Race: " + superheroToEdit.getIsHuman() + "\nIndtast ny race: ");
            String newIsHuman = keyboard.nextLine();
            if (!newIsHuman.isEmpty())
                superheroToEdit.setIsHuman(newIsHuman);

            System.out.println("Styrke " + superheroToEdit.getStrength() + "\nIndtast opdateret styrke, på en skala fra 1-10: ");
            String newStrength = keyboard.nextLine();
            if (!newStrength.isEmpty()) {
                superheroToEdit.setStrength(Integer.parseInt(newStrength));
            }

            System.out.println(ANSI_GREEN + "Superhelten er nu opdateret:\n" + RESET + superheroToEdit);
        }
    }

    public void deleteSuperhero(int index) {


    }

}









