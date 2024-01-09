package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in).useDelimiter("\n");

    public static String greeting() {

        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String userName = SCANNER.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

}
