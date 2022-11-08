import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        readHandler.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Legends!");
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
                readHandler.printHeroes(Hero.heroType.WARRIOR);
            }
            else if(userChoice == 2)
            {
                chosenHero = "Paladin";
                readHandler.printHeroes(Hero.heroType.PALADIN);
            }
            else if(userChoice == 3)
            {
                chosenHero = "Sorcerer";
                readHandler.printHeroes(Hero.heroType.SORCERER);
            }

            System.out.println("Which " + chosenHero + " would you like?");
            int heroNum = scanner.nextInt();
            gameData.heroes.add(readHandler.getHero(chosenHero, heroNum));
        }

        // print hashmap of hero
        gameData.printAllHeroes();
        System.out.println(map.printMap());
    }
}