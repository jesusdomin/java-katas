package com.katas.convertstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertStringTest {

    @Test
    void shouldReturnEmptyStringWhenEmptyStringIsPassed() {
        assertEquals("", ConvertString.toCamelCase(""));
    }

    @Test
    void shouldConvertCamelCaseExceptFirstWord() {
        String input = "the-stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", ConvertString.toCamelCase(input));
    }

    @Test
    void shouldConvertCamelCaseAndKeepFirstWordCapitalization() {
        String input = "The-stealth-warrior";
        System.out.println("input: " + input);
        assertEquals("TheStealthWarrior", ConvertString.toCamelCase(input));
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", ConvertString.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", ConvertString.toCamelCase(input));
    }
}