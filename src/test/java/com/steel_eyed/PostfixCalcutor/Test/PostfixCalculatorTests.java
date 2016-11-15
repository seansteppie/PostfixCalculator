package com.steel_eyed.PostfixCalcutor.Test;

import org.junit.Test;

import static com.steel_eyed.PostfixCalculator.PostfixCalculator.evaluate;
import static org.junit.Assert.assertEquals;

/**
 * KataTests
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
    public void test1() throws Exception {
        assertEquals( 10, evaluate( "2 3 9 4 / + *" ) );
    }

    @Test
    public void test2() throws Exception {
        assertEquals( 70, evaluate( "25 45 +" ) );
    }

    @Test
    public void test3() throws Exception {
        assertEquals( 3600, evaluate( "20 40 + 60 *" ) );
    }

    @Test
    public void test4() throws Exception {
        assertEquals( 2000, evaluate( "20 40 60 + *" ) );
    }

    @Test
    public void test5() throws Exception {
        assertEquals( 1180, evaluate( "20 60 -1 + *" ) );
    }

    @Test( expected = RuntimeException.class )
    public void test6() throws RuntimeException {
        evaluate( "10 20 %" );
    }
}
