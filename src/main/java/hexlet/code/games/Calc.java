package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {

    public static void calcGame() {
        var userName = Engine.greeting();
        var count = 0;

        System.out.println("What is the result of the expression?");
        for (int i = 0; i < 3; i++) {
            var question = Engine.question();
            var answer = Engine.answer();
            var calcAnswer = 0;

            if (question.contains("*")) {
                calcAnswer = Integer.parseInt(question.replace(" * ", " ").split(" ")[0])
                        * Integer.parseInt(question.replace(" * ", " ").split(" ")[1]);
                if (calcAnswer == Integer.parseInt(answer)) {
                    System.out.println("Correct!");
                    count++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + calcAnswer + "'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            }

            if (question.contains("+")) {
                calcAnswer = Integer.parseInt(question.replace(" + ", " ").split(" ")[0])
                        + Integer.parseInt(question.replace(" + ", " ").split(" ")[1]);
                if (calcAnswer == Integer.parseInt(answer)) {
                    System.out.println("Correct!");
                    count++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + calcAnswer + "'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            }

            if (question.contains("-")) {
                calcAnswer = Integer.parseInt(question.replace(" - ", " ").split(" ")[0])
                        - Integer.parseInt(question.replace(" - ", " ").split(" ")[1]);
                if (calcAnswer == Integer.parseInt(answer)) {
                    System.out.println("Correct!");
                    count++;
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + calcAnswer + "'.");
                    System.out.println("Let's try again, " + userName + "!");
                    break;
                }
            }

        }

        if (count == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

}
