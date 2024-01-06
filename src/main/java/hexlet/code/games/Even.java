package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    private static final String YES = "yes";
    private static final String NO = "no";

    public static void evenGame() {
        var userName = Engine.greeting();
        var count = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (int i = 0; i < 3; i++) {
            var question = Engine.question();
            var answer = Engine.answer();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {

                if (Integer.parseInt(question) % 2 == 0 && answer.equalsIgnoreCase("yes")
                        || Integer.parseInt(question) % 2 != 0 && answer.equalsIgnoreCase("no")) {
                    System.out.println("Correct!");
                    count++;
                } else if (Integer.parseInt(question) % 2 != 0 && answer.equalsIgnoreCase("yes")) {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                } else if (Integer.parseInt(question) % 2 == 0 && answer.equalsIgnoreCase("no")) {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }

            } else {
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

}
