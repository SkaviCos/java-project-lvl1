package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {

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

    public static void gcdGame() {
        var userName = Engine.greeting();
        var count = 0;

        System.out.println("Find the greatest common divisor of given numbers.");
        for (int i = 0; i < 3; i++) {
            var question = Engine.question();
            var answer = Engine.answer();

            var first = Integer.parseInt(question.split(" ")[0]);
            var second = Integer.parseInt(question.split(" ")[1]);

            var calcAnswer = gcdAlgorithm(first, second);

            if (calcAnswer == Integer.parseInt(answer)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + calcAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }

        }
        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }


}
