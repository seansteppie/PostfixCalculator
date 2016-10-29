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
            long total = calc( numerics.pop(), numerics.pop(), token );
            numerics.push( total );
        }
        return numerics.pop();
    }

    public long calc( long value1, long value2, String operator ) {
        long result;
        switch( operator ) {
            case "+":
                result = value2 + value1;
                break;
            case "-":
                result = value2 - value1;
                break;
            case "*":
                result = value2 * value1;
                break;
            case "/":
                result = value2 / value1;
                break;
            default:
                throw new RuntimeException( "Unknown operator: " + operator );
        }
        System.out.println( value1 + " " + operator + " " + value2 + " = " + result );
        return result;
    }

    public static void main( String[] args ) {
        PostfixCalculator eval = new PostfixCalculator();
        System.out.println( eval.evaluate( "2 3 9 4 / + *" ) );
        System.out.println( eval.evaluate( "20 40 + 60 *" ) );
        System.out.println( eval.evaluate( "20 40 60 + *" ) );
    }
}
