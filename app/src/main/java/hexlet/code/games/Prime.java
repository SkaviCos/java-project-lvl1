package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Prime {

    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];
    private static final int GENERATE_COUNT = 100;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";


    public static String[][] generateRoundData(int i) {
        QUESTION_AND_CALC_ANSWER[i][0] = String.valueOf(generateNumber(GENERATE_COUNT));
        QUESTION_AND_CALC_ANSWER[i][1] = isPrime(Integer.parseInt(QUESTION_AND_CALC_ANSWER[i][0])) ? "yes" : "no";

        return QUESTION_AND_CALC_ANSWER;
    }

    public static void primeGame() {

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            generateRoundData(i);
        }
        startGame(GAME_RULE, QUESTION_AND_CALC_ANSWER);
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
