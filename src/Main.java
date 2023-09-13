import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Font colors
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String RESET = "\033[0m";

        System.out.println(ANSI_PURPLE + "Velkommen til Superhelte databasen" + RESET);

        Database superheroDatabase = new Database();

        String menuChoice;
        do {
            System.out.println("\n" +
                    "Tast 1 for at oprette en superhelt\n" +
                    "Tast 2 for at se databasen over superhelte\n" +
                    "Tast 9 for at afslutte");

            Scanner keyboard = new Scanner(System.in);
            menuChoice = keyboard.next();

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

            } else if (menuChoice.equals("2")) {
                System.out.println(ANSI_PURPLE + "Liste over superhelte i databasen: " + RESET);
                superheroDatabase.seeAllSuperHeroes();
            }

            if (!menuChoice.equals("9") && !menuChoice.equals("1") && !menuChoice.equals("2")) {
                System.out.println(ANSI_RED + "Indtast et tal fra menuen: " + RESET);
            }
        } while (!menuChoice.equals("9"));

    }

}