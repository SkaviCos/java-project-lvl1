package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    public static void primeGame() {

        var userName = Engine.greeting();
        var count = 0;

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {
            var question = Engine.question();
            var answer = Engine.answer();
            var calcAnswer = isPrime(Integer.parseInt(question)) ? "yes" : "no";

            if (calcAnswer.equalsIgnoreCase(answer)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + calcAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i * i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}
