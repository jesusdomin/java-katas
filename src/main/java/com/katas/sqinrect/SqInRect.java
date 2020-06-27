package com.katas.sqinrect;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) {
            return null;
        }

        return divideRectangleInSquares(lng, wdth);
    }

    private static List<Integer> divideRectangleInSquares(int lng, int wdth) {
        List<Integer> squares = new ArrayList<>();

        while (lng != 0) {
            if (lng < wdth) {
                squares.add(lng);
                wdth = wdth - lng;
            } else {
                squares.add(wdth);
                lng = lng - wdth;
            }
        }

        return squares;
    }
}
