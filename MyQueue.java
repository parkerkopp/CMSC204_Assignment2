import java.util.*;

public class MyQueue<T> implements QueueInterface<T>{

	ArrayList<T> data;
	int size;
	int front;
	int back;
	int maxSize;
	
	public MyQueue() {
		
		data = new ArrayList<T>(50);
		front = 0;
		back = 0;
		size = 0;
		maxSize = 50;
		
	}
	
	public MyQueue(int x) {
		
		data = new ArrayList<T>(x);
		front = 0;
		back = 0;
		size = 0;
		maxSize = x;
		
	}

	//Returns a boolean indicating if the queue is empty or not
	public boolean isEmpty() {
		
		if(size == 0)
			
			return true;
		
		else
			
			return false;
		
	}
	
	//Returns a boolean indicating if the queue is full or not
	public boolean isFull() {
		
		if(size == maxSize)
			
			return true;
		
		else
			
			return false;
		
	}

	//Removes and returns the back element from the queue
	public T dequeue() throws QueueUnderflowException{

		if(isEmpty())
			
			throw new QueueUnderflowException("Cannot call cequeue on an empty queue");
		
		else {
			
			T toReturn = data.get(front);

			for(int i = 0; i < size-1; i++) {
				
				data.set(i, data.get(i+1));
				
			}
			
			size--;
			return toReturn;
			
		}
		
	}

	//Returns the size of the queue
	public int size() {
		
		return size;
		
	}

	//Adds an element to the front of the queue, returns true if the method was successful
	public boolean enqueue(T e) throws QueueOverflowException{
		
		if(isFull())
			
			throw new QueueOverflowException("Cannot call enqueue on a full queue");
		
		else {
			
			back++;
			data.add(e);
			size++;
			return true;
			
		}
		
	}

	//Returns a representation of the queue in string form
	public String toString() {
		
		return toString("");
		
	}

	//Returns a representation of the que in string form with the delimiter between each element
	public String toString(String delimiter) {
		
		String toReturn = "";
		
		for(int i = 0; i < size-1; i++) {
			
			toReturn += data.get(i) + delimiter;
			
		}

		toReturn += data.get(size-1);
		return toReturn;
			
			
	}

	//Fills the queue with elements from the ArrayList
	public void fill(ArrayList<T> list) {
		
		for(int i = 0; i < list.size(); i++) {
			
			try {
				
				enqueue(list.get(i));
				
			} catch (QueueOverflowException e) {
				
				System.out.println("Cannot push onto a full stack");
				
			}
			
		}
		
	}
	
}
