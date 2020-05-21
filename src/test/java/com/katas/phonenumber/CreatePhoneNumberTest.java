package com.katas.phonenumber;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePhoneNumberTest {

    @Test
    public void shouldThrowExceptionIfNumbersIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            CreatePhoneNumber.createPhoneNumber(new int[] {});
        });
    }

    @Test
    public void shouldThrowExceptionIfAnyNumberIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            CreatePhoneNumber.createPhoneNumber(new int[] {10});
        });
    }

    @Test
    public void tests() {
        assertEquals("(123) 456-7890", CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}