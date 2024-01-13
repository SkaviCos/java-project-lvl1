package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Calc {

    private static final int GENERATE_COUNT = 10;
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 2;
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String[][] generateRoundData(int i) {
        int randomOperatorIndex = generateNumber(OPERATORS.length);
        String operator = OPERATORS[randomOperatorIndex];
        var firstNum = generateNumber(GENERATE_COUNT);
        var secondNum = generateNumber(GENERATE_COUNT);
        QUESTION_AND_CALC_ANSWER[i][0] = (firstNum + " " + operator + " " + secondNum);
        QUESTION_AND_CALC_ANSWER[i][1] = String.valueOf(resultOfOperation(operator, firstNum, secondNum));

        return QUESTION_AND_CALC_ANSWER;
    }

    public static void calcGame() {

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            generateRoundData(i);
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
