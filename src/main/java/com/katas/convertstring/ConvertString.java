package com.katas.convertstring;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * +Info: https://www.codewars.com/kata/517abf86da9663f1d2000003/train/java
 */
public class ConvertString {

    static String toCamelCase(String s){
        AtomicInteger index = new AtomicInteger();

        return Stream.of(s.split("([-_])"))
                .map((str) -> index.getAndIncrement() > 0 ? capitalize(str) : str)
                .collect(Collectors.joining());
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
