package ds.queue;

public class Queue {
	private int maxSize; // initializes the set number of slots
	private long[] queArray; // slots to maintain the data
	private int front; // this will be the index position for the element in the front
	private int rear; // this is the index position for the element at the back of the line
	private int nItems; // counter to maintain the number of items in our queue

	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[size];
		this.front = 0; // index position of the first slot of the Array
		this.rear = -1; // there is no item in the Array yet to be considered as last item
		this.nItems = 0; // we don't have elements in the Array
	}

	public void insert(long j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		rear++;
		queArray[rear] = j;
	}

	public void view() {
		System.out.print("[ ");
		for (int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.print(" ]");
	}

	public long remove() {
		long temp = queArray[front];
		front++;
		if (front == maxSize) {
			front = 0; //we can set front back to 0yh index so that we can utilize the entire Array again			
		}
		nItems--;
		return temp;
	}

	public long peekFont() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}
}
