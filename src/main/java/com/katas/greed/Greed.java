package com.katas.greed;

public class Greed {

    private static final int NUM_GROUP_VALUES = 3;

    public static int greedy(int[] dice) {
        int[] valuesCounts = countDiceValues(dice);

        return calculatePoints(valuesCounts);
    }

    private static int[] countDiceValues(int[] dice) {
        int[] valuesCounts = {0, 0, 0, 0, 0, 0, 0};

        for (int value : dice) {
            valuesCounts[value] = ++valuesCounts[value];
        }

        return valuesCounts;
    }

    private static int calculatePoints(int[] valuesCounts) {
        int result = 0;

        for (int i = 1; i <= 6; i++) {
            int valueCount = valuesCounts[i];

            if (i == 1) {
                result += (valueCount / NUM_GROUP_VALUES) * 1000;
                valueCount %= NUM_GROUP_VALUES;
            }

            result += (valueCount / NUM_GROUP_VALUES) * (i * 100);
            valueCount %= NUM_GROUP_VALUES;

            if (i == 1) {
                result += valueCount * 100;
            }

            if (i == 5) {
                result += valueCount * 50;
            }
        }

        return result;
    }
}
