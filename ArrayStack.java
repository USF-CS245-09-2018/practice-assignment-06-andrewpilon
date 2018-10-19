// Andrew Pilon
import java.util.Arrays;

public class ArrayStack implements Stack {
	
	int top = 0;
	Object[] stack = new Object[10]; // default stack to size 10
	// no need to initialize a size int as it is directly related to top
	
	public void push(Object item) {
		if (top==stack.length) {
			growArray();
		}
		stack[top++] = item; // add item and increment top
	}
	
	public Object pop() {
		if (empty()) { // check for if there are no items in stack
			System.out.println("Error: Stack is empty.");
			return null;
		}
		Object top_item = stack[top-1]; // get top item
		stack[top--] = null; // decrease top again, after setting value to null
		return top_item;
	}
	
	public Object peek() {
		if (empty()) { // check for if there are no items in stack
			System.out.println("Error: Stack is empty.");
			return null;
		}
		return stack[top-1]; // otherwise, return first accessible item
	}
	
	public boolean empty() {
		return (top==0); // true if no items in array
	}
	
	public void growArray() {
		stack = Arrays.copyOf(stack, stack.length*2); // double size if we exceed item limit
	}
	
	public int size() {
		return top; // number of items in the stack
	}
}