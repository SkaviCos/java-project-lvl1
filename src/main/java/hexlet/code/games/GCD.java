package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;


public class GCD {

    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";
    public static String[] question = new String[3];
    public static String[] calcAnswer = new String[3];

    public static void gcdGame() {

        for (int i = 0; i < 3; i++) {

            var firstNum = generateNumber(100);
            var secondNum = generateNumber(100);

            question[i] = (firstNum + " " + secondNum);
            calcAnswer[i] = String.valueOf(gcdAlgorithm(firstNum, secondNum));

        }

        startGame(GAME_RULE, calcAnswer, question);
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
