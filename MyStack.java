import java.util.*;

public class MyStack<T> implements StackInterface<T> {
	
	ArrayList<T> data;
	int top;
	int maxSize;
	
	public MyStack() {
		
		data = new ArrayList<T>(50);
		top = 0;
		
	}
	
	public MyStack(int x) {
		
		data = new ArrayList<T>(x);
		maxSize = x;
		top = -1;
		
	}
	
	//Returns a boolean indicating if the stack is empty or not
	public boolean isEmpty() {
		
		if(top == -1)
			
			return true;
		
		else
			
			return false;
		
	}
	
	//Returns a boolean indicating if the stack is full or not
	public boolean isFull() {
		
		if(top+1 == maxSize)
			
			return true;
		
		else
			
			return false;
		
	}
	
	//Removes the top element from the Stack and returns it
	public T pop() throws StackUnderflowException{
		
		if(isEmpty())
			
			throw new StackUnderflowException("Cannot call pop on an empty stack.");
		
		else {
			
			T toReturn =  data.get(top);
			data.remove(top);
			top--;
			return toReturn;
			
		}
		
	}

	//Returns the top element of the stack
	public T top() throws StackUnderflowException{
		
		if(top == 0)
			
			throw new StackUnderflowException("Cannot call top on an empty stack.");
		
		else
			
			return data.get(top);
		
	}
	
	//Returns the number of elements in the stack
	public int size() {
		
		return top+1;
		
	}
	
	//Adds an element to the stack, returns true if the operation was successful
	public boolean push(T e) throws StackOverflowException{
		
		if(isFull())
			
			throw new StackOverflowException("Cannot call push on a full stack");
		
		else {
			
			data.add(e);
			top++;
			return true;
			
		}
	
		
	}

	//Returns the string representation of the stack
	public String toString() {

		return toString("");
		
	}
	
	//Returns the string representation of the stack with the delimiter between each element
	public String toString(String delimiter) {
		
		String toReturn = "";
		
		for(int i = 0; i < data.size()-1; i++) {
			
			toReturn += data.get(i) + delimiter;
			
		}
		
		toReturn += data.get(data.size()-1);
		
		return toReturn;
		
	}
	
	//Fills the stack with elements from the ArrayList
	public void fill(ArrayList<T> list) {
		
 		for(int i = 0; i < list.size(); i++) {
			
			try {
				
				push(list.get(i));
				
			} catch (StackOverflowException e) {
				
				System.out.println("Cannot push onto a full stack");
				
			}
			
		}
		
	}
	
}
