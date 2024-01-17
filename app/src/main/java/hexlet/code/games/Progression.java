package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Progression {

    private static final int COUNT = 3;
    private static final int ORIGIN = 5;
    private static final int NUMBER_LIMIT = 11;
    private static final String GAME_RULE = "What number is missing in the progression?";
    static Random random = new Random();
    private static int[] progression;

    private static String[] generateRoundData() {

        int length = random.nextInt(ORIGIN, NUMBER_LIMIT);
        progression = new int[length];

        int firstNumber = generateNumber(NUMBER_LIMIT);
        int delta = generateNumber(COUNT) + 1;
        var questionAndCalcAnswer = new String[2];

        var hiddenIndex = generateNumber(length);
        var progressionQuestion = buildQuestion(length, firstNumber, delta, hiddenIndex);

        questionAndCalcAnswer[0] = progressionQuestion;
        questionAndCalcAnswer[1] = String.valueOf(progression[hiddenIndex]);

        return questionAndCalcAnswer;
    }

    public static void progressionGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }
        startGame(GAME_RULE, roundsData);
    }

    private static String buildQuestion(int length, int firstNumber, int delta, int hiddenIndex) {

        for (int i = 0; i < length; i++) {
            progression[i] = firstNumber + i * delta;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            builder.append(i == hiddenIndex ? ".." : firstNumber + i * delta);
            if (i != progression.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

}
