package com.steel_eyed.PostfixCalcutor.Test;

import com.steel_eyed.PostfixCalculator.PostfixCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * KataTests
 * <p>
 * @author Sean Steppie
 * <p>
 * @version 1.0.0        Date: 28/10/16     Initial Version
 */
public class KataTests {
    PostfixCalculator eval = new PostfixCalculator();
    /**
     * Test It
     */
    @Test
    public void test1() throws Exception {
        assertEquals( 10, eval.evaluate( "2 3 9 4 / + *" ) );
    }
}
