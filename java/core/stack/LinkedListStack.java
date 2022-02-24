package core.stack;

public class LinkedListStack<Item>  {
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = first;
		first = newNode;
	}

	public Item push() {
		if (isEmpty())
			return null;
		Item item = first.item;
		first = first.next;
		return item;
	}
	

}
