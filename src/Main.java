import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Usage under: https://en.wikipedia.org/wiki/MIT_License
Developer: Abhinav (github.com/abhinavmir)
 */

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        readHandler.init();
        logger.setLevel(Level.ALL);
        Scanner scanner = new Scanner(System.in);
        System.out.println("  <=======]}======\n" +
                "    --.   /|\n" +
                "   _\\\"/_.'/\n" +
                " .'._._,.'\n" +
                " :/ \\{}/\n" +
                "(L  /--',----._\n" +
                "    |          \\\\\n" +
                "   : /-\\ .'-'\\ / |\n" +
                "snd \\\\, ||    \\|\n" +
                "     \\/ ||    ||");
        System.out.println("Welcome to Legends: Monsters and Heroes");
        System.out.println("Enter size of map:");
        int size = scanner.nextInt();
        System.out.println("How many heroes?");
        int heroes = scanner.nextInt();
        Map map = new Map(heroes, size, size);

        for (int i = 0;i<heroes;i++)
        {
            System.out.println("Which type of hero would you like?");
            System.out.println("1. Warrior \t 2. Paladin \t 3. Sorcerer");
            int userChoice = scanner.nextInt();
            String chosenHero = null;
            if(userChoice == 1)
            {
                chosenHero = "Warrior";
                readHandler.printHeroes(Characters.Hero.heroType.WARRIOR);
            }
            else if(userChoice == 2)
            {
                chosenHero = "Paladin";
                readHandler.printHeroes(Characters.Hero.heroType.PALADIN);
            }
            else if(userChoice == 3)
            {
                chosenHero = "Sorcerer";
                readHandler.printHeroes(Characters.Hero.heroType.SORCERER);
            }

            System.out.println("Which " + chosenHero + " would you like?");
            int heroNum = scanner.nextInt();
            Characters.Hero chosenHeroObj = readHandler.getHero(chosenHero, heroNum);
            chosenHeroObj.printHero();
            //gameData.heroes.add(readHandler.getHero(chosenHero, heroNum));
        }

        System.out.println("Your team:");
        for (Characters.Hero hero : gameData.heroes) {
            hero.printHero();
        }
        System.out.println(map.printMap());
    }
}