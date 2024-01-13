package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Utils.generateNumber;

public class Even {

    public static final int ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 2;
    private static final int GENERATE_COUNT = 100;
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[][] QUESTION_AND_CALC_ANSWER = new String[ROWS_COUNT][COLUMNS_COUNT];

    public static void evenGame() {

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            QUESTION_AND_CALC_ANSWER[i][0] = String.valueOf(generateNumber(GENERATE_COUNT));
            QUESTION_AND_CALC_ANSWER[i][1] = isEven(QUESTION_AND_CALC_ANSWER[i][0]) ? YES : NO;
        }
        startGame(GAME_RULE, QUESTION_AND_CALC_ANSWER);
    }

    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0;
    }

}
