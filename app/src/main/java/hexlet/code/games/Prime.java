package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Prime {

    private static final int COUNT = 3;
    private static final int GENERATE_COUNT = 100;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String[] QUESTION = new String[COUNT];
    private static final String[] CALC_ANSWER = new String[COUNT];

    public static void primeGame() {

        for (int i = 0; i < COUNT; i++) {
            QUESTION[i] = String.valueOf(generateNumber(GENERATE_COUNT));
            CALC_ANSWER[i] = isPrime(Integer.parseInt(QUESTION[i])) ? "yes" : "no";
        }
        startGame(GAME_RULE, CALC_ANSWER, QUESTION);
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
