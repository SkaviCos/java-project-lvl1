package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Calc {

    private static final int GENERATE_COUNT = 10;
    private static final String GAME_RULE = "What is the result of the expression?";
    public static final int ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 2;
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];

    public static void calcGame() {
        Random random = new Random();
        String[] operators = {"+", "-", "*"};

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomOperatorIndex = random.nextInt(operators.length);
            String operator = operators[randomOperatorIndex];
            var firstNum = generateNumber(GENERATE_COUNT);
            var secondNum = generateNumber(GENERATE_COUNT);
            QUESTION_AND_CALC_ANSWER[i][0] = (firstNum + " " + operator + " " + secondNum);
            QUESTION_AND_CALC_ANSWER[i][1] = String.valueOf(resultOfOperation(operator, firstNum, secondNum));
        }
        startGame(GAME_RULE, QUESTION_AND_CALC_ANSWER);
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
