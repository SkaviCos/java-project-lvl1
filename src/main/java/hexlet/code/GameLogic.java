package hexlet.code;

import java.util.Scanner;

public class GameLogic {
    private static final String YES = "yes";
    private static final String NO = "no";
    static Scanner scanner = new Scanner(System.in);

    public static String greeting() {

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void evenGame() {
        var userName = greeting();
        var count = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            System.out.print("Question: ");
            int question = scanner.nextInt();
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {

                if (question % 2 == 0 && answer.equalsIgnoreCase("yes")
                        || question % 2 != 0 && answer.equalsIgnoreCase("no")) {
                    System.out.println("Correct!");
                    count++;
                } else if (question % 2 != 0 && answer.equalsIgnoreCase("yes")) {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                } else if (question % 2 == 0 && answer.equalsIgnoreCase("no")) {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }

            } else {
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

}
