package com.katas.simplemarsrover;

public class Position {
    private final Integer x;
    private final Integer y;

    public Position() {
        this(0, 0);
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position move(Direction direction) {
        if (direction.isNorth()) {
            return new Position (x, wrapAroundIfLimitIsReached(y+1));
        }

        if (direction.isSouth()) {
            return new Position (x, wrapAroundIfLimitIsReached(y-1));
        }

        if (direction.isEast()) {
            return new Position (wrapAroundIfLimitIsReached(x+1), y);
        }

        if (direction.isWest()) {
            return new Position (wrapAroundIfLimitIsReached(x-1), y);
        }

        return this;
    }

    public String value() {
        return x + ":" + y;
    }

    private Integer wrapAroundIfLimitIsReached(Integer coordinate) {
        if (coordinate < 0) {
            return 9;
        }

        if (coordinate > 9) {
            return 0;
        }

        return coordinate;
    }
}
