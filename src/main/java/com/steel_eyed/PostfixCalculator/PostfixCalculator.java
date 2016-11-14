package com.steel_eyed.PostfixCalculator;

import java.util.Stack;

/**
 * NewPostfixEvaluate
 * <p>
 * @author Sean Steppie
 * <p>
 * @version 1.0.0        Date: 26/10/16     Initial Version
 */
public class PostfixCalculator {
    public PostfixCalculator() {
    }

    public long evaluate( String s ) {
        Stack< Long > numerics = new Stack<>();
        for( String token : s.split( "\\s+" ) ) {
            if( token.matches( "\\d+" ) ) {
                numerics.push( Long.parseLong( token ) );
                continue;
            }
            // Must be an operator
            long value2 = numerics.pop();
            long value1 = numerics.pop();
            long total = calc( value1, token, value2 );
            numerics.push( total );
        }
        return numerics.pop();
    }

    private long calc( long value1, String operator, long value2 ) {
        long result;
        switch( operator ) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                result = value1 / value2;
                break;
            default:
                throw new RuntimeException( "Unknown operator: " + operator );
        }
        return result;
    }
}
