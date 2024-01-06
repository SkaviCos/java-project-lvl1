package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        String numberGame = scanner.next();

        if (numberGame.equals("1")) {
            GameLogic.greeting();
        } else if (numberGame.equals("2")) {
            GameLogic.evenGame();
        } else {
            scanner.close();
        }

        scanner.close();
    }
}
