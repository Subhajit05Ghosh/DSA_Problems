package ds.stack;

public class Main {

	public static void main(String[] args) {
		Stack theStack = new Stack(3);
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);

		while (!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.println(value);
		}

	}

}
