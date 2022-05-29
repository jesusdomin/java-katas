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
                arguments(new Direction(Direction.NORTH), "6:5"),
                arguments(new Direction(Direction.SOUTH), "4:5"),
                arguments(new Direction(Direction.EAST), "5:6"),
                arguments(new Direction(Direction.WEST), "5:4")
        );
    }

    static Stream<Arguments> movementsOutOfLimitProvider() {
        return Stream.of(
                arguments(0, 0, new Direction(Direction.SOUTH)),
                arguments(0, 0, new Direction(Direction.WEST)),
                arguments(9, 0, new Direction(Direction.NORTH)),
                arguments(9, 0, new Direction(Direction.WEST)),
                arguments(0, 9, new Direction(Direction.EAST)),
                arguments(0, 9, new Direction(Direction.SOUTH)),
                arguments(9, 9, new Direction(Direction.NORTH)),
                arguments(9, 9, new Direction(Direction.EAST))
        );
    }
}