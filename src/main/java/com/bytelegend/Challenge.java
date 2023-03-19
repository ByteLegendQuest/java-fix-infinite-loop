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
        int r = randomNumberBetween(0, 1000);
        while (r < 100 || r > 999 || String.valueOf(r).chars().distinct().count() < 3) {
            r = randomNumberBetween(0, 1000);
        }
        return String.valueOf(r);
    }
}
