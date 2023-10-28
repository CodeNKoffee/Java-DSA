/**
 * 1381. Design a Stack With Increment Operation
 * Design a stack that supports increment operations on its elements.
 */
public class CustomStack {
  private ArrayStack stack;
  private int maxSize;
  private int[] increments;

  /**
   * Initializes the object with maxSize, which is the maximum number of elements in the stack.
   */
  public CustomStack(int maxSize) {
    this.maxSize = maxSize;
    stack = new ArrayStack(maxSize);
    increments = new int[maxSize];
  }

  /**
   * Adds x to the top of the stack if the stack has not reached the maxSize.
   */
  public void push(int x) {
    if (stack.size() < maxSize) 
      stack.push(x);
  }

  /**
   * Pops and returns the top of the stack or -1 if the stack is empty.
   */
  public int pop() {
    if (stack.isEmpty()) 
      return -1;

    int index = stack.size() - 1;
    int increment = increments[index];
    increments[index] = 0;
    return stack.pop() + increment;
  }

  /**
   * Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
   */
  public void increment(int k, int val) {
    int index = Math.min(k, stack.size()) - 1;
    if (index >= 0) 
      increments[index] += val;

  }

  /**
   * Testing method to verify the functionality of the CustomStack class.
   */
  public static void testCustomStack() {
    CustomStack stk = new CustomStack(3);
    // Stack is Empty []
    stk.push(1); // stack becomes [1]
    stk.push(2); // stack becomes [1, 2]
    stk.pop(); // return 2 --> Return top of the stack 2, stack becomes [1]
    stk.push(2); // stack becomes [1, 2]
    stk.push(3); // stack becomes [1, 2, 3]
    stk.push(4); // stack still [1, 2, 3], Do not add another elements as size is 4
    stk.increment(5, 100); // stack becomes [101, 102, 103]
    stk.increment(2, 100); // stack becomes [201, 202, 103]
    stk.pop(); // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    stk.pop(); // return 202 --> Return top of the stack 202, stack becomes [201]
    stk.pop(); // return 201 --> Return top of the stack 201, stack becomes []
    int result = stk.pop(); // return -1 --> Stack is empty return -1.
    System.out.println("Last pop result: " + result);
  }

  public static void main(String[] args) {
    testCustomStack();
  }

  /**
   * The invariant in this code is that we maintain an array `increments` that stores the increments for each element in the stack.
   * When an element is popped, the increment is applied, and when an increment operation is called, it is applied to the appropriate element.
   * This ensures that the bottom `k` elements are incremented as required.
   */
}
