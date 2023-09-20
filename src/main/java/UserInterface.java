import java.util.Scanner;

public class UserInterface {

    public UserInterface () {

        /*opgave: "I UserInterface klassen skal du splitte koden, der opretter, udskriver superhelte og søger efter superhelte, ud i hver sin metode.
        Tilret hele programmet, så det stadig virker fuldstændig som i forrige delopgave.
        Du har nu redesignet/refaktoreret din kode uden at brugeren vil opleve nogen forskel, når programmet kører.
        Det vil sige at du har brugt tid på at øge den interne kodekvalitet, hvilket vil komme dig til gode i form af bedre overblik, når programmet vokser sig større (= en langsigtet investering).
        */


    }

    public void startProgram() {
        // Font colors
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String RESET = "\033[0m";
        final String BLACK_BOLD = "\033[1;30m";

        System.out.println(ANSI_PURPLE +"Velkommen til Superhelte databasen"+ RESET);

        Database superheroDatabase = new Database();

        String menuChoice;
        do {
            System.out.println("\n" +
                    "Tast 1 for at oprette en superhelt\n" +
                    "Tast 2 for at se databasen over superhelte\n" +
                    "Tast 3 for at søge i databasen\n" +
                    "Tast 4 for at redigere i databasen\n" +
                    "Tast 5 for at slette en superhelt\n" +
                    "Tast 9 for at afslutte");

            // Skriv menuen om til switch i stedet for if

            Scanner keyboard = new Scanner(System.in);
            menuChoice = keyboard.nextLine();

            // Menupunkt 1, opret superhelt:

            if (menuChoice.equals("1")) {
                System.out.print("\nIndtast superheltens helte-navn: ");
                String name = keyboard.next();

                String realNameOrNot = "";
                while (!realNameOrNot.equals("y") && !realNameOrNot.equals("n")) {
                    System.out.print("Har superhelten et borgerligt navn? [y/n] ");
                    realNameOrNot = keyboard.next();
                }
                String realName = "intet";
                if (realNameOrNot.equals("y")) {
                    System.out.print("Indtast superheltens borgerlige navn: ");
                    realName = keyboard.next();
                }

                System.out.print("Indtast superheltens superkræfter: ");
                String superPowers = keyboard.next();

                // Lav tjek på tal-input:
                System.out.print("Indtast året for superheltens skabelse: ");
                int yearCreated = keyboard.nextInt();

                System.out.print("Hvilken race er superhelten? (fx. menneske): ");
                String isHuman = keyboard.next();


                // Skal fixes - printer ikke "
                int strength = 0;
                do {
                    System.out.print("Indtast superheltens styrke på en skala fra 1-10: ");

                    // Input tjek
                    while (!keyboard.hasNextInt()) {
                        System.out.println(ANSI_RED + "Forkert indtastning. Styrken skal angives som et tal mellem 1 og 10. " + RESET);
                        keyboard.next();
                    }
                    strength = keyboard.nextInt();

                    if (strength < 1 || strength > 10) {
                        System.out.println(ANSI_RED + "Tallet er udenfor skalaen. " + RESET);
                    }
                } while (strength < 1 || strength > 10);


                System.out.println(ANSI_GREEN + "\nSuperhelten er tilføjet! \n" + ANSI_PURPLE + "Her er den opdaterede liste over superhelte i databasen: " + RESET);
                superheroDatabase.createSuperhero(name, realName, superPowers, yearCreated, isHuman, strength);
                superheroDatabase.seeAllSuperHeroes();

                // Menupunkt 2, udskriv databasen:

            } else if (menuChoice.equals("2")) {
                System.out.println(ANSI_PURPLE + "Liste over superhelte i databasen: " + RESET);
                superheroDatabase.seeAllSuperHeroes();

                // Menupunkt 3, søg i databasen

            } else if (menuChoice.equals("3")) {
                System.out.println("Indtast søgeord og tryk enter: ");

                System.out.println(ANSI_PURPLE + "Søgeresultat: " + RESET + superheroDatabase.søgeFunktion((keyboard.next())));

                // Menupunkt 4, rediger i databasen:

            } else if (menuChoice.equals("4")) {
                System.out.println("Søg efter superhelt: ");
                String superHeroToEdit = keyboard.nextLine();
                superheroDatabase.editSuperhero(superHeroToEdit, keyboard);

                // Menupunkt 5: slet en superhelt fra listen
                // Todo: Håndter input der er udenfor arraylistens størrelse

            } else if (menuChoice.equals("5")) {
                int indexToDelete;
                Superhero superheroToDelete;

                do {
                    System.out.println("Hvilken superhelt skal slettes? Vælg et nummer på listen: ");

                    int i = 1;

                    for (Superhero sh : superheroDatabase.superheroes) {
                        System.out.println(i++ + ". " +

                                BLACK_BOLD + "Navn: " + RESET + sh.getName() +
                                BLACK_BOLD + " Rigtigt navn: " + RESET + sh.getRealName() +
                                BLACK_BOLD + " Superkræfter: " + RESET + sh.getSuperPowers() +
                                BLACK_BOLD + " Oprindelsesår: " + RESET + sh.getYearCreated() +
                                BLACK_BOLD + " Race: " + RESET + sh.getIsHuman() +
                                BLACK_BOLD + " Styrke: " + RESET + sh.getStrength());
                    }

                    while (!keyboard.hasNextInt()) {
                        System.out.println(ANSI_RED + "Vælg et tal på listen: " + RESET);
                        keyboard.next();
                    }

                    indexToDelete = keyboard.nextInt() - 1;
                    superheroToDelete = superheroDatabase.superheroes.get(indexToDelete);
                    superheroDatabase.deleteSuperhero(indexToDelete);

                } while (indexToDelete >= 0 && indexToDelete < superheroDatabase.superheroes.size());

                System.out.println(ANSI_GREEN + superheroToDelete.getName() + " er slettet fra databasen." + RESET);

            }




            // Ugyldig indtastning, gentag menuen:

            if (!menuChoice.equals("9") && !menuChoice.equals("1") && !menuChoice.equals("2") && !menuChoice.equals("3") && !menuChoice.equals("4") && !menuChoice.equals("5")) {
                System.out.println(ANSI_RED + "Indtast et tal fra menuen: " + RESET);
            }

            // Afslut program

        } while(!menuChoice.equals("9"));
    }

}

