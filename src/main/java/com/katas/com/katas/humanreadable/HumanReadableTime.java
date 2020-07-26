package com.katas.com.katas.humanreadable;

public class HumanReadableTime {
    public static final int MAX_ALLOWED_SECONDS = 359999;

    public static String makeReadable(int seconds) {
        assertSecondsAreValidValue(seconds);

        var resultSeconds = seconds % 60;
        var resultHours = seconds / 60;
        var resultMinutes = resultHours % 60;
        resultHours = resultHours / 60;

        return String.format("%02d:%02d:%02d", resultHours, resultMinutes, resultSeconds);
    }

    private static void assertSecondsAreValidValue(int seconds) {
        if (seconds < 0 || seconds > MAX_ALLOWED_SECONDS) {
            throw new IllegalArgumentException();
        }
    }
}
