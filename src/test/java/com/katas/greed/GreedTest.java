package com.katas.greed;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreedTest {

    @Test
    public void shouldReturnOneThousandForThreeOnes() {
        assertEquals(1000, Greed.greedy(new int[]{1,1,1,0,0}));
    }

    @Test
    public void shouldReturnSixHundredForThreeSix() {
        assertEquals(600, Greed.greedy(new int[]{6,6,6,0,0}));
    }

    @Test
    public void shouldReturnTwoHundredForThreeTwo() {
        assertEquals(200, Greed.greedy(new int[]{2,2,2,0,0}));
    }

    @Test
    public void shouldReturnFiftyPointsForOneFive() {
        assertEquals(50, Greed.greedy(new int[]{5,2,3,4,6}));
    }

    @Test
    public void shouldReturnOneHundredPoints() {
        assertEquals(100, Greed.greedy(new int[]{1,0,0,0,0}));
    }

    @Test
    public void testExample() {
        assertEquals(250, Greed.greedy(new int[]{5,1,3,4,1}), "Score for [5,1,3,4,1] must be 250:");
        assertEquals(1100, Greed.greedy(new int[]{1,1,1,3,1}), "Score for [1,1,1,3,1] must be 1100:");
        assertEquals(450, Greed.greedy(new int[]{2,4,4,5,4}), "Score for [2,4,4,5,4] must be 450:");
    }
}