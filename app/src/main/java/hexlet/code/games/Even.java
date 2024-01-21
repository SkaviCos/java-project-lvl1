package hexlet.code.games;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.run;
import static hexlet.code.Utils.generateNumber;

public class Even {

    private static final int NUMBER_LIMIT = 100;
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String GAME_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static String[] generateRoundData() {
        var number = generateNumber(NUMBER_LIMIT);
        var questionAndCalcAnswer = new String[2];

        questionAndCalcAnswer[0] = String.valueOf(number);
        questionAndCalcAnswer[1] = isEven(questionAndCalcAnswer[0]) ? YES : NO;

        return questionAndCalcAnswer;
    }

    public static void evenGame() {
        var roundsData = new String[ROUNDS_COUNT][];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }
        run(GAME_RULE, roundsData);
    }

    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0;
    }

}
