package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final int COUNT = 3;
    private static final String[] ANSWER = new String[COUNT];
    private static final Scanner SCANNER = new Scanner(System.in).useDelimiter("\n");

    public static void startGame(String gameRule, String[] calcAnswer, String[] question) {
        var userName = Cli.greeting();
        System.out.println(gameRule);
        for (int i = 0; i < COUNT; i++) {
            System.out.println("Question: " + question[i]);
            ANSWER[i] = Engine.answer();

            if (calcAnswer[i].equalsIgnoreCase(ANSWER[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + ANSWER[i] + "' is wrong answer ;(. Correct answer was '"
                        + calcAnswer[i] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");

    }

    private static String answer() {
        System.out.print("Your answer: ");
        return SCANNER.next();
    }

}
