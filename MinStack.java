/** 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */

import java.util.Stack;

class MinStack {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty() || val <= minStack.peek()) 
      minStack.push(val);

  }

  public void pop() {
    if (!stack.isEmpty()) {
      if (stack.peek().equals(minStack.peek())) 
        minStack.pop();
      
      stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();

    // Test push method
    minStack.push(3);
    minStack.push(2);
    minStack.push(5);

    // Test top and getMin methods
    System.out.println("Top element: " + minStack.top()); // Expected: 5
    System.out.println("Minimum element: " + minStack.getMin()); // Expected: 2

    // Test pop method
    minStack.pop();
    System.out.println("Top element after pop: " + minStack.top()); // Expected: 2
    System.out.println("Minimum element after pop: " + minStack.getMin()); // Expected: 2
  }
}

/**
 * The invariant in this code is that the `minStack` keeps track of the minimum elements in the stack.
 */ 
