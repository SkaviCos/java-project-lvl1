package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Even {

    private static final int COUNT = 3;
    private static final int GENERATE_COUNT = 100;
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[] QUESTION = new String[COUNT];
    private static final String[] CALC_ANSWER = new String[COUNT];

    public static void evenGame() {

        for (int i = 0; i < COUNT; i++) {
            QUESTION[i] = String.valueOf(generateNumber(GENERATE_COUNT));
            CALC_ANSWER[i] = isEven(QUESTION[i]) ? YES : NO;
        }
        startGame(GAME_RULE, CALC_ANSWER, QUESTION);
    }

    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0;
    }

}
