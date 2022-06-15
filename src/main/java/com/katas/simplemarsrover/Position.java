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

    public Integer x() {
        return x;
    }

    public Integer y() {
        return y;
    }

    public String value() {
        return x + ":" + y;
    }
}
