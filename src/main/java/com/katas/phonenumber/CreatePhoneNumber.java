package com.katas.phonenumber;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) throws IllegalArgumentException {
        String phoneNumbers = Arrays.toString(numbers).replaceAll("[\\[\\]\\,\\s]", "");

        if (phoneNumbers.length() != 10) {
            throw new IllegalArgumentException();
        }

        return phoneNumbers.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }
}
