 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class NotationTest {
	public String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "(5+4)";
	public String easyPostfix = "54+";
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@BeforeEach	
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() {
		try {
			String postfixResult = Notation.convertInfixToPostfix(complexInfix);
			assertEquals(complexPostfix, postfixResult);
		} catch (InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() {
		try {
			String postfixResult = Notation.convertInfixToPostfix(intermediateInfix);
			assertEquals(intermediatePostfix, postfixResult);
		} catch (InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() {
		try {
			String postfixResult = Notation.convertInfixToPostfix(easyInfix);
			assertEquals(easyPostfix, postfixResult);
		}catch(InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.convertInfixToPostfix(invalidInfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() {
		try {
			String infixResult = Notation.convertPostfixToInfix(complexPostfix);
			assertEquals(complexInfix, infixResult);
		}catch(InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() {
		try {
			String infixResult = Notation.convertPostfixToInfix(intermediatePostfix);
			assertEquals(intermediateInfix, infixResult);
		}catch(InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() {
		try {
			String infixResult = Notation.convertPostfixToInfix(easyPostfix);
			assertEquals(easyInfix, infixResult);
		}catch(InvalidNotationFormatException e) {
			
		}
	}

	@Test
	public void testInvalidPostfixExpressionB() {
		try{
			Notation.convertPostfixToInfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() {
		try {
			double result = Notation.evaluatePostfixExpression(complexPostfix);
			assertEquals(evalComplexPostfix, result, .001);
		}catch(InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() {
		try {
			double result = Notation.evaluatePostfixExpression(intermediatePostfix);
			assertEquals(evalIntermediatePostfix, result, .001);
		} catch (InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() {
		try {
			double result = Notation.evaluatePostfixExpression(easyPostfix);
			assertEquals(evalEasyPostfix, result, .001);
		} catch (InvalidNotationFormatException e) {
			
		}
	}
	
	@Test
	public void testInvalidPostfixExpressionA() {
		try{
			Notation.evaluatePostfixExpression(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
}
