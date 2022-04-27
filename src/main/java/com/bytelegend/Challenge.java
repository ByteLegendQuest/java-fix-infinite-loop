package com.bytelegend;

import java.util.concurrent.ThreadLocalRandom;

public class Challenge {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(generateRandomSecretNumber());
        }
    }

    private static int randomNumberBetween(int startInclusive, int endInclusive) {
        return ThreadLocalRandom.current().nextInt(startInclusive, endInclusive + 1);
    }

    /**
     * `generateRandomSecretNumber()` method returns a random integer, and none of the digits of the
     * number are the same.
     */
    public static String generateRandomSecretNumber() {
        int[] result = new int[]{randomNumberBetween(1, 9), randomNumberBetween(0, 9), randomNumberBetween(0, 9)};
        deduplication(result);
        return result[0] + "" + result[1] + "" + result[2];
    }

    private static void deduplication(int[] ints) {
        if (ints[0] == ints[1]) {
            ints[1] = randomNumberBetween(0, 9);
            deduplication(ints);
        } else if (ints[0] == ints[2] || ints[1] == ints[2]) {
            ints[2] = randomNumberBetween(0, 9);
            deduplication(ints);
        }
    }
}
