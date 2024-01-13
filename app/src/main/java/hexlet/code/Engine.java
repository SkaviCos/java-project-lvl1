package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ROUNDS_COUNT = 3;
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void startGame(String gameRule, String[][] questionAndCalcAnswer) {
        var userName = Cli.greeting();
        var answer = "";
        System.out.println(gameRule);
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println("Question: " + questionAndCalcAnswer[i][0]);
            answer = Engine.answer();

            if (questionAndCalcAnswer[i][1].equalsIgnoreCase(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndCalcAnswer[i][1] + "'.");
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
