package com.katas.simplemarsrover;

import java.util.Map;

public class Compass {
    private static final int NORTH = 0;
    private static final int WEST = 3;
    private static final Map<Integer, String> CARDINAL_POINTS_MAPPING = Map.of(
            0, "N",
            1, "E",
            2, "S",
            3, "W");

    private Integer direction;

    public Compass() {
        this.direction = 0;
    }

    public String direction() {
        return CARDINAL_POINTS_MAPPING.get(direction);
    }

    public void turnRight() {
        int nextDirection = direction + 1;
        direction = nextDirection % 4 <= 0 ? NORTH : nextDirection;
    }

    public void turnLeft() {
        int nextDirection = direction - 1;
        direction = nextDirection % 4 < 0 ? WEST : nextDirection;
    }
}
