
public class Notation {
	
	//Returns the value of an evaluated postfix expression
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		MyStack<String> stack = new MyStack<String>(postfixExpr.length());
		
		try {
			
			for(int i = 0; i < postfixExpr.length(); i++) {
				
				if( (postfixExpr.charAt(i) >= 48 && postfixExpr.charAt(i) <= 57) || postfixExpr.charAt(i) == '(') 
					
					stack.push(postfixExpr.charAt(i) + "");
				
				else if(postfixExpr.charAt(i) == '+' || postfixExpr.charAt(i) == '-' || postfixExpr.charAt(i) == '*' || postfixExpr.charAt(i) == '/') {
					
					double operand2 = Double.parseDouble(stack.pop());
					double operand1 = Double.parseDouble(stack.pop());
					
					if(postfixExpr.charAt(i) == '+')
						
						stack.push((operand1 + operand2) + "");
					
					else if(postfixExpr.charAt(i) == '-')
						
						stack.push((operand1 - operand2) + "");
					
					else if(postfixExpr.charAt(i) == '*')
						
						stack.push((operand1 * operand2) + "");
					
					else
						
						stack.push((operand1 / operand2) + "");
					
				}
				
			}
			
			if(stack.size() != 1)
				
				throw new InvalidNotationFormatException("The format notation is invalid");
			
			return Double.parseDouble(stack.pop());
			
		} catch (StackOverflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		} catch (StackUnderflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		}
		
	}
	
	//Converts a postfix expression to an infix expression
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<String>(postfix.length());
		
		try {
			
			for(int i = 0; i < postfix.length(); i++) {
				
				if(postfix.charAt(i) >= 48 && postfix.charAt(i) <= 57)
					
					stack.push(postfix.charAt(i) + "");
				
				else if(postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*' || postfix.charAt(i) == '/') {
					
					String operand2 = stack.pop();
					String operand1 = stack.pop();
					String toPush = "(" + operand1 + postfix.charAt(i) + operand2 + ")";
					stack.push(toPush);
					
				}
				
			}
			
			if(stack.size() != 1)
				
				throw new InvalidNotationFormatException("The format notation is invalid");
			
			return stack.toString();
			
		} catch(StackOverflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		} catch(StackUnderflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		}
		
	}
	
	//Converts a infix expression into a postfix expression
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		
		MyQueue<Character> solution = new MyQueue<Character>(infix.length());
		MyStack<Character> stack = new MyStack<Character>(infix.length());
		
		try {
			
			for(int i = 0; i < infix.length(); i++) {
				
				if(infix.charAt(i) >= 48 && infix.charAt(i) <= 57)
					
					solution.enqueue(infix.charAt(i));
				
				else if (infix.charAt(i) == '(')
					
					stack.push(infix.charAt(i));
				
				else if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {
					
					if(stack.top() == '+' || stack.top() == '-' || stack.top() == '*' || stack.top() == '/') {
						
						solution.enqueue(stack.pop());
						
					}
					
					stack.push(infix.charAt(i));
					
				}
				
				else if (infix.charAt(i) == '*' || infix.charAt(i) == '/') {
					
					if(stack.top() == '*' || stack.top() == '/') {
						
						solution.enqueue(stack.pop());
					}
					
					stack.push(infix.charAt(i));
					
				}	
				
				else if(infix.charAt(i) == ')') {
					
					while(stack.top() != '(')
						
						solution.enqueue(stack.pop());
					
					stack.pop();
					
				}
			
			}
			
			return solution.toString();
			
		} catch(QueueOverflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		} catch(StackOverflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		} catch(StackUnderflowException e) {
			
			throw new InvalidNotationFormatException("The format notation is invalid");
			
		}
		
	}
	
}
