package ds.stack;

public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}

	public void push(long j) {
		if (isFull()) {
			System.out.println("The stack is already Full");
		} else {
			top++;
			stackArray[top] = j;
		}

	}

	public long pop() {
		if (isEmpty()) {
			System.out.println("The stack is already Empty");
			return -1;
		} else {
			int oldTop = top;
			top--;
			return stackArray[oldTop];
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public long peak() {
		return stackArray[top];
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}
}
