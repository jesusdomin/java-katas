package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}