package com.steel_eyed.PostfixCalculator;

import java.util.Stack;

/**
 * PostfixCalculator
 * <p>
 * @author Sean Steppie
 * <p>
 * @version 1.0.0        Date: 26/10/16     Initial Version
 */
public class PostfixCalculator {
    public PostfixCalculator() {
    }

    public long evaluate( String s ) {
        Stack< Long > operands = new Stack<>();
        for( String token : s.split( "\\s+" ) ) {
            if( token.matches( "-*\\d+" ) ) {
                operands.push( Long.parseLong( token ) );
                continue;
            }
            // Must be an operator
            if( operands.size() < 2 )
                throw new RuntimeException( "Not enough operands for operator: " + token );
            long value2 = operands.pop();
            long value1 = operands.pop();
            long total = calc( value1, token, value2 );
            operands.push( total );
        }
        return operands.pop();
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
