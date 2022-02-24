package core.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * To be Tested
 * 
 * @author amitk
 *
 * @param <Item>
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {

	public static final int INITIAL_CAPACITY = 16;
	public static final int RESIZE_THRESHHOLD = 16;
	Item[] stack;
	int N = 0;

	public ResizingArrayStack() {
		stack = (Item[]) new Object[INITIAL_CAPACITY];
	}

	// push: If array is full double the array capacity and copy the array elements
	public void push(Item item) {
		if (N == stack.length) {
			// resize to double the capacity
			resize(2 * s.length);
		}
		stack[N++] = item;
	}

	public Item pop() {
		if (N == 0) {
			return null;
		}
		Item item = stack[N];
		stack[N--] = null;
		if (stack.length > INITIAL_CAPACITY && N == stack.length / 4) {
			resize(s.length / 2);
			// resize to half the size
		}
		// resize if required.
		return item;
	}

	private void resize(int capacity) {
		stack = Arrays.copyOf(stack, capacity);
	}

	// pop: if array is less <capacity/4
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public boolean remove() {
			/* not Supported */ };

		public Item next() {
			return stack[--i];
		}

	}
}
