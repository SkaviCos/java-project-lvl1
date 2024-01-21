package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;


public class GCD {

    private static final int NUMBER_LIMIT = 100;
    private static final String GAME_RULE = "Find the greatest common divisor of given numbers.";

    private static String[] generateRoundData() {
        var questionAndCalcAnswer = new String[2];
        var firstNum = generateNumber(NUMBER_LIMIT);
        var secondNum = generateNumber(NUMBER_LIMIT);

        questionAndCalcAnswer[0] = (firstNum + " " + secondNum);
        questionAndCalcAnswer[1] = String.valueOf(calculateGcd(firstNum, secondNum));

        return questionAndCalcAnswer;
    }

    public static void gcdGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            roundsData[i] = generateRoundData();

        }
        run(GAME_RULE, roundsData);
    }

    private static int calculateGcd(int first, int second) {
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
