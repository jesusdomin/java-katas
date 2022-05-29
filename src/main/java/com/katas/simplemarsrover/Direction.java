package com.katas.simplemarsrover;

import java.util.Map;

public class Direction {
    private static final int NORTH = 0;
    private static final int WEST = 3;
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

    public String direction() {
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
}
