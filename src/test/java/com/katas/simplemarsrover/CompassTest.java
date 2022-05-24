package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {
    @Test
    void shouldEnsureInitialDirectionIsNorth() {
        var compass = new Compass();

        assertEquals("N", compass.direction());
    }

    @Test
    void shouldChangeDirectionToEastIfTurnToRightFromInitialPosition() {
        var compass = new Compass();

        compass.turnRight();

        assertEquals("E", compass.direction());
    }

    @Test
    void shouldChangeDirectionToWestIfTurnToLeftFromInitialPosition() {
        var compass = new Compass();

        compass.turnLeft();

        assertEquals("W", compass.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheRight() {
        var compass = new Compass();

        compass.turnRight();
        compass.turnRight();
        compass.turnRight();
        compass.turnRight();
        compass.turnRight();

        assertEquals("E", compass.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheLeft() {
        var compass = new Compass();

        compass.turnLeft();
        compass.turnLeft();
        compass.turnLeft();
        compass.turnLeft();
        compass.turnLeft();
        compass.turnLeft();

        assertEquals("S", compass.direction());
    }
}