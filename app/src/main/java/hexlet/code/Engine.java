package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static String[] answer = new String[3];
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static String greeting() {

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void startGame(String gameRule, String[] calcAnswer, String[] question) {
        var userName = Engine.greeting();
        System.out.println(gameRule);
        for (int i = 0; i < 3; i++) {
            System.out.println("Question: " + question[i]);
            answer[i] = Engine.answer();

            if (calcAnswer[i].equalsIgnoreCase(answer[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer[i] + "' is wrong answer ;(. Correct answer was '"
                        + calcAnswer[i] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");

    }

    public static String question() {
        var question = "";
        System.out.print("Question: ");
        question += scanner.next();
        return question;
    }

    public static String answer() {
        System.out.print("Your answer: ");
        return scanner.next();
    }

}
