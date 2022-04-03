package com.bytelegend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChallengeTest {
    @Test
    public void test() {
        Assertions.assertTimeoutPreemptively(
                Duration.ofSeconds(2),
                () -> {
                    List<String> secretNumbers =
                            IntStream.range(0, 100)
                                    .mapToObj(i -> Challenge.generateRandomSecretNumber())
                                    .distinct()
                                    .collect(Collectors.toList());
                    secretNumbers.forEach(
                            s -> {
                                int number = Integer.parseInt(s);
                                Assertions.assertTrue(100 <= number && number <= 999);
                                Assertions.assertEquals(3, s.chars().distinct().count());
                            });
                });
    }
}
