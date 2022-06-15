package com.katas.simplemarsrover;

public class Grid {
    private static final Integer MIN_POSITION = 0;
    private static final Integer MAX_POSITION = 9;

    public Position calculateNextPosition(Position fromPosition, Direction withDirection) {
        if (withDirection.isNorth()) {
            return new Position (fromPosition.x(), wrapAroundIfLimitIsReached(fromPosition.y()+1));
        }

        if (withDirection.isSouth()) {
            return new Position (fromPosition.x(), wrapAroundIfLimitIsReached(fromPosition.y()-1));
        }

        if (withDirection.isEast()) {
            return new Position (wrapAroundIfLimitIsReached(fromPosition.x()+1), fromPosition.y());
        }

        if (withDirection.isWest()) {
            return new Position (wrapAroundIfLimitIsReached(fromPosition.x()-1), fromPosition.y());
        }
        
        return fromPosition;
    }

    private Integer wrapAroundIfLimitIsReached(Integer value) {
        if (value < MIN_POSITION) {
            return MAX_POSITION;
        }

        if (value > MAX_POSITION) {
            return MIN_POSITION;
        }

        return value;
    }
}
