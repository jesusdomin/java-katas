package com.katas.convertstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertStringTest {

    @Test
    void shouldReturnEmptyStringWhenEmptyStringIsPassed() {
        assertEquals("", ConvertString.toCamelCase(""));
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";

        assertEquals("theStealthWarrior", ConvertString.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";

        assertEquals("theStealthWarrior", ConvertString.toCamelCase(input));
    }

    @Test
    void shouldConvertCamelCaseAndKeepFirstWordCapitalization() {
        String input = "The-stealth-warrior";

        assertEquals("TheStealthWarrior", ConvertString.toCamelCase(input));
    }
}