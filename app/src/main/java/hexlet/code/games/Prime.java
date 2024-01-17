package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Prime {

    private static final int NUMBER_LIMIT = 100;
    private static final String GAME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";


    public static String[] generateRoundData() {
        var questionAndCalcAnswer = new String[2];

        questionAndCalcAnswer[0] = String.valueOf(generateNumber(NUMBER_LIMIT));
        questionAndCalcAnswer[1] = isPrime(Integer.parseInt(questionAndCalcAnswer[0])) ? "yes" : "no";

        return questionAndCalcAnswer;
    }

    public static void primeGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }
        startGame(GAME_RULE, roundsData);
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
