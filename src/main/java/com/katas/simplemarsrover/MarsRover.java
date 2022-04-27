package com.katas.simplemarsrover;

public class MarsRover {

    String direction;

    public MarsRover() {
        this.direction = "N";
    }

    public String execute(String moveCommands) {
        processCommands(moveCommands);

        return "0:0:" + direction;
    }

    private void processCommands(String moveCommands) {
        moveCommands
                .chars()
                .forEach(command -> processCommand((char) command));
    }

    private void processCommand(Character command) {
        if (command.equals('R')) {
            direction = "E";
        }

        if (command.equals('L')) {
            direction = "W";
        }
    }
}
