package com.katas.simplemarsrover;

public class MarsRover {
    private Direction direction;
    private Position position;
    private final Grid grid;

    public MarsRover() {
        this.direction = new Direction();
        this.position = new Position();
        this.grid = new Grid();
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
            default -> ignoreCommand();
        }
    }

    private void turnRight() {
        direction = direction.turnRight();
    }

    private void turnLeft() {
        direction = direction.turnLeft();
    }

    private void move() {
        position = grid.calculateNextPosition(position, direction);
    }

    private void ignoreCommand() {
        // Do nothing
    }

    private String buildOutput() {
        return position.value() + ":" + direction.cardinalPoint();
    }
}
