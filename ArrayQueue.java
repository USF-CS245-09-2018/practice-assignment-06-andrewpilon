// Andrew Pilon
import java.util.Arrays;

public class ArrayQueue implements Queue {
	
	int front = 0;
	int back = 0;
	Object[] queue = new Object[10]; // default queue to size 10
	
	public Object dequeue() {
		if (empty()) { // check case of empty queue
			System.out.println("Error: Queue is empty.");
			return null;
		}
		front = (front+1)%queue.length; // push front back to next item
		Object front_item = queue[front]; // return item, set location to null
		queue[front] = null;
		return front_item;
	}
	
	public void enqueue(Object item) {
		// put element at back
		if ((back+1)%queue.length == front) {
			growArray();
		}
		back = (back+1)%queue.length; //wraps around if necessary
		queue[back] = item; // adds item to end of updated queue
	}
	
	public boolean empty() {
		return (front == back); // true if no items in queue
	}
	
	public void growArray() {
		// NOTE: cannot just expand like with stack because data may be wrapped around/broken up
		Object[] newqueue = new Object[queue.length*2]; // double size for new array
		int start = (front+1) % queue.length;
		if (start<2) { 
			// no break in data, copy regularly
			System.arraycopy(queue, start, newqueue, 0, queue.length-start);
		}
		else {
			// need to copy in two parts (data wraps around in queue)
			System.arraycopy(queue, start, newqueue, 0, queue.length - start);
			System.arraycopy(queue, 0, newqueue, queue.length - start, back + 1);
		}
		front = newqueue.length-1;
		back = queue.length-2; // one less than the size (length-1)
		queue = newqueue; // this is now the fixed & expanded queue array
	}
}