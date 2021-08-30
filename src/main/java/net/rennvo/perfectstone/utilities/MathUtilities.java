package net.rennvo.perfectstone.utilities;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author renNvo on 14:11, 30.08.2021
 */

public class MathUtilities {

    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static double random(double max) {
        return ThreadLocalRandom.current().nextDouble(max);
    }

}
