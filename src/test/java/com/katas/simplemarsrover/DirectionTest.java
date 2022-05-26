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

        var newDirection = direction.turnRight();

        assertEquals("E", newDirection.direction());
    }

    @Test
    void shouldChangeDirectionToWestIfTurnToLeftFromInitialPosition() {
        var direction = new Direction();

        var newDirection = direction.turnLeft();

        assertEquals("W", newDirection.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheRight() {
        var direction = new Direction();

        var newDirection = direction.turnRight()
                .turnRight()
                .turnRight()
                .turnRight()
                .turnRight();

        assertEquals("E", newDirection.direction());
    }

    @Test
    void shouldProcessMultipleDirectionChangesToTheLeft() {
        var direction = new Direction();

        var newDirection = direction.turnLeft()
                .turnLeft()
                .turnLeft()
                .turnLeft()
                .turnLeft()
                .turnLeft();

        assertEquals("S", newDirection.direction());
    }
}