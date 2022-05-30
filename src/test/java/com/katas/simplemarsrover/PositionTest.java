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
    void shouldIncreaseXValueWhenMoveToNorth(Direction direction, String expectedPosition) throws PositionOutOfLimitsException {
        var position = new Position(5, 5);

        var newPosition = position.move(direction);

        assertEquals(expectedPosition, newPosition.value());
    }

    @ParameterizedTest
    @MethodSource("movementsOutOfLimitProvider")
    void shouldDetectPositionsOutOfLimit(Integer x, Integer y, Direction direction) throws PositionOutOfLimitsException {
        var position = new Position(x, y);
        assertThrows(PositionOutOfLimitsException.class, () -> position.move(direction));
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
                arguments(0, 0, Direction.toSouth()),
                arguments(0, 0, Direction.toWest()),
                arguments(0, 9, Direction.toNorth()),
                arguments(0, 9, Direction.toWest()),
                arguments(9, 0, Direction.toEast()),
                arguments(9, 0, Direction.toSouth()),
                arguments(9, 9, Direction.toNorth()),
                arguments(9, 9, Direction.toEast())
        );
    }
}