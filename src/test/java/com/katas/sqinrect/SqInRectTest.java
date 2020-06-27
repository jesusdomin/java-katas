package com.katas.sqinrect;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SqInRectTest {

    @Test
    public void shouldReturnNullIfSquare() {
        assertNull(SqInRect.sqInRect(5, 5));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void shouldFindSquaresInRest(int lng, int wdth, List<Integer> expectedResult) {
        assertEquals(expectedResult, SqInRect.sqInRect(lng, wdth));
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                arguments(625, 230, new ArrayList<>(Arrays.asList(230, 230, 165, 65, 65, 35, 30, 5, 5, 5, 5, 5, 5))),
                arguments(240, 32, new ArrayList<>(Arrays.asList(32, 32, 32, 32, 32, 32, 32, 16, 16))),
                arguments(14, 20, new ArrayList<>(Arrays.asList(14, 6, 6, 2, 2, 2))),
                arguments(20, 14, new ArrayList<>(Arrays.asList(14, 6, 6, 2, 2, 2))),
                arguments(5, 3, new ArrayList<>(Arrays.asList(3, 2, 1, 1))),
                arguments(10, 5, new ArrayList<>(Arrays.asList(5, 5)))
        );
    }
}