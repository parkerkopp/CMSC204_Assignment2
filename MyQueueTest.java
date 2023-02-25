import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	public double one = 1.0, two = 2.0, three = 3.0;
	// STUDENT: add variables as needed for your student tests

	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(3);
		doubleQ.enqueue(one);
		doubleQ.enqueue(two);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		
		try {
			assertEquals(false,stringQ.isEmpty());
			stringQ.dequeue();
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(true, stringQ.isEmpty());
		} catch(QueueUnderflowException e) {
			
		}
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		try {
			doubleQ.dequeue();
			doubleQ.dequeue();
			assertTrue(doubleQ.isEmpty());
		}catch(QueueUnderflowException e) {
			
		}
	}

	@Test
	public void testSize() {
		
		try {
			assertEquals(3, stringQ.size());
			stringQ.enqueue(d);
			assertEquals(4, stringQ.size());
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(2, stringQ.size());
		} catch (QueueUnderflowException e) {
			
		} catch (QueueOverflowException e) {
			
		}
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		try {
			doubleQ.enqueue(three);
			assertTrue(doubleQ.isFull());
		}catch(QueueOverflowException e) {
			
		}
	}

	@Test
	public void testIsFull() {
		
		try {
			assertEquals(false, stringQ.isFull());
			stringQ.enqueue(d);
			stringQ.enqueue(e);
			assertEquals(true, stringQ.isFull());
		} catch (QueueOverflowException e) {
			
		}
	}

	@Test
	public void testToString() {
		
		try {
			assertEquals("abc", stringQ.toString());
			stringQ.enqueue(d);
			assertEquals("abcd", stringQ.toString());
			stringQ.enqueue(e);
			assertEquals("abcde", stringQ.toString());
		} catch (QueueOverflowException e) {
			
			
		}
		
	}
	
	@Test
	public void testToStringStudent() {
		try {
			doubleQ.enqueue(three);
			assertEquals("1.02.03.0", doubleQ.toString());
		}catch(QueueOverflowException e) {
			
		}
	}

	@Test
	public void testToStringDelimiter() {
		
		try {
			assertEquals("a%b%c", stringQ.toString("%"));
			stringQ.enqueue(d);
			assertEquals("a&b&c&d", stringQ.toString("&"));
			stringQ.enqueue(e);
			assertEquals("a/b/c/d/e", stringQ.toString("/"));
		} catch(QueueOverflowException e) {
			
		}
	}

	@Test
	public void testFill() {
		
		try {
			fill.add("apple");
			fill.add("banana");
			fill.add("carrot");
			//start with an empty queue
			stringQ = new MyQueue<String>(5);
			//fill with an ArrayList
			stringQ.fill(fill);
			assertEquals(3,stringQ.size());
			assertEquals("apple", stringQ.dequeue());
			assertEquals("banana", stringQ.dequeue());
			assertEquals("carrot", stringQ.dequeue());	
		} catch(QueueUnderflowException e) {
			
		}
	}

}
