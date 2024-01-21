package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Calc {

    private static final int NUMBER_LIMIT = 10;
    private static final String GAME_RULE = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String[] generateRoundData() {
        var questionAndCalcAnswer = new String[2];

        int randomOperatorIndex = generateNumber(OPERATORS.length);
        String operator = OPERATORS[randomOperatorIndex];
        var firstNum = generateNumber(NUMBER_LIMIT);
        var secondNum = generateNumber(NUMBER_LIMIT);
        questionAndCalcAnswer[0] = (firstNum + " " + operator + " " + secondNum);
        questionAndCalcAnswer[1] = String.valueOf(calculateResult(operator, firstNum, secondNum));

        return questionAndCalcAnswer;
    }

    public static void calcGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_RULE, roundsData);
    }

    private static int calculateResult(String operation, int firstNum, int secondNum) {
        return switch (operation) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            default -> throw new RuntimeException("Unknown operator");
        };
    }

}
