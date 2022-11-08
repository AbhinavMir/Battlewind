import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Legends!");

        System.out.println("Enter size of map:");
        int size = scanner.nextInt();

        System.out.println("How many heroes?");
        int heroes = scanner.nextInt();
        Map map = new Map(heroes, size, size);
        int userChoice;

        for (int i = 0;i<heroes;i++)
        {
            Hero hero = new Hero("Hero", 1, 0, 100, 10);
            gameData.addHero(hero);
        }

        // print hashmap of hero
        gameData.printAllHeroes();
        System.out.println(map.printMap());
    }
}