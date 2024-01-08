package hexlet.code.games;

import static hexlet.code.Engine.startGame;
import static hexlet.code.Helper.generateNumber;

public class Even {

    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static String[] question = new String[3];
    public static String[] calcAnswer = new String[3];

    public static void evenGame() {

        for (int i = 0; i < 3; i++) {
            question[i] = String.valueOf(generateNumber(100));
            calcAnswer[i] = isEven(question[i]) ? YES : NO;
        }
        startGame(GAME_RULE, calcAnswer, question);
    }

    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0;
    }

}
