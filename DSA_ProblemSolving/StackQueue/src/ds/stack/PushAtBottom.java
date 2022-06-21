package ds.stack;

import java.util.*;
import java.util.Stack;


public class PushAtBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        pushAtBottom(stack, 4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        pushAtBottom(stack, data);
        stack.push(temp);
    }
}