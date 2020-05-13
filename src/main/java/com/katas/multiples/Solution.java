package com.katas.multiples;

import java.util.stream.IntStream;

/**
 * +info: https://www.codewars.com/kata/514b92a657cdc65150000006/train/java
 */
public class Solution {

    public int solution(int number) {
        return IntStream.range(3, number)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
