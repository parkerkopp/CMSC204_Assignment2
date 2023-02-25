import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	public double one = 1.0;
	public double two = 2.0; 
	public double three = 3.0;
	// STUDENT: add variables as needed for your student tests
	
	@BeforeEach
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		doubleS = new MyStack<Double>(3);
		doubleS.push(one);
		doubleS.push(two);
		
		//STUDENT: add setup for doubleS for student tests
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		
		try {
			
			stringS.pop();
			stringS.pop();
			stringS.pop();
			assertEquals(true, stringS.isEmpty());
			
		} catch (StackUnderflowException e) {
			
			
		}
		
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		try {
			
			stringS.push(d);
			stringS.push(e);
			assertEquals(true, stringS.isFull());
			
		} catch (StackOverflowException e) {
			
		}
		
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		try {
			doubleS.pop();
			doubleS.pop();
			assertTrue(doubleS.isEmpty());
		}catch(StackUnderflowException e) {
			
		}
	}
	
	@Test
	public void testTop() {
		
		try {
			assertEquals(c, stringS.top());
			stringS.push(d);
			assertEquals(d, stringS.top());
			stringS.pop();
			stringS.pop();
			assertEquals(b, stringS.top());	
			
		} catch(StackUnderflowException e) {
			
		} catch(StackOverflowException e) {
			
			
		}
		
	}

	@Test
	public void testSize() {
		
		try {
			assertEquals(3, stringS.size());
			stringS.push(d);
			assertEquals(4, stringS.size());
			stringS.pop();
			stringS.pop();
			assertEquals(2, stringS.size());
			
		} catch(StackUnderflowException e) {
			
			
		} catch(StackOverflowException e) {
			
		}
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		try {
			doubleS.push(three);
			assertTrue(doubleS.isFull());
		}catch(StackOverflowException e) {
			
		}
	}
	
	@Test
	public void testToString() {
		
		try {
			
			assertEquals("abc", stringS.toString());
			stringS.push(d);
			assertEquals("abcd", stringS.toString());
			stringS.push(e);
			assertEquals("abcde", stringS.toString());
		}catch(StackOverflowException e) {
			
		}
		
	}

	@Test
	public void testToStringStudent() {
		try {
			doubleS.push(three);
			assertEquals("1.02.03.0", doubleS.toString());
		}catch(StackOverflowException e) {
			
		}
	}
	
	@Test
	public void testToStringDelimiter() {
		
		try {
			assertEquals("a%b%c", stringS.toString("%"));
			stringS.push(d);
			assertEquals("a&b&c&d", stringS.toString("&"));
			stringS.push(e);
			assertEquals("a/b/c/d/e", stringS.toString("/"));
		} catch(StackOverflowException e) {
			
		}
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		
		try {
			assertEquals("carrot", stringS.pop());
			assertEquals("banana", stringS.pop());
			assertEquals("apple", stringS.pop());	
		} catch(StackUnderflowException e) {
			
		}
	}

}
