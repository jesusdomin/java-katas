package com.katas.simplemarsrover;

public class Position {
    private static final Integer MIN_POSITION = 0;
    private static final Integer MAX_POSITION = 9;

    private final Integer x;
    private final Integer y;

    public Position() {
        this(MIN_POSITION, MIN_POSITION);
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
        if (coordinate < MIN_POSITION) {
            return MAX_POSITION;
        }

        if (coordinate > MAX_POSITION) {
            return MIN_POSITION;
        }

        return coordinate;
    }
}
