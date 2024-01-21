package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Progression {

    private static final int COUNT = 3;
    private static final int ORIGIN = 5;
    private static final int NUMBER_LIMIT = 11;
    private static final String GAME_RULE = "What number is missing in the progression?";
    private static final Random RANDOM = new Random();

    private static String[] generateRoundData() {
        int length = RANDOM.nextInt(ORIGIN, NUMBER_LIMIT);

        int firstNumber = generateNumber(NUMBER_LIMIT);
        int delta = generateNumber(COUNT) + 1;
        var questionAndCalcAnswer = new String[2];
        var hiddenIndex = generateNumber(length);

        var progression = generateProgression(length, firstNumber, delta);
        var elementForAnswer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        var progressionQuestion = String.join(" ", progression);

        questionAndCalcAnswer[0] = progressionQuestion;
        questionAndCalcAnswer[1] = String.valueOf(elementForAnswer);

        return questionAndCalcAnswer;
    }

    public static void progressionGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_RULE, roundsData);
    }

    private static String[] generateProgression(int length, int firstNumber, int delta) {
        var progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(firstNumber + i * delta);
        }
        return progression;
    }

}
