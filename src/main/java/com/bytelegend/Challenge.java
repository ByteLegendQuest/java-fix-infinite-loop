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

    public static boolean digitComparator(int a, int b, int c) {
        return a == b || a == c;
    }

    public static String generateRandomSecretNumber() {
        int firstDigit = randomNumberBetween(1, 9);
        int secondDigit = randomNumberBetween(0, 9);
        int thirdDigit = randomNumberBetween(0, 9);

        if (digitComparator(firstDigit, secondDigit, thirdDigit)) {
            do {
                firstDigit = randomNumberBetween(1, 9);
            }
            while (digitComparator(firstDigit, secondDigit, thirdDigit));
        }

        if (digitComparator(secondDigit, firstDigit, thirdDigit)) {
            do {
                secondDigit = randomNumberBetween(1, 9);
            }
            while (digitComparator(secondDigit, firstDigit, thirdDigit));
        }

        if (digitComparator(thirdDigit, firstDigit, secondDigit)) {
            do {
                thirdDigit = randomNumberBetween(1, 9);
            }
            while (digitComparator(thirdDigit, firstDigit, secondDigit));
        }
        return firstDigit + "" + secondDigit + "" + thirdDigit;
    }
}
