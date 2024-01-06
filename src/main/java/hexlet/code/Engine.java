package hexlet.code;

import java.util.Scanner;

public class Engine {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static String greeting() {

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
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
