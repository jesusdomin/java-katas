package com.katas.simplemarsrover;

public class MarsRover {
    private Direction direction;
    private Position position;

    public MarsRover() throws PositionOutOfLimitsException {
        this.direction = new Direction();
        this.position = new Position();
    }

    public String execute(String commands) {
        processCommands(commands);

        return buildOutput();
    }

    private void processCommands(String commands) {
        commands.chars()
                .forEach(command -> processSingleCommand((char) command));
    }

    private void processSingleCommand(Character command) {
        switch (command) {
            case 'R' -> turnRight();
            case 'L' -> turnLeft();
            case 'M' -> move();
        }
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void move() {
        try {
            position = position.move(direction.direction());
        } catch (PositionOutOfLimitsException e) {
            direction = direction.wrapAround();
        }
    }

    private String buildOutput() {
        return position.value() + ":" + direction.direction();
    }
}
