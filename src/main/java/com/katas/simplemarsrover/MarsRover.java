package com.katas.simplemarsrover;

public class MarsRover {
    private final Compass compass;

    public MarsRover() {
        this.compass = new Compass();
    }

    public String execute(String commands) {
        processCommands(commands);

        return "0:0:" + compass.direction();
    }

    private void processCommands(String commands) {
        commands
                .chars()
                .forEach(command -> processSingleCommand((char) command));
    }

    private void processSingleCommand(Character command) {
        if (command.equals('R')) {
            compass.turnRight();
        }

        if (command.equals('L')) {
            compass.turnLeft();
        }
    }
}
