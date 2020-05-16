package com.katas.validbraces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BraceCheckerTest {

    private final BraceChecker checker = new BraceChecker();

    @ParameterizedTest
    @MethodSource("validBraces")
    public void testValid(String braces) {
        assertTrue(checker.isValid(braces));
    }

    @ParameterizedTest
    @MethodSource("invalidBraces")
    public void testInvalid(String braces) {
        assertFalse(checker.isValid(braces));
    }

    static Stream<Arguments> validBraces() {
        return Stream.of(
                arguments("()"),
                arguments("(){}[]"),
                arguments("([{}])")
        );
    }

    static Stream<Arguments> invalidBraces() {
        return Stream.of(
                arguments("(}"),
                arguments("[(])"),
                arguments("[({})](]"),
                arguments("]"),
                arguments("(})"),
                arguments(")(}{]["),
                arguments("())({}}{()][]["),
                arguments("(((({{")
        );
    }
}