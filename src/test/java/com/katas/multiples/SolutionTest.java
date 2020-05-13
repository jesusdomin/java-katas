package com.katas.multiples;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class SolutionTest {

    @Test
    public void shouldReturnZeroWhenNumberIsZero() {
        assertEquals(0, new Solution().solution(0));
    }

    @Test
    public void shouldReturnZeroWhenNumberIsNotDivisibleByThreeOrFive() {
        assertEquals(0, new Solution().solution(1));
    }

    @ParameterizedTest
    @MethodSource("numbersProvider")
    public void testSolution(int number, int expectedSolution) {
        assertEquals(expectedSolution, new Solution().solution(number));
    }

    static Stream<Arguments> numbersProvider() {
        return Stream.of(
                arguments(10, 23),
                arguments(20, 78),
                arguments(200, 9168)
        );
    }
}