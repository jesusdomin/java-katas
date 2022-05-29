package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {
    @Test
    void shouldKeepInitialPositionAndDirectionIfMoveCommendsIsEmpty() throws PositionOutOfLimitsException {
        var marsRover = new MarsRover();

        assertEquals("0:0:N", marsRover.execute(""));
    }

    @Test
    void shouldChangeDirectionToEastIfRotateToRightFromInitialPosition() throws PositionOutOfLimitsException {
        var marsRover = new MarsRover();

        assertEquals("0:0:E", marsRover.execute("R"));
    }

    @Test
    void shouldChangeDirectionToWestIfRotateToLeftFromInitialPosition() throws PositionOutOfLimitsException {
        var marsRover = new MarsRover();

        assertEquals("0:0:W", marsRover.execute("L"));
    }

    @Test
    void shouldProcessMultipleDirectionChanges() throws PositionOutOfLimitsException {
        var marsRover = new MarsRover();

        assertEquals("0:0:E", marsRover.execute("RRRRR"));
    }
}