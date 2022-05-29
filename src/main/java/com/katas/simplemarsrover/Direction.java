package com.katas.simplemarsrover;

import java.util.Map;

public class Direction {
    public static final int NORTH = 0;
    public static final int WEST = 3;
    public static final int SOUTH = 2;
    public static final int EAST = 1;

    private static final Map<Integer, String> CARDINAL_POINTS_MAPPING = Map.of(
            0, "N",
            1, "E",
            2, "S",
            3, "W");

    private final Integer value;

    public Direction() {
        this(0);
    }

    public Direction(Integer direction) {
        this.value = direction;
    }

    public String cardinalPoint() {
        return CARDINAL_POINTS_MAPPING.get(value);
    }

    public Direction turnRight() {
        int nextDirection = value + 1;

        return new Direction(nextDirection % 4 <= 0 ? NORTH : nextDirection);
    }

    public Direction turnLeft() {
        int nextDirection = value - 1;

        return new Direction(nextDirection % 4 < 0 ? WEST : nextDirection);
    }

    public Direction wrapAround() {
        return this.turnLeft().turnLeft();
    }

    public boolean isNorth() {
        return value == NORTH;
    }

    public boolean isSouth() {
        return value == SOUTH;
    }

    public boolean isEast() {
        return value == EAST;
    }

    public boolean isWest() {
        return value == WEST;
    }
}
