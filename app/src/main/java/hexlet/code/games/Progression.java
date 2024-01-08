package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Progression {

    private static final String GAME_RULE = "What number is missing in the progression?";
    public static String[] question = new String[3];
    public static String[] calcAnswer = new String[3];
    static int firstNumber;
    static int delta;

    public static void progressionGame() {

        for (int i = 0; i < 3; i++) {
            var progression = generate();
            var hiddenIndex = generateNumber(progression.length);
            var progressionQuestion = buildQuestion(progression, hiddenIndex);

            question[i] = progressionQuestion;
            calcAnswer[i] = String.valueOf(progression[hiddenIndex]);

        }
        startGame(GAME_RULE, calcAnswer, question);
    }

    private static int[] generate() {
        Random random = new Random();
        int length = random.nextInt(5, 11);
        int[] progression = new int[length];
        firstNumber = generateNumber(11);
        delta = generateNumber(3) + 1;
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
