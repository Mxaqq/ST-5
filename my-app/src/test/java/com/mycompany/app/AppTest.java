package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private static final double TOLERANCE = 1e-8;

    @Test
    void averageWithPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.average(2.0, 8.0);
        assertEquals(5.0, result, TOLERANCE);
    }

    @Test
    void averageWithNegativeAndPositiveNumbers() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.average(-3.5, 3.5);
        assertEquals(0.0, result, TOLERANCE);
    }

    @Test
    void averageWithZeros() {
        Sqrt sqrt = new Sqrt(0);
        double result = sqrt.average(0.0, 0.0);
        assertEquals(0.0, result, TOLERANCE);
    }

    @Test
    void goodMethodAtBoundary() {
        Sqrt sqrt = new Sqrt(10.0);
        double guess = Math.sqrt(10.0) + 1e-9;
        assertTrue(sqrt.good(guess, 10.0));
    }

    @Test
    void goodMethodJustOutsideBoundary() {
        Sqrt sqrt = new Sqrt(10.0);
        double guess = Math.sqrt(10.0) + 1e-7;
        assertFalse(sqrt.good(guess, 10.0));
    }

    @Test
    void goodMethodWithNegativeGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        assertTrue(sqrt.good(-3.0, 9.0));
    }

    @Test
    void improveMethodBringsGuessCloser() {
        Sqrt sqrt = new Sqrt(9.0);
        double initialGuess = 2.0;
        double improvedGuess = sqrt.improve(initialGuess, 9.0);
        assertTrue(Math.abs(improvedGuess - 3.0) < Math.abs(initialGuess - 3.0));
    }

    @Test
    void improveMethodWithPerfectGuess() {
        Sqrt sqrt = new Sqrt(16.0);
        double improvedGuess = sqrt.improve(4.0, 16.0);
        assertEquals(4.0, improvedGuess, TOLERANCE);
    }

    @Test
    void improveMethodWithNegativeGuess() {
        Sqrt sqrt = new Sqrt(9.0);
        double improvedGuess = sqrt.improve(-5.0, 9.0);
        assertEquals(-3.4, improvedGuess, TOLERANCE);
    }

    @Test
    void iterMethodWithGoodInitialGuess() {
        Sqrt sqrt = new Sqrt(25.0);
        double result = sqrt.iter(5.0, 25.0);
        assertEquals(5.0, result, TOLERANCE);
    }

    @Test
    void iterMethodWithNegativeInitialGuess() {
        Sqrt sqrt = new Sqrt(36.0);
        double result = sqrt.iter(-10.0, 36.0);
        assertEquals(-6.0, result, TOLERANCE);
    }

    @Test
    void calcMethodWithPerfectSquare() {
        Sqrt sqrt = new Sqrt(49.0);
        double result = sqrt.calc();
        assertEquals(7.0, result, TOLERANCE);
    }

    @Test
    void calcMethodWithNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(2.0);
        double result = sqrt.calc();
        assertEquals(1.41421356, result, 1e-7);
    }

    @Test
    void calcMethodWithFractionalInput() {
        Sqrt sqrt = new Sqrt(0.25);
        double result = sqrt.calc();
        assertEquals(0.5, result, TOLERANCE);
    }

    @Test
    void calcMethodWithZeroAndOne() {
        Sqrt sqrtOne = new Sqrt(1.0);
        assertEquals(1.0, sqrtOne.calc(), TOLERANCE);

        Sqrt sqrtZero = new Sqrt(0.0);
        double resultZero = sqrtZero.calc();
        assertTrue(sqrtZero.good(resultZero, 0.0));
    }

    @Test
    void calcMethodWithTinyInput() {
        Sqrt sqrt = new Sqrt(1e-10);
        double result = sqrt.calc();
        assertTrue(sqrt.good(result, 1e-10));
    }
}