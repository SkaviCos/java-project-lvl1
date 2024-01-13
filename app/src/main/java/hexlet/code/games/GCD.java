package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;


public class GCD {

    private static final int GENERATE_COUNT = 100;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    public static final int ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 2;
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];

    public static void gcdGame() {

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            var firstNum = generateNumber(GENERATE_COUNT);
            var secondNum = generateNumber(GENERATE_COUNT);

            QUESTION_AND_CALC_ANSWER[i][0] = (firstNum + " " + secondNum);
            QUESTION_AND_CALC_ANSWER[i][1] = String.valueOf(gcdAlgorithm(firstNum, secondNum));

        }
        startGame(GAME_RULE, QUESTION_AND_CALC_ANSWER);
    }

    private static int gcdAlgorithm(int first, int second) {
        while (first != second) {
            if (first > second) {
                first = first - second;
            } else {
                second = second - first;
            }
        }
        return first;
    }

}
