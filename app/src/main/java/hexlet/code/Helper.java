package hexlet.code;

import java.util.Random;

public class Helper {

    public static int generateNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

}
