package hexlet.code;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();
    public static int generateNumber(int n) {
        return RANDOM.nextInt(n);
    }

}
