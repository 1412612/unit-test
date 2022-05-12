package com.unit.test.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluateExpressionTest{
    @Test
    public void exampleOne() {
        final double expected = 366.76;

        final double actual = EvaluateExpression.evaluateExpression("34.6 * ( 23.5 - 12.9 )");

        assertEquals(expected, actual);
    }

    @Test
    public void exampleTwo() {
        final double expected = 2;

        final double actual = EvaluateExpression.evaluateExpression("1 + 1");

        assertEquals(expected, actual);
    }

    @Test
    public void exampleThree() {
        final double expected = 77.48;

        final double actual = EvaluateExpression.evaluateExpression("( 8.3 * 5.6 ) + 4 * 6 + ( 5 + 2 )");

        assertEquals(expected, actual);
    }
}
