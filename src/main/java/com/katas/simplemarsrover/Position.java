package com.katas.simplemarsrover;

public class Position {
    private final Integer x;
    private final Integer y;

    public Position() throws PositionOutOfLimitsException {
        this(0, 0);
    }

    public Position(Integer x, Integer y) throws PositionOutOfLimitsException {
        if ((x < 0 || y < 0) || (x > 9 || y > 9)) {
            throw new PositionOutOfLimitsException();
        }

        this.x = x;
        this.y = y;
    }

    public Position move(Direction direction) throws PositionOutOfLimitsException {
        if (direction.isNorth()) {
            return new Position (x+1, y);
        }

        if (direction.isSouth()) {
            return new Position (x-1, y);
        }

        if (direction.isEast()) {
            return new Position (x, y+1);
        }

        if (direction.isWest()) {
            return new Position (x, y-1);
        }

        return this;
    }

    public String value() {
        return x + ":" + y;
    }
}
