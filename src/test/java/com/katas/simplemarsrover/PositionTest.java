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
    void shouldEnsureInitialPositionIsZeroZero() {
        var position = new Position();

        assertEquals("0:0", position.value());
    }

    @ParameterizedTest
    @MethodSource("movementsAndExpectedPositionsProvider")
    void shouldIncreaseXValueWhenMoveToNorth(Direction direction, String expectedPosition) {
        var position = new Position(5, 5);

        var newPosition = position.move(direction);

        assertEquals(expectedPosition, newPosition.value());
    }

    @ParameterizedTest
    @MethodSource("movementsOutOfLimitProvider")
    void shouldWrapAroundIfLimitIsReached(Integer x, Integer y, Direction direction, String expectedPositionOutput) {
        var position = new Position(x, y);

        assertEquals(expectedPositionOutput, position.move(direction).value());
    }

    static Stream<Arguments> movementsAndExpectedPositionsProvider() {
        return Stream.of(
                arguments(Direction.toNorth(), "5:6"),
                arguments(Direction.toSouth(), "5:4"),
                arguments(Direction.toEast(), "6:5"),
                arguments(Direction.toWest(), "4:5")
        );
    }

    static Stream<Arguments> movementsOutOfLimitProvider() {
        return Stream.of(
                arguments(0, 0, Direction.toSouth(), "0:9"),
                arguments(0, 0, Direction.toWest(), "9:0"),
                arguments(0, 9, Direction.toNorth(), "0:0"),
                arguments(0, 9, Direction.toWest(), "9:9"),
                arguments(9, 0, Direction.toEast(), "0:0"),
                arguments(9, 0, Direction.toSouth(), "9:9"),
                arguments(9, 9, Direction.toNorth(), "9:0"),
                arguments(9, 9, Direction.toEast(), "0:9")
        );
    }
}