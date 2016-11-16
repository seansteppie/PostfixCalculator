package com.steel_eyed.Numeric;

import java.util.Stack;

/**
 * PostfixCalculator
 * <p>
 * Evaluate a postfix expression
 * <p>
 * Description:
 * <p>
 * Imagine you are in a universe where you can just perform the following arithmetic
 * operations. Addition(+), Subtraction(-), Multiplication(*), Division(/).
 * You are given given a postfix expression. Postfix expression is where operands
 * come after operator. Each operator and operand are separated by a space. You
 * need to evaluate the expression.
 * <p>
 * For example: 25 45 + is equivalent of 25 + 45, hence the answer would be 70.
 * Instead if you are given 20 40 + 60 *, it is equivalent of (20+40) * 60, hence
 * the answer should be 3600. 20 40 60 + * is equivalent of 20 * (40 + 60) = 2000.
 * <p>
 * Create a method 'evaluate' that takes a string as input and returns a long
 * resulted in the evaluation. Just concentrate on happy paths. Assume that
 * expression is always valid and division is always an integer division.
 * <p>
 * @author Sean Steppie
 * @version 1.0.0        Date: 26/10/16     Initial Version
 */
public class PostfixCalculator {
    public static long evaluate( String s ) {
        Stack< Long > operands = new Stack<>();
        for( String token : s.split( "\\s+" ) ) {
            if( token.matches( "-*\\d+" ) ) {
                operands.push( Long.parseLong( token ) );
                continue;
            }
            // Token must be an operator & there needs to be at least 2 operands on the stack
            if( operands.size() < 2 )
                throw new RuntimeException( "Not enough operands for operator: " + token );
            long value2 = operands.pop();
            long value1 = operands.pop();
            long total = calc( value1, token, value2 );
            operands.push( total );
        }
        return operands.pop();
    }

    /**
     * Take 2 numbers and apply + - / * operators to them.
     * @param value1 long
     * @param operator string
     * @param value2 long
     * @return result long
     * @throws RuntimeException if an invalid operator is passed.
     */
    private static long calc( long value1, String operator, long value2 ) {
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
