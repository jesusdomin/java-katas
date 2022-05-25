package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PositionTest {
    @Test
    void shouldEnsureInitialPositionIsZeroZero() throws PositionOutOfLimitsException {
        var position = new Position();

        assertEquals("0:0", position.value());
    }

    @ParameterizedTest
    @MethodSource("movementsAndExpectedPositionsProvider")
    void shouldIncreaseXValueWhenMoveToNorth(String direction, String expectedPosition) throws PositionOutOfLimitsException {
        var position = new Position(5, 5);

        var newPosition = position.move(direction);

        assertEquals(expectedPosition, newPosition.value());
    }

    @ParameterizedTest
    @MethodSource("movementsOutOfLimitProvider")
    void shouldDetectPositionsOutOfLimit(Integer x, Integer y, String direction) throws PositionOutOfLimitsException {
        var position = new Position(x, y);
        assertThrows(PositionOutOfLimitsException.class, () -> position.move(direction));
    }

    static Stream<Arguments> movementsAndExpectedPositionsProvider() {
        return Stream.of(
                arguments("N", "6:5"),
                arguments("S", "4:5"),
                arguments("E", "5:6"),
                arguments("W", "5:4")
        );
    }

    static Stream<Arguments> movementsOutOfLimitProvider() {
        return Stream.of(
                arguments(0, 0, "S"),
                arguments(0, 0, "W"),
                arguments(9, 0, "N"),
                arguments(9, 0, "W"),
                arguments(0, 9, "E"),
                arguments(0, 9, "S"),
                arguments(9, 9, "N"),
                arguments(9, 9, "E")
        );
    }
}