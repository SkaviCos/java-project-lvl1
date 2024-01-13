package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Progression {

    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final int COUNT = 3;
    private static final int ORIGIN = 5;
    private static final int GENERATE_COUNT = 11;
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];
    private static int firstNumber;
    private static int delta;

    public static String[][] generateRoundData(int i) {
        var progression = generate();
        var hiddenIndex = generateNumber(progression.length);
        var progressionQuestion = buildQuestion(progression, hiddenIndex);

        QUESTION_AND_CALC_ANSWER[i][0] = progressionQuestion;
        QUESTION_AND_CALC_ANSWER[i][1] = String.valueOf(progression[hiddenIndex]);

        return QUESTION_AND_CALC_ANSWER;
    }

    public static void progressionGame() {

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            generateRoundData(i);
        }
        startGame(GAME_RULE, QUESTION_AND_CALC_ANSWER);
    }

    private static int[] generate() {
        Random random = new Random();
        int length = random.nextInt(ORIGIN, GENERATE_COUNT);
        int[] progression = new int[length];
        firstNumber = generateNumber(GENERATE_COUNT);
        delta = generateNumber(COUNT) + 1;
        for (int i = 0; i < length; i++) {
            progression[i] = firstNumber + i * delta;
        }
        return progression;
    }

    private static String buildQuestion(int[] progression, int hiddenIndex) {

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
