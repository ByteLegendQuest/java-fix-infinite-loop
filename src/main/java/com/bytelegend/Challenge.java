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
        String digits = "0123456789";
        long num = 0;
        for (int i = 0; i < 3; i++) {
            int d = (int) (Math.random() * digits.length());
            // make certain first digit is not a 0.
            // otherwise, number will only have `ndigits - 1` digits.
            if (d == 0 && i == 0) {
                i--;
                continue;
            }
            // convert character to an int and "append" to the num.
            num = num * 10 + digits.charAt(d) - '0';

            // effectively delete the just used digit from the string.
            digits = digits.substring(0, d) + digits.substring(d + 1);
        }
        return Long.toString(num);
    }
}
