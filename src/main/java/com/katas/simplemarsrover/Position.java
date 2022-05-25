package com.katas.simplemarsrover;

public class Position {
    private Integer x;
    private Integer y;

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

    public Position move(String direction) throws PositionOutOfLimitsException {
        if (direction.equals("N")) {
            return new Position (++x, y);
        }

        if (direction.equals("S")) {
            return new Position (--x, y);
        }

        if (direction.equals("E")) {
            return new Position (x, ++y);
        }

        if (direction.equals("W")) {
            return new Position (x, --y);
        }

        return this;
    }

    public String value() {
        return x + ":" + y;
    }
}
