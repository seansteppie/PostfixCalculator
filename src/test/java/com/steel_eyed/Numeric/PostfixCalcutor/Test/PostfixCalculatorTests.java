package com.steel_eyed.Numeric.PostfixCalcutor.Test;

import com.steel_eyed.Numeric.PostfixCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PostfixCalculatorTests
 * <p>
 * @author Sean Steppie
 * <p>
 * @version 1.0.0        Date: 28/10/16     Initial Version
 */
public class PostfixCalculatorTests {
    /**
     * Test It
     */
    @Test
    public void testArray() throws Exception {
        assertEquals( 10, PostfixCalculator.evaluate( new String[] { "2", "3", "9", "4", "/", "+", "*" } ) );
    }

    @Test
    public void testSimpleCase() throws Exception {
        assertEquals( 70, PostfixCalculator.evaluate( "25 45 +" ) );
    }

    @Test
    public void testMixOperandsOperators() throws Exception {
        assertEquals( 3600, PostfixCalculator.evaluate( "20 40 + 60 *" ) );
    }

    @Test
    public void testDifferentOperatorOrder() throws Exception {
        assertEquals( 2000, PostfixCalculator.evaluate( "20 40 60 + *" ) );
    }

    @Test
    public void testNegativeNumber() throws Exception {
        assertEquals( 1180, PostfixCalculator.evaluate( "20 60 -1 + *" ) );
    }

    @Test( expected = RuntimeException.class )
    public void testInvalidOperator() throws RuntimeException {
        PostfixCalculator.evaluate( "10 20 %" );
    }

    @Test( expected = RuntimeException.class )
    public void testWrongNoOfTokens() throws RuntimeException {
        PostfixCalculator.evaluate( "10 20 * +" );
    }
}
