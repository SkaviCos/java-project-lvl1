package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Calc {
    private static final String GAME_RULE = "What is the result of the expression?";
    public static String[] question = new String[3];
    public static String[] calcAnswer = new String[3];


    public static void calcGame() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < 3; i++) {
            int randomOperatorIndex = random.nextInt(operators.length);
            String operator = operators[randomOperatorIndex];
            var firstNum = generateNumber(10);
            var secondNum = generateNumber(10);
            question[i] = (firstNum + " " + operator + " " + secondNum);
            calcAnswer[i] = String.valueOf(resultOfOperation(operator, firstNum, secondNum));
        }
        startGame(GAME_RULE, calcAnswer, question);
    }

    private static int resultOfOperation(String operation, int firstNum, int secondNum) {
        return switch (operation) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> 0;
        };
    }

}
