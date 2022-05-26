package com.katas.simplemarsrover;

public class MarsRover {
    private final Direction direction;

    public MarsRover() {
        this.direction = new Direction();
    }

    public String execute(String commands) {
        processCommands(commands);

        return "0:0:" + direction.direction();
    }

    private void processCommands(String commands) {
        commands
                .chars()
                .forEach(command -> processSingleCommand((char) command));
    }

    private void processSingleCommand(Character command) {
        if (command.equals('R')) {
            direction.turnRight();
        }

        if (command.equals('L')) {
            direction.turnLeft();
        }
    }
}
