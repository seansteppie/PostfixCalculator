# PostfixCalculator

An implememtation of a Reverse Polish Notation/Postfix calculator (see: [Wikipedia](https://en.wikipedia.org/wiki/Reverse_Polish_notation)) written for
a programming challenge.

Can either be called with a string expression or as an array of operands/operators:

	PostfixCalculator.evaluate( "25 45 +" );

	PostfixCalculator.evaluate( new String[] { "2", "3", "9", "4", "/", "+", "*" } );

	

