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
        int firstDigit = randomNumberBetween(1, 9);
        int secondDigit = randomNumberBetween(0, 9);
        int thirdDigit = randomNumberBetween(0, 9);

        boolean firstDigitIsSameAsSecondOrThird = (firstDigit == secondDigit) || (firstDigit == thirdDigit);

        if (firstDigitIsSameAsSecondOrThird) {
            do {
                firstDigit = randomNumberBetween(1, 9);
                firstDigitIsSameAsSecondOrThird = (firstDigit == secondDigit) || (firstDigit == thirdDigit);
            } while (firstDigitIsSameAsSecondOrThird);
        }

        boolean secondDigitIsSameAsThird = secondDigit == thirdDigit;
        if (secondDigitIsSameAsThird) {
            do {
                secondDigit = randomNumberBetween(0, 9);
                secondDigitIsSameAsThird = secondDigit == thirdDigit;
            } while (secondDigitIsSameAsThird);
        }

        return firstDigit + "" + secondDigit + "" + thirdDigit;
    }
}
