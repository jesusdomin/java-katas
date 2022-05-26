package com.katas.simplemarsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void shouldEnsureInitialDirectionIsNorth() {
        var direction = new Direction();

        assertEquals("N", direction.direction());
    }

    @Test
    void shouldChangeDirectionToEastIfTurnToRightFromInitialPosition() {
        var direction = new Direction();

        direction.turnRight();

        assertEquals("E", direction.direction());
    }

    @Test
    void shouldChangeDirectionToWestIfTurnToLeftFromInitialPosition() {
        var direction = new Direction();

        direction.turnLeft();

        assertEquals("W", direction.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheRight() {
        var direction = new Direction();

        direction.turnRight();
        direction.turnRight();
        direction.turnRight();
        direction.turnRight();
        direction.turnRight();

        assertEquals("E", direction.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheLeft() {
        var direction = new Direction();

        direction.turnLeft();
        direction.turnLeft();
        direction.turnLeft();
        direction.turnLeft();
        direction.turnLeft();
        direction.turnLeft();

        assertEquals("S", direction.direction());
    }
}