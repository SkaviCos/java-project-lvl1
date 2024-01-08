package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;


public class GCD {

    private static final int COUNT = 3;
    private static final int GENERATE_COUNT = 100;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    private static final String[] QUESTION = new String[COUNT];
    private static final String[] CALC_ANSWER = new String[COUNT];

    public static void gcdGame() {

        for (int i = 0; i < COUNT; i++) {

            var firstNum = generateNumber(GENERATE_COUNT);
            var secondNum = generateNumber(GENERATE_COUNT);

            QUESTION[i] = (firstNum + " " + secondNum);
            CALC_ANSWER[i] = String.valueOf(gcdAlgorithm(firstNum, secondNum));

        }
        startGame(GAME_RULE, CALC_ANSWER, QUESTION);
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
