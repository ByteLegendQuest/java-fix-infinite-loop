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

        boolean firstDigitIsSameAsSecondOrThird =
                (firstDigit == secondDigit) || (firstDigit == thirdDigit);
        boolean secondDigitIsSameAsFirstOrThird =
                (secondDigit == firstDigit) || (secondDigit == thirdDigit);
        boolean thirdDigitIsSameAsFirstOrSecond =
                (thirdDigit == firstDigit) || (thirdDigit == secondDigit);

        if (firstDigitIsSameAsSecondOrThird) {
            do {
                firstDigit = randomNumberBetween(1, 9);
                firstDigitIsSameAsSecondOrThird =
                        (firstDigit == secondDigit) || (firstDigit == thirdDigit);
            } while (firstDigitIsSameAsSecondOrThird);
        }

        if (secondDigitIsSameAsFirstOrThird) {
            do {
                secondDigit = randomNumberBetween(0, 9);
                secondDigitIsSameAsFirstOrThird =
                        (secondDigit == firstDigit) || (secondDigit == thirdDigit);;
            } while (secondDigitIsSameAsFirstOrThird);
        }

        if (thirdDigitIsSameAsFirstOrSecond) {
            do {
                thirdDigit = randomNumberBetween(0, 9);
                thirdDigitIsSameAsFirstOrSecond =
                        (thirdDigit == firstDigit) || (thirdDigit == secondDigit);
            } while (thirdDigitIsSameAsFirstOrSecond);
        }

        return firstDigit + "" + secondDigit + "" + thirdDigit;
    }
}
