package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Prime {

    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String[] question = new String[3];
    public static String[] calcAnswer = new String[3];

    public static void primeGame() {

        for (int i = 0; i < 3; i++) {
            question[i] = String.valueOf(generateNumber(100));
            calcAnswer[i] = isPrime(Integer.parseInt(question[i])) ? "yes" : "no";
        }
        startGame(GAME_RULE, calcAnswer, question);
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
