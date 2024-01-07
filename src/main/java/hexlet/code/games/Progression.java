package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {

    static int firstNumber;
    static int delta;

    public static void progressionGame() {

        var userName = Engine.greeting();
        var count = 0;

        System.out.println("Please enter the game number and press Enter.");

        for (int i = 0; i < 3; i++) {
            var progression = generate();
            var hiddenIndex = generateNumber(progression.length);
            var progressionQuestion = buildQuestion(progression, hiddenIndex);
            System.out.println("Question: " + progressionQuestion);

            var answer = Engine.answer();

            if (Integer.parseInt(answer) == progression[hiddenIndex]) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + progression[hiddenIndex] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static int generateNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
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
