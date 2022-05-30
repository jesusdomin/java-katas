package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MarsRoverTest {
    @Test
    void shouldKeepInitialPositionAndDirectionIfMoveCommendsIsEmpty() {
        var marsRover = new MarsRover();

        assertEquals("0:0:N", marsRover.execute(""));
    }

    @Test
    void shouldChangeDirectionToEastIfRotateToRightFromInitialPosition() {
        var marsRover = new MarsRover();

        assertEquals("0:0:E", marsRover.execute("R"));
    }

    @Test
    void shouldChangeDirectionToWestIfRotateToLeftFromInitialPosition() {
        var marsRover = new MarsRover();

        assertEquals("0:0:W", marsRover.execute("L"));
    }

    @Test
    void shouldProcessMultipleDirectionChanges() {
        var marsRover = new MarsRover();

        assertEquals("0:0:E", marsRover.execute("RRRRR"));
    }

    @Test
    void shouldWrapAroundWhenTheEndOfTheFridIsReached() {
        var marsRover = new MarsRover();

        assertEquals("0:0:E", marsRover.execute("RMMMMMMMMMM"));
    }

    @ParameterizedTest
    @MethodSource("kataCommandsExamples")
    void shouldFinishInTheCorrectPositionAndDirectionAfterExecuteCommands(String commands, String expectedOutput) {
        var marsRover = new MarsRover();

        assertEquals(expectedOutput, marsRover.execute(commands));
    }

    static Stream<Arguments> kataCommandsExamples() {
        return Stream.of(
                arguments("MMRMMLM", "2:3:N"),
                arguments("MMMMMMMMMM", "0:0:N")
        );
    }
}