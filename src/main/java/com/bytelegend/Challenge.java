package com.bytelegend;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Challenge {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(generateRandomSecretNumber());
        }
    }

    /**
     * `generateRandomSecretNumber()` method returns a random integer, and none of the digits of the
     * number are the same.
     */
    public static String generateRandomSecretNumber() {
        return "123";
    }
}
