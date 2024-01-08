package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Calc {

    private static final int COUNT = 3;
    private static final int GENERATE_COUNT = 10;
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] QUESTION = new String[COUNT];
    private static final String[] CALC_ANSWER = new String[COUNT];

    public static void calcGame() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < COUNT; i++) {
            int randomOperatorIndex = random.nextInt(operators.length);
            String operator = operators[randomOperatorIndex];
            var firstNum = generateNumber(GENERATE_COUNT);
            var secondNum = generateNumber(GENERATE_COUNT);
            QUESTION[i] = (firstNum + " " + operator + " " + secondNum);
            CALC_ANSWER[i] = String.valueOf(resultOfOperation(operator, firstNum, secondNum));
        }
        startGame(GAME_RULE, CALC_ANSWER, QUESTION);
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
