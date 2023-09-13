public class Superhero {
    private String name;
    private String realName;
    private String superPowers;
    private int yearCreated;
    private String isHuman;
    private int strength;

    public Superhero(String name, String realName, String superPowers, int yearCreated, String isHuman, int strength) {
        this.name = name;
        this.realName = realName;
        this.superPowers = superPowers;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPowers() {
        return superPowers;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    // font colors
    final String BLACK_BOLD = "\033[1;30m";
    final String RESET = "\033[0m";

    @Override
    public String toString() {
        return "" +
                BLACK_BOLD + "Navn: " + RESET + name +
                BLACK_BOLD + " Rigtigt navn: " + RESET + realName +
                BLACK_BOLD + " Superkræfter: " + RESET + superPowers +
                BLACK_BOLD + " Oprindelsesår: " + RESET + yearCreated +
                BLACK_BOLD + " Race: " + RESET + isHuman +
                BLACK_BOLD + " Styrke: " + RESET + strength;
    }
}
