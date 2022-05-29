package com.katas.simplemarsrover;

public class MarsRover {
    private Direction direction;
    private Position position;

    public MarsRover() throws PositionOutOfLimitsException {
        this.direction = new Direction();
        this.position = new Position();
    }

    public String execute(String commands) {
        executeCommands(commands);

        return buildOutput();
    }

    private void executeCommands(String commands) {
        commands.chars()
                .forEach(command -> executeSingleCommand((char) command));
    }

    private void executeSingleCommand(Character command) {
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
            position = position.move(direction);
        } catch (PositionOutOfLimitsException e) {
            direction = direction.wrapAround();
        }
    }

    private String buildOutput() {
        return position.value() + ":" + direction.cardinalPoint();
    }
}
